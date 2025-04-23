package ProducerConsumerSemaphore;

import java.util.concurrent.Semaphore;

public class Producer implements Runnable {
  private Store store;
  private Semaphore producerSemaphore;
  private Semaphore consumerSemaphore;

  Producer(Store st, Semaphore sp, Semaphore sc) {
    this.store = st;
    this.producerSemaphore = sp;
    this.consumerSemaphore = sc;
    this.consumerSemaphore = sc;
  }

  @Override
  public void run() {
    while (true) {
      try {
        producerSemaphore.acquire();
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
      store.addItem();
      consumerSemaphore.release();
    }
  }
}
