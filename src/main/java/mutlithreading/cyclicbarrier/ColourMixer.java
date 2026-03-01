package mutlithreading.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * We have three threads that represent three different colors: Red, Green, and Blue. Each thread
 * should print its color name and then wait for the other two threads to print their color names
 * before proceeding to the next step. Use a CyclicBarrier to synchronize the threads and ensure
 * that they all print their color names before any of them proceeds to the next step.
 */
public class ColourMixer {

  private static final int NUMBER_OF_THREADS = 3;
  // Number of times we want the barrier to be used (i.e., rounds of mixing)
  private static final int ROUNDS = 3;

  public static void main(String[] args) {
    // track the round count so the barrier action can print which round just completed
    AtomicInteger roundCounter = new AtomicInteger(1);

    CyclicBarrier barrier =
        new CyclicBarrier(
            NUMBER_OF_THREADS,
            () -> System.out.println(
                "All colors printed for round " + roundCounter.getAndIncrement() + ". Proceeding to the next step..."));

    new Thread(new ColorPrinter(barrier, "Red", ROUNDS)).start();
    new Thread(new ColorPrinter(barrier, "Green", ROUNDS)).start();
    new Thread(new ColorPrinter(barrier, "Blue", ROUNDS)).start();

  }
}

class ColorPrinter implements Runnable {

  private final CyclicBarrier barrier;
  private final String color;
  private final int rounds;

  public ColorPrinter(CyclicBarrier barrier, String color, int rounds) {
    this.barrier = barrier;
    this.color = color;
    this.rounds = rounds;
  }

  @Override
  public void run() {

    try {
      for (int i = 1; i <= rounds; i++) {
        System.out.println("Applying color: " + color + " (round " + i + ")");
        // Simulate time taken to apply the color
        try {
          Thread.sleep(300 + (int) (Math.random() * 400)); // small random delay
        } catch (InterruptedException e) {
          // Preserve interrupt status and break out
          Thread.currentThread().interrupt();
          System.out.println(color + " interrupted while applying color. Exiting.");
          return;
        }
        System.out.println("Finished applying color: " + color + " (round " + i + ")");

        // wait for others
        try {
          barrier.await();
        } catch (BrokenBarrierException e) {
          // If the barrier is broken, stop further rounds
          System.out.println("Barrier broken for color " + color + ". Stopping further rounds.");
          return;
        }

        System.out.println("Colour applied successfully check: " + color + " (round " + i + ")");
      }
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      System.out.println(color + " was interrupted. Exiting.");
    }
  }
}
