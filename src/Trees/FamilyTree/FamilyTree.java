package Trees.FamilyTree;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree<T extends FamilyAble> {

    private NNode<T> fatherAncestor;
    private NNode<T> motherAncestor;

    public void setFatherAncestor(NNode<T> node) {
        fatherAncestor = node;
    }
    public void setMotherAncestor(NNode<T> node) {
        motherAncestor = node;
    }

    // Get all familyAble without children
    public List<T> searchFamilyAbleWithoutChildren() {

        List<T> list = new ArrayList<>();

        fatherAncestor.searchFamilyAbleWithoutChildren(list);
        motherAncestor.searchFamilyAbleWithoutChildren(list);

        return list;

    }

    // Get all familyAble passed away
    public List<T> searchFamilyAblePassedAway() {

        List<T> list = new ArrayList<>();

        fatherAncestor.searchFamilyAblePassedAway(list);
        motherAncestor.searchFamilyAblePassedAway(list);

        return list;

    }

    // Get mother of given familyAble
    public T getMotherOfPerson(T familyAble) throws FileNotFoundException {

        NNode<T> found = fatherAncestor.searchFamilyAble(familyAble);
        if (found == null) motherAncestor.searchFamilyAble(familyAble);

        if (found == null) throw new FileNotFoundException("Person not found");

        return found.getMother().getSelf();

    }

    // Get all cousins of given familyAble
    public List<T> getCousinsOfPerson(T familyAble) throws FileNotFoundException {

        // Get person
        NNode<T> found = fatherAncestor.searchFamilyAble(familyAble);
        if (found == null) found = motherAncestor.searchFamilyAble(familyAble);

        // If no familyAble is found throw exception
        if (found == null) throw new FileNotFoundException("Person not found");

        // Get uncles and aunts
        List<NNode<T>> unclesAndAunts = new ArrayList<>();
        unclesAndAunts.addAll(found.getMother().getMother().getChildren()); // Get uncles and aunts from mothers mother side
        unclesAndAunts.addAll(found.getMother().getFather().getChildren()); // Get uncles and aunts from mothers father side
        unclesAndAunts.addAll(found.getFather().getMother().getChildren()); // Get uncles and aunts from fathers mother side
        unclesAndAunts.addAll(found.getFather().getFather().getChildren()); // Get uncles and aunts from fathers father side

        List<T> directSiblings = new ArrayList<>();
        found.getMother().getChildren().forEach(item -> directSiblings.add(item.getSelf()));
        found.getFather().getChildren().forEach(item -> directSiblings.add(item.getSelf()));

        // Get cousins
        List<T> cousins = new ArrayList<>();
        for (NNode<T> person : unclesAndAunts) {
            // Loop children of uncles and aunts (cousins)
            for (NNode<T> cousin : person.getChildren()) {
                // Check for duplicates
                // Check cousin is not the person self
                // Check cousin is not a brother or sister
                if (!cousins.contains(cousin.getSelf())
                        && !familyAble.equals(cousin.getSelf())
                        && !directSiblings.contains(cousin.getSelf())) {
                    cousins.add(cousin.getSelf());
                }
            }
        }

        return cousins;

    }

}
