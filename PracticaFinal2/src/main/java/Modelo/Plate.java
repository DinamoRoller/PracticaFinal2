package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Plate {
    private static final int SIZE = 50;
    private int[][] food;
    private List<Bacteria>[][] bacteria;

    public Plate() {
        food = new int[SIZE][SIZE];
        bacteria = new ArrayList[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                food[i][j] = 100;
                bacteria[i][j] = new ArrayList<>();
            }
        }
        initializeBacteria();
    }

    private void initializeBacteria() {
        for (int i = 23; i < 27; i++) {
            for (int j = 23; j < 27; j++) {
                for (int k = 0; k < 4; k++) {
                    bacteria[i][j].add(new Bacteria());
                }
            }
        }
    }

    public void simulateDay() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                List<Bacteria> newBacteria = new ArrayList<>();
                for (Bacteria b : bacteria[i][j]) {
                    b.simulate(food[i][j]);
                    if (b.isAlive()) {
                        newBacteria.add(b);
                        for (Bacteria offspring : b.reproduce()) {
                            newBacteria.add(offspring);
                        }
                    }
                }
                bacteria[i][j] = newBacteria;
            }
        }
    }

    public int[][] getBacteriaCount() {
        int[][] counts = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                counts[i][j] = bacteria[i][j].size();
            }
        }
        return counts;
    }
}
