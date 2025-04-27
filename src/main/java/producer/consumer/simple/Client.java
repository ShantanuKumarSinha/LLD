package producer.consumer.simple;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
  public static void main(String[] args) {
    ExecutorService executorService = Executors.newCachedThreadPool();
    Store store = new Store(5);
    var consumer = new Consumer(store);
    var producer = new Producer(store);
    for (int i = 0; i < 10; i++) {
      executorService.execute(producer);
    }
    for (int i = 0; i < 20; i++) {
      executorService.execute(consumer);
    }

    executorService.shutdown();
  }
}
