import java.util.Random;

public class Ship implements Runnable {
    private String name;
    private Judge judge;
    private int speed;

    Random random = new Random();

    public Ship(String name, Judge judge) {
        this.name = name;
        this.speed = random.nextInt(100) + 1;
    }

    @Override
    public void run() {

    }
}