package Vista;

import Modelo.Simulacion;
import Modelo.Plate;
import Modelo.Simulacion;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private Simulacion simulation;
    private PlatePanel platePanel;

    public MainFrame() {
        setTitle("Bacteria Simulation");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        simulation = new Simulacion();
        platePanel = new PlatePanel(simulation.getPlate());

        JButton simulateButton = new JButton("Simulate Day");
        simulateButton.addActionListener(e -> {
            simulation.run(1);
            platePanel.repaint();
        });

        add(platePanel, BorderLayout.CENTER);
        add(simulateButton, BorderLayout.SOUTH);
    }
}
