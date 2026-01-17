import java.io.*;
import java.util.ArrayList;

public class FileManager {
    private String fileName;
    
    public FileManager(String fileName) {
        this.fileName = fileName;
    }
    
    public void writeShipsData(ArrayList<Ship> ships) {
        try {
            FileWriter fw = new FileWriter(fileName, false);
            BufferedWriter writer = new BufferedWriter(fw);
            writer.write("DATI ASTRONAVI");
            writer.newLine();
            writer.newLine();
            
            for (Ship s : ships) {
                writer.write("Astronave: " + s.getType());
                writer.newLine();
                writer.write("Pilota: " + s.getPilot());
                writer.newLine();
                writer.write("Destinazione: " + s.getDestination());
                writer.newLine();
                writer.write("Velocità: " + s.getSpeed() + " km/s");
                writer.newLine();
                writer.newLine();
            }
            
            writer.close();
            System.out.println("Dati dell'astronave scritti nel file: " + fileName);
        } catch (IOException e) {
            System.err.println("Errore nella scrittura dei dati dell'astronave!!!");
        }
    }
    
    public void writeRanking(ArrayList<Ship> ranking, String destinationPlanet) {
        try {
            FileWriter fw = new FileWriter(fileName, false);
            BufferedWriter writer = new BufferedWriter(fw);
            writer.write("CLASSIFICA FINALE");
            writer.newLine();
            writer.write("Destinazione: " + destinationPlanet);
            writer.newLine();
            writer.newLine();
            
            for (int i = 0; i < ranking.size(); i++) {
                Ship s = ranking.get(i);
                writer.write((i + 1) + " posto: " + s.getType() + " (Pilota: " + s.getPilot() + ")");
                writer.newLine();
            }
            
            writer.newLine();
            writer.close();
            System.out.println("Classifica scritta nel file: " + fileName);
        } catch (IOException e) {
            System.err.println("Errore nella scrittura della classifica!!!");
        }
    }
    
    public void readFile() {
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader reader = new BufferedReader(fr);
            String line;
            
            System.out.println("CONTENUTO DEL FILE: " + fileName);
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            
            reader.close();
        } catch (FileNotFoundException e) {
            System.err.println("File non trovato: " + fileName);
        } catch (IOException e) {
            System.err.println("Errore nella lettura del file!!!");
        }
    }
}