package de.evoal.optimisation.ea.main.codec.program.rewriters;

import de.evoal.optimisation.ea.main.codec.program.operations.DivideOperation;
import de.evoal.optimisation.ea.main.codec.program.operations.MultiplyOperation;
import de.evoal.optimisation.ea.main.codec.program.operations.PowOperation;
import io.jenetics.ext.util.TreeNode;
import io.jenetics.prog.op.Const;
import io.jenetics.prog.op.EphemeralConst;
import io.jenetics.prog.op.Op;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;


@Slf4j
public class PowerRewriter extends Rewriter<MultiplyOperation> {
    public PowerRewriter() {
        super(MultiplyOperation.class);
    }

    @Override
    public int apply(final TreeNode<Op<Double>> tree, final MultiplyOperation content) {
        final TreeNode<Op<Double>> left = tree.childAt(0);
        final TreeNode<Op<Double>> right = tree.childAt(1);

        if(!left.equals(right)) {
            return 0;
        }

        log.info("Rewriting {} to pow( {}, 2 )", tree, tree);

        tree.value(new PowOperation());
        tree.replace(1, TreeNode.of(Const.of(2.0)));

        return 1;
    }

    private Optional<Double> toConstantValue(final TreeNode<Op<Double>> tree) {
        if (!tree.isLeaf()) {
            return Optional.empty();
        }

        final Op<Double> op = tree.value();

        if(op instanceof Const<Double>) {
            return Optional.of(((Const<Double>)op).value());
        }

        if(op instanceof EphemeralConst<Double>) {
            return Optional.of(((EphemeralConst<Double>)op).value());
        }

        return Optional.empty();
    }
}
