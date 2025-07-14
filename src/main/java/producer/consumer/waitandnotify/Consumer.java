package producer.consumer.waitandnotify;

public class Consumer implements Runnable {

  private Store store;

  public Consumer(Store st) {
    this.store = st;
  }

  @Override
  public void run() {
    while (true) {
      synchronized (store) {
        if (store.getItems().size() > 0) {
          store.removeItem();
          store.notifyAll(); // Notify producers that an item has been removed
        } else {
          try {
            store.wait(); // Wait if the store is empty
          } catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
        }
      }
    }
  }
}
