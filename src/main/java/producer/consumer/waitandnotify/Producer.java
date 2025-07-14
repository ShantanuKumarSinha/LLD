package producer.consumer.waitandnotify;

public class Producer implements Runnable {

  private Store store;

  Producer(Store st) {
    this.store = st;
  }

  @Override
  public void run() {
    while (true) {
      synchronized (store) {
        if (store.getItems().size() < store.getMaxSize()) {
          store.addItem(new Object());
          store.notifyAll(); // Notify consumers that an item has been added
        } else {
          try {
            store.wait(); // Wait if the store is full
          } catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
        }
      }
    }
  }
}
