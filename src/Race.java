public class Race {

    private int numberOfParticipants;
    Judge judge = new Judge();
    Thread[] threads = new Thread[numberOfParticipants];

    public Race(int numberOfParticipants) {
        this.numberOfParticipants = numberOfParticipants;
    }

    public void createParticipants() {
        for (int i = 0; i < numberOfParticipants; i++) {
            threads[i] = new Thread(new Ship("Astronave" + (i+1), judge));
            threads[i].start();
        }
    }

    public void racing() {

    }


}
