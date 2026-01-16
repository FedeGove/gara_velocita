public class Main {
    public static void main(String[] args) {
        Judge j = new Judge("Marte", 100);

        Ship s1 = new Ship("Falcon", 1, "Alice", j, "Marte", 0);
        Ship s2 = new Ship("Eagle", 2, "Bob", j, "Marte", 0);
        Ship s3 = new Ship("Hawk", 3, "Charlie", j, "Marte", 0);
        Ship s4 = new Ship("Raven", 4, "Diana", j, "Marte", 0);

        j.addShip(s1);
        j.addShip(s2);
        j.addShip(s3);
        j.addShip(s4);

        j.startRace();
        j.waitForFinish();
    }
}