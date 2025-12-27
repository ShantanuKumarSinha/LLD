package multiThreadingMergeSort.forkJoinPool;

import java.util.Arrays;
import java.util.concurrent.RecursiveAction;

public class ForkJoinMergerSort extends RecursiveAction {
  int[] arr;

  public ForkJoinMergerSort(int[] arr) {
    this.arr = arr;
  }

  public static void main(String[] args) {
    int[] arr = {11, 77, 23, 56, 89, 32, 21, 15};
    var forkJoinMergerSort = new ForkJoinMergerSort(arr);
    System.out.println(Arrays.asList(arr));
  }

  @Override
  protected void compute() {
    int l = 0;
    int r = arr.length - 1;
    int m = l + (r - l) / 2;
    if (l < r) {
      ForkJoinMergerSort leftSort = new ForkJoinMergerSort(arr);
      ForkJoinMergerSort rightSort = new ForkJoinMergerSort(arr);
      invokeAll(leftSort, rightSort);
      merge(arr, l, m, r);
    }
  }

  private void merge(int[] arr, int l, int m, int r) {
    int n1 = m - l + 1;
    int n2 = r - m;
    int[] left = new int[n1];
    int[] right = new int[n2];

    for (int i = 0; i < n1; i++) {
      left[i] = arr[l + i];
    }
    for (int j = 0; j < n2; j++) {
      right[j] = arr[m + 1 + j];
    }

    int i = 0, j = 0;
    int k = l;

    while (i < n1 && j < n2) {
      arr[k++] = left[i] < right[j] ? left[i++] : right[j++];
    }
    while (i < n1) arr[k++] = left[i++];
    while (j < n2) arr[k++] = right[j++];
  }
}
