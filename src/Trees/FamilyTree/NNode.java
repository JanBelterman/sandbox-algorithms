package Trees.FamilyTree;

import java.util.ArrayList;
import java.util.List;

public class NNode<T extends FamilyAble> {

    private NNode<T> mother;
    private NNode<T> father;
    private T self;
    private List<NNode<T>> children;

    public NNode(T self) {
        mother = null;
        father = null;
        this.self = self;
        children = new ArrayList<>();
    }

    public void setMother(NNode<T> mother) {
        this.mother = mother;
    }
    public NNode<T> getMother() {
        return mother;
    }

    public void setFather(NNode<T> father) {
        this.father = father;
    }
    public NNode<T> getFather() {
        return father;
    }

    public T getSelf() {
        return self;
    }

    public List<NNode<T>> getChildren() {
        return children;
    }

    public void addChild(NNode<T> child) {
        children.add(child);
    }

    // Search parent node by T object
    public NNode<T> searchFamilyAble(T parent) {

        // Check self
        if(self.equals(parent)) return this;

        // Check children recursively
        for(NNode<T> node : children) {
            NNode<T> found = node.searchFamilyAble(parent);
            // If found return
            if (found != null) return found;
        }

        // Null if no parent is found
        return null;

    }

    public void searchFamilyAbleWithoutChildren(List<T> list) {

        // Check children (if any)
        for (NNode<T> child : children) {
            child.searchFamilyAbleWithoutChildren(list);
        }

        // Check self
        // Also prevent duplicates
        if (!hasChildren() && !list.contains(self)) list.add(self);

    }

    private boolean hasChildren() {
        return !children.isEmpty();
    }

    public void searchFamilyAblePassedAway(List<T> list) {

        // Check children (if any)
        for (NNode<T> child : children) {
            child.searchFamilyAblePassedAway(list);
        }

        // Check self
        // Also prevent duplicates
        if (!self.isAlive() && !list.contains(self)) list.add(self);

    }

}
