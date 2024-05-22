package Vista;

import Modelo.Plate;

import javax.swing.*;
import java.awt.*;

public class PlatePanel extends JPanel {
    private Plate plate;

    public PlatePanel(Plate plate) {
        this.plate = plate;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int[][] counts = plate.getBacteriaCount();
        int cellSize = getWidth() / counts.length;

        for (int i = 0; i < counts.length; i++) {
            for (int j = 0; j < counts[i].length; j++) {
                int count = counts[i][j];
                g.setColor(getColorForCount(count));
                g.fillRect(i * cellSize, j * cellSize, cellSize, cellSize);
            }
        }
    }

    private Color getColorForCount(int count) {
        if (count >= 20) return Color.RED;
        if (count >= 15) return Color.MAGENTA;
        if (count >= 10) return Color.ORANGE;
        if (count >= 5) return Color.YELLOW;
        if (count >= 1) return Color.GREEN;
        return Color.WHITE;
    }
}
