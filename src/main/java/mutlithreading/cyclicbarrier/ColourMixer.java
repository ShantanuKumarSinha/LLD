package mutlithreading.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * We have three threads that represent three different colors: Red, Green, and Blue. Each thread
 * should print its color name and then wait for the other two threads to print their color names
 * before proceeding to the next step. Use a CyclicBarrier to synchronize the threads and ensure
 * that they all print their color names before any of them proceeds to the next step.
 */
public class ColourMixer {

  private static final int numberOfThreads = 3;

  public static void main(String[] args) {
    CyclicBarrier barrier =
        new CyclicBarrier(
            numberOfThreads,
            () -> System.out.println("All colors printed. Proceeding to the next step..."));
    new Thread(new ColorPrinter(barrier, "Red")).start();
    new Thread(new ColorPrinter(barrier, "Green")).start();
    new Thread(new ColorPrinter(barrier, "Blue")).start();

  }
}

class ColorPrinter implements Runnable {

  private CyclicBarrier barrier;
  private String color;

  public ColorPrinter(CyclicBarrier barrier, String color) {
    this.barrier = barrier;
    this.color = color;
  }

  @Override
  public void run() {
    try {
      System.out.println("Applying color: " + color);
      // Simulate time taken to apply the color
      Thread.sleep(1000);
      System.out.println("Finished applying color: " + color);
      barrier.await();
      System.out.println("Colour applied successfully check: " + color);

    } catch (InterruptedException | BrokenBarrierException e) {
      e.printStackTrace();
    }
  }
}
