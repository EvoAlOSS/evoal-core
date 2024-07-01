package de.evoal.optimisation.ea.main.codec.program.rewriters;

import de.evoal.optimisation.ea.api.codec.program.Operation;
import io.jenetics.ext.rewriting.TreeRewriter;
import io.jenetics.ext.util.TreeNode;
import io.jenetics.prog.op.Op;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class Rewriter<T extends Operation> implements TreeRewriter<Op<Double>> {
    private  Class<T> nodeType;

    Rewriter(final Class<T> nodeType) {
        this.nodeType = nodeType;
    }

    public abstract int apply(final TreeNode<Op<Double>> tree, final T content);

    public int rewrite(final TreeNode<Op<Double>> tree, final int limit) {
        final Op<Double> operation = tree.value();

        // first rewrite children
        if(!operation.isTerminal()) {
            for(int i = 0; i < operation.arity(); ++i) {
                rewrite(tree.childAt(i), limit);
            }
        }

        // apply to current node if matching
        if(nodeType.isInstance(tree.value())) {
            return apply(tree, nodeType.cast(tree.value()));
        }

        return 0;
    }
}
