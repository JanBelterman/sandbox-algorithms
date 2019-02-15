package Trees.FamilyTree;

import java.util.Date;

public class FamilyTreeDriver {

    public static void run() {
        System.out.println("Family tree");

        // Create persons
        Person grandfather = new Person("Grandfather", new Date(894060000000L), false, "male");
        Person grandmother = new Person("Grandmother", new Date(894060000000L), false, "female");
        Person father = new Person("Father", new Date(894060000000L), true, "male");
        Person mother = new Person("Mother", new Date(894060000000L), false, "female");
        Person father2 = new Person("Father2", new Date(3476296432876L), true, "male");
        Person mother2 = new Person("Mother2", new Date(3248927349873L), true, "female");
        Person child1 = new Person("Child1", new Date(894060000000L), true, "male");
        Person child2 = new Person("Child2", new Date(894060000000L), true, "female");
        Person child3 = new Person("Child3", new Date(894060000000L), true, "female");

        // Create nodes
        NNode<Person> grandfatherNode = new NNode<>(grandfather);
        NNode<Person> grandMotherNode = new NNode<>(grandmother);
        NNode<Person> fatherNode = new NNode<>(father);
        NNode<Person> motherNode = new NNode<>(mother);
        NNode<Person> father2Node = new NNode<>(father2);
        NNode<Person> mother2Node = new NNode<>(mother2);
        NNode<Person> child1Node = new NNode<>(child1);
        NNode<Person> child2Node = new NNode<>(child2);
        NNode<Person> child3Node = new NNode<>(child3);

        // Add relations
        grandfatherNode.addChild(fatherNode);
        grandMotherNode.addChild(fatherNode);
        fatherNode.setFather(grandfatherNode);
        fatherNode.setMother(grandMotherNode);

        grandfatherNode.addChild(motherNode);
        grandMotherNode.addChild(motherNode);
        motherNode.setFather(grandfatherNode);
        motherNode.setMother(grandMotherNode);

        grandfatherNode.addChild(father2Node);
        grandMotherNode.addChild(father2Node);
        father2Node.setFather(grandfatherNode);
        father2Node.setMother(grandMotherNode);

        grandfatherNode.addChild(mother2Node);
        grandMotherNode.addChild(mother2Node);
        mother2Node.setFather(grandfatherNode);
        mother2Node.setMother(grandMotherNode);

        fatherNode.addChild(child1Node);
        motherNode.addChild(child1Node);
        child1Node.setFather(fatherNode);
        child1Node.setMother(motherNode);

        fatherNode.addChild(child2Node);
        motherNode.addChild(child2Node);
        child2Node.setFather(fatherNode);
        child2Node.setMother(motherNode);

        father2Node.addChild(child3Node);
        mother2Node.addChild(child3Node);
        child3Node.setFather(father2Node);
        child3Node.setMother(mother2Node);

        // Fill tree
        FamilyTree<Person> familyTree = new FamilyTree<>();
        familyTree.setFatherAncestor(grandfatherNode);
        familyTree.setMotherAncestor(grandMotherNode);

        // Test program
        try {

            System.out.println("Persons without children:");
            for (Person p : familyTree.searchFamilyAbleWithoutChildren()) {
                System.out.println(p);
            }
            System.out.println();

            System.out.println("Persons passed away:");
            for (Person p : familyTree.searchFamilyAblePassedAway()) {
                System.out.println(p);
            }
            System.out.println();

            System.out.println("Mother of person: " + child1.getName());
            System.out.println(familyTree.getMotherOfPerson(child1));
            System.out.println();

            System.out.println("Cousins of person: " + child2.getName());
            for (Person p : familyTree.getCousinsOfPerson(child2)) {
                System.out.println(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println();
    }

}
