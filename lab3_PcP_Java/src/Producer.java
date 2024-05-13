class Producer implements Runnable {
    private final Storage storage;
    private final int totalItemsToProduce;
    private final int producerId;

    public Producer(Storage storage, int totalItemsToProduce, int producerId) {
        this.storage = storage;
        this.totalItemsToProduce = totalItemsToProduce;
        this.producerId = producerId;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= totalItemsToProduce; i++) {
                int item = producerId + totalItemsToProduce + i; // створюємо унікальний елемент для кожного виробника
                storage.putItem(item);
                Thread.sleep(100); // симуляція виробництва
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Producer thread interrupted.");
        }
    }
}