package Trees.RecursiveFractalTree;

import javax.swing.*;
import java.awt.*;

public class RecursiveFractalTreeDriver extends JFrame {

    private RecursiveFractalTreeDriver() {
        super("Fractal Tree");
        init();
    }

    private void init() {
        setBounds(100, 100, 800, 600);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        drawTree(g, 400, 500, -90, 10);
    }

    private void drawTree(Graphics g, int currentX, int currentY, double angle, int depth) {
        if (depth == 0) return; // Stop criterion
        double length = depth * 7.0; // Calculates length of branches
        int newX = currentX + (int) (Math.cos(Math.toRadians(angle)) * length);
        int newY = currentY + (int) (Math.sin(Math.toRadians(angle)) * length);
        g.drawLine(currentX, currentY, newX, newY);
        drawTree(g, newX, newY, angle - 20, depth - 1); // Draw new branch
        drawTree(g, newX, newY, angle + 20, depth - 1); // Draw new branch
    }

    public static void run() {
        new RecursiveFractalTreeDriver().setVisible(true);
    }

}
