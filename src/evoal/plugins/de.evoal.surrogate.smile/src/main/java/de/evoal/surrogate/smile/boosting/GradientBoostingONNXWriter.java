package de.evoal.surrogate.smile.boosting;

import java.util.ArrayList;
import java.util.List;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

import lombok.NonNull;
import org.eclipse.emf.ecore.EStructuralFeature;
import smile.base.cart.InternalNode;
import smile.base.cart.Node;
import smile.base.cart.OrdinalNode;
import smile.base.cart.RegressionNode;
import smile.regression.GradientTreeBoost;
import smile.regression.RegressionTree;

import de.evoal.surrogate.api.function.ModelFunction;
import de.evoal.surrogate.api.io.onnx.AbstractONNXWriter;
import de.evoal.surrogate.api.io.onnx.IntervalONNXFunction;
import de.evoal.surrogate.api.io.onnx.OnnxConfiguration;
import de.evoal.surrogate.api.io.pson.Parameter;
import de.evoal.surrogate.api.io.pson.SurrogateConfiguration;
import de.evoal.surrogate.protobuf.AttributeProto;
import de.evoal.surrogate.protobuf.NodeProto;
import de.evoal.surrogate.protobuf.OperatorSetIdProto;
import de.evoal.surrogate.protobuf.TensorProto;
import de.evoal.surrogate.protobuf.TensorShapeProto;
import de.evoal.surrogate.protobuf.TypeProto;
import de.evoal.surrogate.protobuf.ValueInfoProto;

/**
 * Writes a 'gradient-boosting' model as an ONNX file. The graph computes the three models in
 *   double:
 * <ol>
 *   <li>{@code Concat}: the inputs (each {@code [1, 1]}) into {@code X [1, n]}, in the order of
 *     the input space;</li>
 *   <li>{@code TreeEnsemble} (ai.onnx.ml, opset {@value #ML_OPSET}): the trees of the three models
 *     as targets 0 (prediction), 1 (lower bound) and 2 (upper bound), summed; the weight of a
 *     leaf is shrinkage · leaf value;</li>
 *   <li>{@code Add}: the intercepts of the three models;</li>
 *   <li>{@code Split}: into the outputs {@code y}, {@code y.lower} and {@code y.upper} of the
 *     output y, each {@code [1, 1]}.</li>
 * </ol>
 * A node sends a row to its true branch iff {@code x[f] ≤ split value}, as Smile does; a missing
 *   value (NaN) takes the false branch in both. The values are not rearranged in the graph; the
 *   reader ({@link IntervalONNXFunction}) does that. The coverage and the point prediction are in
 *   the state of the model information.
 */
@Named("de.evoal.surrogate.smile.ml.gradient-boosting-writer-onnx")
@Dependent
public class GradientBoostingONNXWriter extends AbstractONNXWriter {
    /**
     * The domain of the tree operators.
     */
    static final String ML_DOMAIN = "ai.onnx.ml";

    /**
     * The opset of {@link #ML_DOMAIN}; {@code TreeEnsemble} needs 5.
     */
    static final long ML_OPSET = 5;

    /**
     * The mode of a node: {@code BRANCH_LEQ}.
     */
    private static final byte BRANCH_LEQ = 0;

    /**
     * {@code aggregate_function} of the ensemble: {@code SUM}.
     */
    private static final long SUM = 1;

    /**
     * {@code post_transform} of the ensemble: {@code NONE}.
     */
    private static final long NONE = 0;

    private static final String X = "X";
    private static final String SCORES = "scores";
    private static final String INTERCEPTS = "intercepts";
    private static final String VALUES = "values";

