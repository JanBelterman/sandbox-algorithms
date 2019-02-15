package Trees.TreeDepth;

public class TreeDepthDriver {

    public static void run() {

        DepthNode nodeA, nodeB, nodeC, nodeD,
                nodeE, nodeF, nodeG, nodeH, nodeI;

        // 3 * 4 + 5 * (6 + 7) = 77
        nodeA = new DepthNode("+");
        nodeB = new DepthNode("*");
        nodeC = new DepthNode("*");
        nodeD = new DepthNode("3");
        nodeE = new DepthNode("4");
        nodeF = new DepthNode("5");
        nodeG = new DepthNode("+");
        nodeH = new DepthNode("6");
        nodeI = new DepthNode("7");

        // 3 * 4 + 5 * (6 + 7)
        nodeA.add(nodeB);
        nodeA.add(nodeC);

        // 3 * 4
        nodeB.add(nodeD);
        nodeB.add(nodeE);

        // 5 * (6 + 7)
        nodeC.add(nodeF);
        nodeC.add(nodeG);

        // 6 + 7
        nodeG.add(nodeH);
        nodeG.add(nodeI);

        System.out.println(nodeA.depth((nodeA)));

    }

}
