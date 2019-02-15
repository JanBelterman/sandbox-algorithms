package Trees.TreeDepth;

import Trees.BNode;

public class DepthNode extends BNode<String> {

    public DepthNode(String s) {
        super(s);
    }

    public int depth(DepthNode node) {
        int leftDepth;
        int rightDepth;

        // Get both depths
        // Binary search tree so: always has 2 children (1 check for both is enough)
        if (node.getLeftChild() == null) leftDepth = 0;
        else leftDepth = 1 + depth((DepthNode) node.getLeftChild());
        if (node.getRightChild() == null) rightDepth = 0;
        else rightDepth = 1 + depth((DepthNode) node.getRightChild());

        // Return biggest depth
        return Math.max(leftDepth, rightDepth);
    }

}