    @Override
    protected void toConfiguration(final @NonNull ModelFunction function, final @NonNull OnnxConfiguration configuration) {
        final GradientBoostingFunction boosting = (GradientBoostingFunction) function;
        final String y = boosting.getOutput().iterator().next().getName();
        final List<String> outputs = List.of(y, y + IntervalONNXFunction.LOWER, y + IntervalONNXFunction.UPPER);
        final List<GradientTreeBoost> models = List.of(boosting.getPrediction(), boosting.getLower(), boosting.getUpper());

        configuration.getModel()
                     .addOpsetImport(OperatorSetIdProto.newBuilder()
                                                       .setDomain(ML_DOMAIN)
                                                       .setVersion(ML_OPSET));

        final NodeProto.Builder concat = NodeProto.newBuilder()
                                                  .setOpType("Concat")
                                                  .addOutput(X)
                                                  .addAttribute(intAttribute("axis", 1));
        for(final EStructuralFeature feature : boosting.getInput()) {
            configuration.getGraph().addInput(value(feature.getName()));
            concat.addInput(feature.getName());
        }

        final Ensemble ensemble = new Ensemble(boosting.getShrinkage());
        for(int target = 0; target < models.size(); ++target) {
            for(final RegressionTree tree : models.get(target).trees()) {
                ensemble.addTree(tree.root(), target);
            }
        }

        final TensorProto.Builder intercepts = TensorProto.newBuilder()
                                                          .setName(INTERCEPTS)
                                                          .setDataType(TensorProto.DataType.DOUBLE.getNumber())
                                                          .addDims(1)
                                                          .addDims(models.size());
        models.forEach(model -> intercepts.addDoubleData(SmileInternals.intercept(model)));

        final NodeProto.Builder split = NodeProto.newBuilder()
                                                 .setOpType("Split")
                                                 .addInput(VALUES)
                                                 .addAttribute(intAttribute("axis", 1))
                                                 .addAttribute(intAttribute("num_outputs", outputs.size()));
        outputs.forEach(split::addOutput);

        configuration.getGraph()
                     .addInitializer(intercepts)
                     .addNode(concat)
                     .addNode(ensemble.toNode(models.size()))
                     .addNode(NodeProto.newBuilder()
                                       .setOpType("Add")
                                       .addInput(SCORES)
                                       .addInput(INTERCEPTS)
                                       .addOutput(VALUES))
                     .addNode(split);
        outputs.forEach(output -> configuration.getGraph().addOutput(value(output)));
    }

    @Override
    protected void toState(final @NonNull ModelFunction function, final @NonNull SurrogateConfiguration configuration) {
        final GradientBoostingFunction boosting = (GradientBoostingFunction) function;
        final EStructuralFeature output = boosting.getOutput().iterator().next();

        configuration.getState().add(Parameter.from(IntervalONNXFunction.COVERAGE, boosting.coverage(output)));
        configuration.getState().add(Parameter.from(IntervalONNXFunction.POINT_PREDICTION, boosting.getPointPrediction()));
    }

    /**
     * The attributes of the {@code TreeEnsemble} node, collected tree by tree. Inner nodes and
     *   leaves are numbered separately; a branch refers to a node or, if its leaf flag is 1, to a
     *   leaf.
     */
    private static final class Ensemble {
        private final double shrinkage;

        private final List<Long> roots = new ArrayList<>();

        private final List<Long> features = new ArrayList<>();
        private final List<Double> splits = new ArrayList<>();
        private final List<Long> trueIds = new ArrayList<>();
        private final List<Long> trueLeafs = new ArrayList<>();
        private final List<Long> falseIds = new ArrayList<>();
        private final List<Long> falseLeafs = new ArrayList<>();

        private final List<Long> leafTargets = new ArrayList<>();
        private final List<Double> leafWeights = new ArrayList<>();

        private Ensemble(final double shrinkage) {
            this.shrinkage = shrinkage;
        }

        /**
         * Adds a tree. A tree that is a single leaf gets a node {@code x[0] ≤ 0} whose two
         *   branches lead to that leaf, because a root has to be a node.
         */
        void addTree(final Node root, final int target) {
            if(root instanceof RegressionNode leaf) {
                final long index = newNode(0, 0.0);
                final long leafIndex = addLeaf(leaf, target);
                setBranches(index, leafIndex, true, leafIndex, true);
                roots.add(index);
                return;
            }

            roots.add(addNode((InternalNode) root, target));
        }

        /**
         * @return The index of the node.
         */
        private long addNode(final InternalNode node, final int target) {
            if(!(node instanceof OrdinalNode ordinal)) {
                throw new IllegalStateException("The gradient boosting model has a split on a nominal value (" + node.getClass().getSimpleName()
                                                + "), which the ONNX writer does not support.");
            }

            final long index = newNode(ordinal.feature(), SmileInternals.splitValue(ordinal));
            final Node trueChild = ordinal.trueChild();
            final Node falseChild = ordinal.falseChild();
            final long trueIndex = addChild(trueChild, target);
            final long falseIndex = addChild(falseChild, target);
            setBranches(index, trueIndex, trueChild instanceof RegressionNode, falseIndex, falseChild instanceof RegressionNode);

            return index;
        }

