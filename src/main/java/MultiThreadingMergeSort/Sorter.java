package MultiThreadingMergeSort;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class Sorter implements Callable<List<Integer>> {
  List<Integer> arraysToSort;
  ExecutorService executors;

  public Sorter(List<Integer> arraysToSort, ExecutorService executors) {
    this.arraysToSort = arraysToSort;
    this.executors = executors;
  }

  @Override
  public List<Integer> call() throws ExecutionException, InterruptedException {
    if (arraysToSort.size() <= 1) return arraysToSort;
    int mid = arraysToSort.size() / 2;
    var leftArray = arraysToSort.subList(0, mid);
    var rightArray = arraysToSort.subList(mid, arraysToSort.size());

    Sorter leftSorter = new Sorter(leftArray, executors);
    Sorter rightSorter = new Sorter(rightArray, executors);

    Future<List<Integer>> leftList = executors.submit(leftSorter);
    Future<List<Integer>> rightList = executors.submit(rightSorter);
    var sortedLeftList = leftList.get();
    var sortedRightList = rightList.get();

    List<Integer> sortedList = new ArrayList<>();
    int i = 0, j = 0;
    while (i < sortedLeftList.size() && j < sortedRightList.size()) {
      if (sortedLeftList.get(i) <= sortedRightList.get(j)) {
        sortedList.add(sortedLeftList.get(i));
        i++;
      } else {
        sortedList.add(sortedRightList.get(j));
        j++;
      }
    }
    while (i < sortedLeftList.size()) {
      sortedList.add(sortedLeftList.get(i));
      i++;
    }
    while (j < sortedRightList.size()) {
      sortedList.add(sortedRightList.get(j));
      j++;
    }

    return sortedList;
  }
}
