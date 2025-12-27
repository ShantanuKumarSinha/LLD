package mutlithreading.problems;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// what happens if I call

public class ExecutionOfThreads {

  public static synchronized void secondMethod() throws InterruptedException {
    System.out.println("Second Method");
    // wait is preferred to sleep as it releases the lock
    Thread.sleep(1000000000);
  }

  public static void main(String... args) throws InterruptedException {
    ExecutorService executors = Executors.newFixedThreadPool(100);
    ExecutionOfThreads obj = new ExecutionOfThreads();
    Runnable task1 =
        () -> {
          try {
            obj.firstMethod();
          } catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
        };
    Runnable task2 =
        () -> {
          try {
            secondMethod();
          } catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
        };
    for (int i = 0; i < 100; i++) {
      executors.execute(task1);
      executors.execute(task2);
    }
  }

  public synchronized void firstMethod() throws InterruptedException {
    System.out.println("First Method");
    wait(100);
  }
}
