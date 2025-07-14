package producer.consumer.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Client {
  public static void main(String[] args) {
    ExecutorService executorService = Executors.newCachedThreadPool();
    Store store = new Store(5);
    Semaphore producerSemaphore = new Semaphore(5);
    Semaphore consumerSemaphore = new Semaphore(0);

    var producer = new Producer(store, producerSemaphore, consumerSemaphore);
    var consumer = new Consumer(store, producerSemaphore, consumerSemaphore);
    for (int i = 1; i <=10; i++) {
      executorService.execute(producer);
    }
    for (int i = 1; i <=20; i++) {
      executorService.execute(consumer);
    }

    executorService.shutdown();
  }
}
