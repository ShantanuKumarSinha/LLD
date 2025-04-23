package ProducerConsumerSemaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Client {
  public static void main(String[] args) {
    ExecutorService es = Executors.newCachedThreadPool();
    Semaphore sp = new Semaphore(5);
    Semaphore sc = new Semaphore(0);
    Store store = new Store(5);

    for (int i = 1; i <= 8; i++) {
      es.execute(new Producer(store, sp, sc));
    }

    for (int i = 1; i <= 20; i++) {
      es.execute(new Consumer(store, sp, sc));
    }
  }
}
