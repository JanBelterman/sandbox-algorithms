package Trees;

public class BNode<E> {

    protected BNode<E> parent, leftChild, rightChild;
    protected E userObject;
    enum ChildIndex { LEFT, RIGHT }

    public BNode(E userObject) {
        parent = null;
        leftChild = null;
        rightChild = null;
        this.userObject = userObject;
    }

    public String toString() {
        return userObject.toString();
    }

    public E getUserObject() {
        return userObject;
    }

    public BNode<E> getParent() {
        return parent;
    }

    public BNode<E> getLeftChild() {
        return leftChild;
    }

    public BNode<E> getRightChild() {
        return rightChild;
    }

    // non-safe
    public void setRightChild(BNode<E> node) {
        rightChild = node;
    }

    // non-safe
    public void setLeftChild(BNode<E> node) {
        leftChild = node;
    }

    // non-safe
    public void setParent(BNode<E> node) {
        parent = node;
    }


    // safely add a new node to this, first try as left child, otherwise as right child
    public void add(BNode<E> newChild) {
        if (leftChild == null)
            insert(newChild, ChildIndex.LEFT);
        else if (rightChild == null)
            insert(newChild, ChildIndex.RIGHT);
        else
            throw new IllegalArgumentException(
                    "more than 2 children");
    }

    // safely add a new node to this as left or right child
    public void insert(BNode<E> newChild, ChildIndex childIndex) {
        if (isAncestor(newChild))
            throw new IllegalArgumentException(
                    "new child is ancestor");
        if (childIndex != ChildIndex.LEFT &&
                childIndex != ChildIndex.RIGHT)
            throw new IllegalArgumentException(
                    "index is not 0 or 1");

        if (newChild != null) {
            BNode<E> oldParent = newChild.getParent();
            if (oldParent != null)
                oldParent.remove(newChild);
        }

        newChild.parent = this;
        if (childIndex == ChildIndex.LEFT)
            leftChild = newChild;
        else
            rightChild = newChild;
    }

    public void remove(BNode<E> aChild) {
        if (aChild == null)
            throw new IllegalArgumentException(
                    "argument is null");

        if (!isChild(aChild))
            throw new IllegalArgumentException(
                    "argument is not a child");

        if (aChild == leftChild) {
            leftChild.parent = null;
            leftChild = null;
        } else {
            rightChild.parent = null;
            rightChild = null;
        }
    }

    public boolean isChild(BNode<E> aNode) {
        return aNode == null ?
                false :
                aNode.getParent() == this;
    }

    public boolean isAncestor(BNode<E> aNode) {
        BNode<E> ancestor = this;
        while (ancestor != null && ancestor != aNode)
            ancestor = ancestor.getParent();
        return ancestor != null;
    }

}
