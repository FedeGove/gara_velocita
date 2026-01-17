import java.util.ArrayList;

public class Judge {
    
    private String finalPlanet;
    private int planetDistance;
    private boolean started = false;
    
    private ArrayList<Ship> ships;
    private ArrayList<Thread> threads;
    private ArrayList<Ship> ranking;
    private FileManager fileManager;

    public Judge(String finalPlanet, int planetDistance) {
        this.finalPlanet = finalPlanet;
        this.planetDistance = planetDistance;
        this.ships = new ArrayList<>();
        this.threads = new ArrayList<>();
        this.ranking = new ArrayList<>();
        this.fileManager = new FileManager("race_results.txt");
    }

    public void addShip(Ship ship) {
        ships.add(ship);
    }

    public void startRace() {
        
        System.out.println("La gara verso: " + finalPlanet + " è iniziata!");
        System.out.println("Partecipanti: " + ships.size());
        
        fileManager.writeShipsData(ships);

        for (Ship ship : ships) {
            Thread thread = new Thread(ship);
            threads.add(thread);
            thread.start();
        }

        try {
            Thread.sleep(3000);

            started = true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }    

    public void waitForFinish() {
        for (Thread thread : threads) {
            try {
                thread.join();
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
        
        fileManager.writeRanking(ranking, finalPlanet);
        
        System.out.println();
        fileManager.readFile();
    }

    public int getPlanetDistance() {
        return planetDistance;
    }

    public String getFinalPlanet() {
        return finalPlanet;
    }
}