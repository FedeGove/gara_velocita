import java.util.ArrayList;

public class Judge {
    
    private String finalPlanet;
    private int planetDistance;
    private boolean started = false;
    
    private ArrayList<Ship> ships;
    private ArrayList<Ship> ranking;

    public Judge(String finalPlanet, int planetDistance) {
        this.finalPlanet = finalPlanet;
        this.planetDistance = planetDistance;
        this.ships = new ArrayList<>();
        this.ranking = new ArrayList<>();
    }

    public void addShip(Ship ship) {
        ships.add(ship);
    }

    public void startRace() {
        
        System.out.println("La gara verso: " + finalPlanet + " è iniziata!");
        System.out.println("Partecipanti: " + ships.size());

        for (Ship ship : ships) {
            ship.start();
        }

        try {
            Thread.sleep(3000);

            started = true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }    

    public void waitForFinish() {
        for (Ship ship : ships) {
            try {
                ship.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void recordFinish(Ship ship) {
        ranking.add(ship);
        
        if (ranking.size() == ships.size()) {
            showFinalRanking();
        }

    }

    private void showFinalRanking() {
        System.out.println("La gara è terminata! Ecco la classifica finale: ");
        
        for (int i = 0; i < ranking.size(); i++) {
            Ship ship = ranking.get(i);
            System.out.println((i + 1) + "° posto: " + ship.getType() + " con pilota " + ship.getPilot());
        }

    }

    public int getPlanetDistance() {
        return planetDistance;
    }

    public String getFinalPlanet() {
        return finalPlanet;
    }
}