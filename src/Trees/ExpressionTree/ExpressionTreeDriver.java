package Trees.ExpressionTree;

public class ExpressionTreeDriver {

    public static void run() {

        ExpressionNode nodeA, nodeB, nodeC, nodeD,
                nodeE, nodeF, nodeG, nodeH, nodeI;

        // 3 * 4 + 5 * (6 + 7) = 77
        nodeA = new ExpressionNode("+");
        nodeB = new ExpressionNode("*");
        nodeC = new ExpressionNode("*");
        nodeD = new ExpressionNode("3");
        nodeE = new ExpressionNode("4");
        nodeF = new ExpressionNode("5");
        nodeG = new ExpressionNode("+");
        nodeH = new ExpressionNode("6");
        nodeI = new ExpressionNode("7");

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

        System.out.println(nodeA.calculate(nodeA));

    }

}
