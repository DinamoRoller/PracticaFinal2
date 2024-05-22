package Modelo;

import java.util.Random;

public class Bacteria {
    private static final Random random = new Random();

    private boolean alive = true;
    private int foodEaten = 0;

    public boolean isAlive() {
        return alive;
    }

    public int getFoodEaten() {
        return foodEaten;
    }

    public void simulate(int foodInCell) {
        for (int i = 0; i < 10; i++) {
            if (!alive) break;
            if (foodInCell >= 100) {
                foodInCell -= 20;
                foodEaten += 20;
                processAction(random.nextInt(100), 3, 60, 100);
            } else if (foodInCell >= 10) {
                foodInCell -= 10;
                foodEaten += 10;
                processAction(random.nextInt(100), 6, 20, 100);
            } else {
                processAction(random.nextInt(100), 20, 60, 100);
            }
        }
    }

    private void processAction(int rand, int dieChance, int stayChance, int moveChance) {
        if (rand < dieChance) {
            alive = false;
        } else if (rand < stayChance) {
            // Stay in place
        } else if (rand < moveChance) {
            // Move to a random neighboring cell
        }
    }

    public Bacteria[] reproduce() {
        if (foodEaten >= 150) {
            return new Bacteria[]{new Bacteria(), new Bacteria(), new Bacteria()};
        } else if (foodEaten >= 100) {
            return new Bacteria[]{new Bacteria(), new Bacteria()};
        } else if (foodEaten >= 50) {
            return new Bacteria[]{new Bacteria()};
        } else {
            return new Bacteria[0];
        }
    }
}
