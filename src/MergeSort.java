/*
 * file: Merge.java
 * class: EN.605.202.82.FA22
 */

/**
 * This class provides merge sort function for a Node with an integer weight and
 * String data
 *
 * Adapted from https://www.educba.com/merge-sort-in-java/
 *
 * @author Justin Law
 * @author Priya Pedamkar
 * @version 1.0
 */

public class MergeSort {
  private static void merge(Node arr[], int beg, int mid, int end) {
    int l = mid - beg + 1;
    int r = end - mid;
    Node[] LeftArray = new Node[l];
    Node[] RightArray = new Node[r];
    for (int i = 0; i < l; ++i)
      LeftArray[i] = arr[beg + i];
    for (int j = 0; j < r; ++j)
      RightArray[j] = arr[mid + 1 + j];
    int i = 0, j = 0;
    int k = beg;
    while (i < l && j < r) {
      if (LeftArray[i].weight() <= RightArray[j].weight()) {
        arr[k] = LeftArray[i];
        i++;
      } else {
        arr[k] = RightArray[j];
        j++;
      }
      k++;
    }
    while (i < l) {
      arr[k] = LeftArray[i];
      i++;
      k++;
    }
    while (j < r) {
      arr[k] = RightArray[j];
      j++;
      k++;
    }
  }

  public static void sort(Node[] arr, int beg, int end) {
    if (beg < end) {
      int mid = (beg + end) / 2;
      sort(arr, beg, mid);
      sort(arr, mid + 1, end);
      merge(arr, beg, mid, end);
    }
  }
}
