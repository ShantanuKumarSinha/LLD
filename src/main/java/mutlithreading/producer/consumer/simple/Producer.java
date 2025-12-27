package mutlithreading.producer.consumer.simple;

public class Producer implements Runnable {

  private Store store;

  public Producer(Store store) {
    this.store = store;
  }

  @Override
  public void run() {
    while (true) {
      synchronized (store) {
        while (store.getItems().size() < store.getMaxSize()) {
          store.addItem();
        }
      }
    }
  }
}
