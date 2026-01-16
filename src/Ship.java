import java.util.Random;

public class Ship extends Thread{
    private String type;
    private String pilot;
    private String destination;
    
    private Judge judge;
    private int shipId;
    private int distanceTraveled = 0;
    private int speed;

    private boolean inRace = true;

    Random random = new Random();

    public Ship(String type, int shipId, String pilot, Judge judge, String destination, int speed) {
        this.type = type;
        this.shipId = shipId;
        this.pilot = pilot;
        this.judge = judge;
        this.destination = destination;
        this.speed = random.nextInt(100) + 1;
    }

    @Override
    public void run() {
        System.out.println("Astronave " + type + " pilotata da " + pilot + " pronta per arrivare a " + destination);

        race();
    }

    private void race() {
        while (inRace && distanceTraveled < judge.getPlanetDistance()) {
            try {
                Thread.sleep(5000);

                distanceTraveled += speed;

                if (distanceTraveled >= judge.getPlanetDistance()) {
                distanceTraveled = judge.getPlanetDistance();
                inRace = false;
                System.out.println("Astronave " + type + " pilotata da " + pilot + " ha raggiunto " + destination + "!");
                judge.recordFinish(this);
                } else {
                System.out.println("Astronave " + type + " pilotata da " + pilot + " mancano " + (judge.getPlanetDistance() - distanceTraveled) + " km verso " + destination);
                }
            } catch (InterruptedException e) {
                inRace = false;
            }
        }
    }

    public int getShipId() {
        return shipId;
    }

    public String getType() {
        return type;
    }

    public String getPilot() {
        return pilot;
    }

    public String getDestination() {
        return destination;
    }

    public int getSpeed() {
        return speed;
    }

    public int getDistanceTraveled() {
        return distanceTraveled;
    }
}
