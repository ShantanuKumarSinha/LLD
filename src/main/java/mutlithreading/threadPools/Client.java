package mutlithreading.threadPools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
  public static void main(String[] args) throws InterruptedException {
    ExecutorService executorService = Executors.newFixedThreadPool(10);
    for (int i = 1; i <= 1000; i++) {
      NumberPrinter numberPrinter = new NumberPrinter(i);
      if(i==80)
          continue;
      executorService.execute(numberPrinter);
    }
    executorService.shutdown();
  }
}
