class Consumer implements Runnable {
    private final Storage storage;
    private final int totalItemsToConsume;

    public Consumer(Storage storage, int totalItemsToConsume) {
        this.storage = storage;
        this.totalItemsToConsume = totalItemsToConsume;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < totalItemsToConsume; i++) {
                storage.takeItem();
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Consumer thread interrupted.");
        }
    }
}