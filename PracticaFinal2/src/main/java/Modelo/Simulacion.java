package Modelo;

public class Simulacion {
    private Plate plate;

    public Simulacion() {
        plate = new Plate();
    }

    public void run(int days) {
        for (int i = 0; i < days; i++) {
            plate.simulateDay();
        }
    }

    public Plate getPlate() {
        return plate;
    }
}
