package mutlithreading.phaser;

import java.util.concurrent.*;

public class ETLProcessor {

  private static final int WORKERS = 3;

  private static Phaser phaser = new Phaser(1);

  public static void main(String[] args) {
    try (ExecutorService executors = Executors.newFixedThreadPool(WORKERS); ) {
      for (int i = 1; i <= WORKERS; i++) {
        executors.execute(new WORKER(phaser, i));
      }
      // Main thread deregisters itself
      phaser.arriveAndDeregister();
      executors.shutdown();
    }
  }
}

class WORKER implements Runnable {

  private static final String WORKER_NAME = "Worker-";
  private final Phaser phaser;
  private final int workerId;

  public WORKER(Phaser phaser, int workerId) {
    this.phaser = phaser;
    this.workerId = workerId;
  }

  @Override
  public void run() {
    try {
      parse();
      phaser.arriveAndAwaitAdvance(); // Wait for all workers to finish parsing

      transform();
      phaser.arriveAndAwaitAdvance(); // Wait for all workers to finish transforming

      load();
      phaser.arriveAndDeregister(); // Wait for all workers to finish loading
    } catch (Exception e) {
      phaser.arriveAndDeregister();
      e.printStackTrace();
    }
  }

  private void parse() {
    System.out.println(WORKER_NAME + workerId + " is extracting data...");
  }

  private void transform() {
    System.out.println(WORKER_NAME + workerId + " is transforming data...");
  }

  private void load() {
    System.out.println(WORKER_NAME + workerId + " is loading data...");
  }
}
