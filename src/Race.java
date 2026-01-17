import java.util.Scanner;

public class Race {
    private Judge judge;
    private Scanner scanner;

    public Race() {
        this.scanner = new Scanner(System.in);
    }

    public void setupRace() {  
        System.out.print("Inserisci il pianeta di destinazione: ");
        String destination = scanner.nextLine();
        
        System.out.print("Inserisci la distanza del pianeta in km: ");
        int distance = scanner.nextInt();
        scanner.nextLine();
        
        judge = new Judge(destination, distance);
        
        System.out.print("Quanti partecipanti ci sono nella gara? ");
        int numShips = scanner.nextInt();
        scanner.nextLine();
        
        createParticipants(numShips, destination);
    }

    private void createParticipants(int numShips, String destination) {
        for (int i = 1; i <= numShips; i++) {
            System.out.println("Partecipante " + i + ":");
            
            System.out.print("Modello astronave: ");
            String shipType = scanner.nextLine();
            
            System.out.print("Nome pilota: ");
            String pilot = scanner.nextLine();
            
            Ship ship = new Ship(shipType, i, pilot, judge, destination, 0);
            judge.addShip(ship);
        }
    }

    public void start() {
        System.out.println("INIZIO GARA");
        judge.startRace();
        judge.waitForFinish();
        
        scanner.close();
    }
}