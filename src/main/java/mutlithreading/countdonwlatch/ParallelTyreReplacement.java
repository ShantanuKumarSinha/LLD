package mutlithreading.countdonwlatch;

import java.util.concurrent.CountDownLatch;

/**
 * We have to perform a countdown latch from a given number to zero using multiple threads. Each
 * thread should print the current number and then decrement it. Use synchronization to ensure that
 * the countdown is thread-safe and that no numbers are skipped or printed out of order.
 */

public class ParallelTyreReplacement {

  private static final int numberOfWorkers = 4;

  public static void main(String[] args) {
    CountDownLatch latch = new CountDownLatch(numberOfWorkers);
    for (int i = 1; i <= numberOfWorkers; i++) {
      new Thread(new TyreReplacer(latch, i)).start();
    }
    try {
      System.out.println("Waiting for tyres to be replaced...");
      latch.await();
        System.out.println("All tyres replaced. Ready to go!");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}

class TyreReplacer implements Runnable {

  private CountDownLatch latch;
  private int tyreNumber;

  public TyreReplacer(CountDownLatch latch, int tyreNumber) {
    this.latch = latch;
    this.tyreNumber = tyreNumber;
  }

  @Override
  public void run() {
    try {
      System.out.println("Replacing tyre number: " + tyreNumber);
      Thread.sleep((long) Math.random() * 1000);
      System.out.println("Replaced tyre number: " + tyreNumber);
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      latch.countDown();
    }
  }
}
