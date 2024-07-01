package de.evoal.optimisation.ea.main.codec.program.rewriters;

import de.evoal.optimisation.ea.main.codec.program.operations.DivideOperation;
import de.evoal.optimisation.ea.main.codec.program.operations.MultiplyOperation;
import io.jenetics.ext.util.TreeNode;
import io.jenetics.prog.op.Const;
import io.jenetics.prog.op.EphemeralConst;
import io.jenetics.prog.op.Op;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;


@Slf4j
public class ConstantDivideRewriter extends Rewriter<DivideOperation> {
    public ConstantDivideRewriter() {
        super(DivideOperation.class);
    }

    @Override
    public int apply(final TreeNode<Op<Double>> tree, final DivideOperation content) {
        final Optional<Double> left = toConstantValue(tree.childAt(0));
        final Optional<Double> right = toConstantValue(tree.childAt(1));

        if(left.isEmpty() || right.isEmpty()) {
            return 0;
        }

        final Op<Double> replacement = Const.of(left.get() / right.get());

        log.info("Rewriting {} to {}", tree, replacement);
        tree.value(replacement);
        tree.remove(1);
        tree.remove(0);

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
