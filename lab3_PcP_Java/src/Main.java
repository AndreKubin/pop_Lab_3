public class Main {
    public static void main(String[] args) {
        int storageCapacity = 3;
        int totalItemsToProduce = 10;
        int producersNumber = 3;
        int consumersNumber = 2;

        Storage storage = new Storage(storageCapacity);

        for (int i = 0; i < producersNumber; i++) {
            Thread producerThread = new Thread(new Producer(storage, totalItemsToProduce, i + 1), "Producer " + (i + 1));
            producerThread.start();
        }

        for (int i = 0; i < consumersNumber; i++) {
            Thread consumerThread = new Thread(new Consumer(storage, totalItemsToProduce * producersNumber), "Consumer " + (i + 1));
            consumerThread.start();
        }
    }
}
