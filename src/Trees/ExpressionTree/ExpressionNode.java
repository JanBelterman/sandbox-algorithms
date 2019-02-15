package Trees.ExpressionTree;

import Trees.BNode;

public class ExpressionNode extends BNode<String> {

    public ExpressionNode(String s) {
        super(s);
    }

    public int calculate(ExpressionNode node) {
        String element = node.getUserObject();
        if (tryParseInt(element)) {
            return Integer.parseInt(element);
        }
        int answer = 0;
        switch(element) {
            case "+": answer = calculate((ExpressionNode) node.getLeftChild()) + calculate((ExpressionNode) node.getRightChild()); break;
            case "-": answer = calculate((ExpressionNode) node.getLeftChild()) - calculate((ExpressionNode) node.getRightChild()); break;
            case "*": answer = calculate((ExpressionNode) node.getLeftChild()) * calculate((ExpressionNode) node.getRightChild()); break;
            case "/": answer = calculate((ExpressionNode) node.getLeftChild()) / calculate((ExpressionNode) node.getRightChild()); break;
        }
        return answer;
    }

    private boolean tryParseInt(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
