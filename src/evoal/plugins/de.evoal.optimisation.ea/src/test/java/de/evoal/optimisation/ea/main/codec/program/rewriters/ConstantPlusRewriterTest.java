package de.evoal.optimisation.ea.main.codec.program.rewriters;


import de.evoal.optimisation.ea.main.codec.program.operations.PlusOperation;
import io.jenetics.ext.util.FlatTreeNode;
import io.jenetics.ext.util.Tree;
import io.jenetics.ext.util.TreeNode;
import io.jenetics.prog.op.Const;
import io.jenetics.prog.op.MathExpr;
import io.jenetics.prog.op.Op;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConstantPlusRewriterTest {

    @Test
    public void testAdditionOfSimpleConstants() {
        final TreeNode<Op<Double>> operation = TreeNode.of(new PlusOperation());
        final TreeNode<Op<Double>> left = TreeNode.of(Const.of(42.0));
        final TreeNode<Op<Double>> right = TreeNode.of(Const.of(42.0));

        operation.insert(0, left);
        operation.insert(1, right);

        new ConstantPlusRewriter().rewrite(operation, 100);

        Assertions.assertNotNull(operation.value());
        Assertions.assertEquals(Const.class, operation.value().getClass());
        Assertions.assertEquals(84.0, ((Const<Double>)operation.value()).value());
    }

    @Test
    public void testAdditionOfNestedConstants() {
        final TreeNode<Op<Double>> operation = TreeNode.of(new PlusOperation());
        final TreeNode<Op<Double>> left = TreeNode.of(Const.of(42.0));
        final TreeNode<Op<Double>> right = TreeNode.of(new PlusOperation());
        final TreeNode<Op<Double>> rightLeft = TreeNode.of(Const.of(42.0));
        final TreeNode<Op<Double>> rightRight = TreeNode.of(Const.of(42.0));

        operation.insert(0, left);
        operation.insert(1, right);
        right.insert(0, rightLeft);
        right.insert(1, rightRight);

        new ConstantPlusRewriter().rewrite(operation, 100);

        Assertions.assertNotNull(operation.value());
        Assertions.assertEquals(Const.class, operation.value().getClass());
        Assertions.assertEquals(126.0, ((Const<Double>)operation.value()).value());
    }
}
