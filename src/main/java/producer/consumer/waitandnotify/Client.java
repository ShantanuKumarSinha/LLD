package producer.consumer.waitandnotify;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
  public static void main(String[] args) {
    Store store = new Store(5);
    ExecutorService executorService = Executors.newCachedThreadPool();
    Producer producer = new Producer(store);
    Consumer consumer = new Consumer(store);

    for (int i = 0; i < 10; i++) {
      executorService.execute(producer);
    }
    for (int i = 0; i < 20; i++) {
      executorService.execute(consumer);
    }
    executorService.shutdown();
  }
}
