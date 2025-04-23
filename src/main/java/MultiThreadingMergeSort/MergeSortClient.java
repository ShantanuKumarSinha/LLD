package MultiThreadingMergeSort;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MergeSortClient {

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    List<Integer> list = List.of(1, 14, 441, 223, 3, 77, 21);
    ExecutorService executorService = Executors.newCachedThreadPool();

    Sorter sorter = new Sorter(list, executorService);
    var result = executorService.submit(sorter).get();
    System.out.println(result);
    executorService.shutdown();
  }
}
