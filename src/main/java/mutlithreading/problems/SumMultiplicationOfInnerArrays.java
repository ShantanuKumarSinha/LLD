package mutlithreading.problems;

import java.util.Arrays;
import java.util.concurrent.*;

// We have a 2D array (an array of arrays) of integers. We want to calculate the sum of the products
// of each inner array's elements.
// For example, given the array: [[1, 2, 3], [4, 5], [6]], the result should be (1*2*3) + (4*5) +
// (6) = 6 + 20 + 6 = 32
public class SumMultiplicationOfInnerArrays {
  public static void main(String[] args) throws ExecutionException, InterruptedException {
    int[][] array = {{1, 2, 3}, {4, 5}, {6}, {7,8, 9, 10}};
    int sum = 0;
    int numberOfThreads = array.length;
    for (int i = 0; i < numberOfThreads; i++) {
      ProductCalculator productCalculator = new ProductCalculator(array[i]);
      ExecutorService executorService = Executors.newSingleThreadExecutor();
      Future<Integer> future = executorService.submit(productCalculator);
      sum += future.get();
      executorService.shutdown();
    }
    System.out.println("Sum of products: " + sum);
  }

  private static class ProductCalculator implements Callable<Integer> {
    private int[] arr;

    public ProductCalculator(int[] arr) {
      this.arr = arr;
    }

    public Integer call() {
      return Arrays.stream(arr).reduce(1, (a, b) -> a * b);
    }
  }
}
