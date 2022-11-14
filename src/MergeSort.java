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
 * @author Prya Pedamkar
 * @version 1.0
 */

public class MergeSort {
  private static void merge(Node arr[], int start, int mid, int end) {
    int l = mid - start + 1;
    int r = end - mid;
    Node[] LeftArray = new Node[l];
    Node[] RightArray = new Node[r];
    for (int i = 0; i < l; ++i)
      LeftArray[i] = arr[start + i];
    for (int j = 0; j < r; ++j)
      RightArray[j] = arr[mid + 1 + j];
    int i = 0, j = 0;
    int k = start;
    while (i < l && j < r) {
      if (check(LeftArray[i], RightArray[j])) {
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

  public static void sort(Node[] arr, int start, int end) {
    if (start < end) {
      int mid = (start + end) / 2;
      sort(arr, start, mid);
      sort(arr, mid + 1, end);
      merge(arr, start, mid, end);
    }
  }

  public static Boolean check(Node left, Node right) {
    Boolean check = true;
      // use weight or use the lelefticographic value
      if (left != null && right != null) {
        Boolean useWeight = left.weight() < right.weight();
        // lelefticographic comparison
        Boolean useAlpha = left.data().compareTo(right.data()) < 0;
        check = left.weight() == right.weight() ? useAlpha : useWeight;
      } else if (left == null) {
        check = false;
      }
      return check;
  }
}
