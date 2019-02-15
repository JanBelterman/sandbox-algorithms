package Trees.BinarySearchTree;

import Trees.BNode;

public class BinarySearchNode extends BNode<Integer> {

    public BinarySearchNode(int value) {
        super(value);
    }

    public void addElement(int value) {
        if (value >= this.getUserObject()) {
            // Check right
            if (getRightChild() == null) {
                setRightChild(new BinarySearchNode(value));
            } else {
                BinarySearchNode right = (BinarySearchNode) rightChild;
                right.addElement(value);
            }
        } else {
            // Check left
            if (getLeftChild() == null) {
                setLeftChild(new BinarySearchNode(value));
            } else {
                BinarySearchNode left = (BinarySearchNode) leftChild;
                left.addElement(value);
            }
        }
    }

}