        private long addChild(final Node child, final int target) {
            if(child instanceof RegressionNode leaf) {
                return addLeaf(leaf, target);
            }

            return addNode((InternalNode) child, target);
        }

        private long newNode(final int feature, final double split) {
            features.add((long) feature);
            splits.add(split);
            trueIds.add(-1L);
            trueLeafs.add(0L);
            falseIds.add(-1L);
            falseLeafs.add(0L);

            return features.size() - 1;
        }

        private void setBranches(final long node, final long trueIndex, final boolean trueLeaf, final long falseIndex, final boolean falseLeaf) {
            final int i = (int) node;
            trueIds.set(i, trueIndex);
            trueLeafs.set(i, trueLeaf ? 1L : 0L);
            falseIds.set(i, falseIndex);
            falseLeafs.set(i, falseLeaf ? 1L : 0L);
        }

        private long addLeaf(final RegressionNode leaf, final int target) {
            leafTargets.add((long) target);
            leafWeights.add(shrinkage * leaf.output());

            return leafTargets.size() - 1;
        }

        NodeProto.Builder toNode(final int targets) {
            final TensorProto.Builder modes = TensorProto.newBuilder()
                                                         .setDataType(TensorProto.DataType.UINT8.getNumber())
                                                         .addDims(features.size());
            // uint8 values are stored as int32
            features.forEach(f -> modes.addInt32Data(BRANCH_LEQ));

            return NodeProto.newBuilder()
                            .setOpType("TreeEnsemble")
                            .setDomain(ML_DOMAIN)
                            .addInput(X)
                            .addOutput(SCORES)
                            .addAttribute(intAttribute("n_targets", targets))
                            .addAttribute(intAttribute("aggregate_function", SUM))
                            .addAttribute(intAttribute("post_transform", NONE))
                            .addAttribute(intsAttribute("tree_roots", roots))
                            .addAttribute(intsAttribute("nodes_featureids", features))
                            .addAttribute(tensorAttribute("nodes_splits", doubles(splits)))
                            .addAttribute(tensorAttribute("nodes_modes", modes))
                            .addAttribute(intsAttribute("nodes_truenodeids", trueIds))
                            .addAttribute(intsAttribute("nodes_trueleafs", trueLeafs))
                            .addAttribute(intsAttribute("nodes_falsenodeids", falseIds))
                            .addAttribute(intsAttribute("nodes_falseleafs", falseLeafs))
                            .addAttribute(intsAttribute("leaf_targetids", leafTargets))
                            .addAttribute(tensorAttribute("leaf_weights", doubles(leafWeights)));
        }
    }

    /**
     * @return A double tensor of shape {@code [1, 1]}.
     */
    private static ValueInfoProto value(final String name) {
        final TensorShapeProto.Dimension one = TensorShapeProto.Dimension.newBuilder().setDimValue(1).build();

        return ValueInfoProto.newBuilder()
                             .setName(name)
                             .setType(TypeProto.newBuilder()
                                               .setTensorType(TypeProto.Tensor.newBuilder()
                                                                              .setElemType(TensorProto.DataType.DOUBLE.getNumber())
                                                                              .setShape(TensorShapeProto.newBuilder()
                                                                                                        .addDim(one)
                                                                                                        .addDim(one))))
                             .build();
    }

    private static TensorProto.Builder doubles(final List<Double> values) {
        return TensorProto.newBuilder()
                          .setDataType(TensorProto.DataType.DOUBLE.getNumber())
                          .addDims(values.size())
                          .addAllDoubleData(values);
    }

    private static AttributeProto intAttribute(final String name, final long value) {
        return AttributeProto.newBuilder()
                             .setName(name)
                             .setType(AttributeProto.AttributeType.INT)
                             .setI(value)
                             .build();
    }

    private static AttributeProto intsAttribute(final String name, final List<Long> values) {
        return AttributeProto.newBuilder()
                             .setName(name)
                             .setType(AttributeProto.AttributeType.INTS)
                             .addAllInts(values)
                             .build();
    }

    private static AttributeProto tensorAttribute(final String name, final TensorProto.Builder tensor) {
        return AttributeProto.newBuilder()
                             .setName(name)
                             .setType(AttributeProto.AttributeType.TENSOR)
                             .setT(tensor)
                             .build();
    }
}
