package ProducerConsumerSemaphore;

import java.util.concurrent.Semaphore;

public class Consumer implements Runnable {
  private Store store;

  private Semaphore producerSemaphore;
  private Semaphore consumerSemaphore;

  Consumer(Store st, Semaphore sp, Semaphore sc) {
    this.store = st;
    this.producerSemaphore = sp;
    this.consumerSemaphore = sc;
  }

  @Override
  public void run() {
    while (true) {
      try {
        consumerSemaphore.acquire();
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }

      store.removeItem();
      producerSemaphore.release();
    }
  }
}
