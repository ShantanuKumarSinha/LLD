package multiThreadingMergeSort.forkJoinPool;

public class MultiThreadingMergeSort {

  public static void main(String[] args) {
    // We have an array of integers that we want to sort using the merge sort algorithm.
    int[] arr = {11, 77, 23, 56, 89, 32, 21, 15};
    // 11, 21, 23, 32, 56, 77, ,89;
    sort(arr, 0, arr.length - 1);
    for (int i : arr) {
      System.out.println(i);
    }
  }


  // We have to solve this using FOrk And Join framework
  public static void sort(int[] arr, int l, int r) {
    if (l < r) {
      // Find the middle point
      var m = l + (r - l) / 2;
      // Sort the first half
      sort(arr, l, m);
      // Sort the second half
      sort(arr, m + 1, r);

      // Merge the sorted halves
      merge(arr, l, m, r);
    }
  }

  public static int[] merge(int[] arr, int l, int m, int r) {
    int n1 = m - l + 1;
    int n2 = r - m;
    int[] tmp1 = new int[n1];
    int[] tmp2 = new int[n2];

    for (int i = 0; i < n1; ++i) {
      tmp1[i] = arr[l + i];
    }
    for (int j = 0; j < n2; ++j) {
      tmp2[j] = arr[m + 1 + j];
    }
    // Merge the tmp arrays back into arr[l..r]
      int i =0; int j=0;
    int k = l;
    while (i < n1 && j < n2) {
      arr[k++] = tmp1[i] < tmp2[j] ? tmp1[i++] : tmp2[j++];
    }
    while (i < n1) arr[k++] = tmp1[i++];
    while (j < n2) arr[k++] = tmp2[j++];
    return arr;
  }
}
