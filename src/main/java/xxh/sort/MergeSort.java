package xxh.sort;

import xxh.ls.ArrayGenerator;

import java.util.Arrays;

/**
 *@author xxh
 *@since 2021/1/19
 *@discription: Algorithm  clipboard
 */
public class MergeSort {
  public static void main(String[] args) {
    Integer[] arr = ArrayGenerator.generateRandomArray(10000, 500);
    SortingHelper.sortTest("MergeSort", arr);
  }
  public static <E extends Comparable<E>> void sort(E[] arr){
    sort(arr, 0, arr.length - 1);
  }
  public static <E extends Comparable<E>> void sort(E[] arr, int l, int r){
    // 如果没有=会出现StackOverflow
    if (l >= r){
      return;
    }
    int mid = (l + r) >>> 1;
    sort(arr, l, mid);
    sort(arr, mid+1, r);
    merge(arr, l, mid, r);
  }
  public static <E extends Comparable<E>> void merge(E[] arr, int l, int mid, int r){
    // 将有序arr[l,mid]和有序数组arr[mid+1,r]和并成为一个大的有序数组
    // l:inclusive  r:exclusive
    E[] temp = Arrays.copyOfRange(arr, l, r + 1);
    int i = l, j = mid + 1;
    // k的初始值为l不是0
    for (int k = l; k <= r; k++) {
      // i > mid说明arr[l,mid]比arr[mid+1]短
      if (i > mid){
        arr[k] = temp[j - l];
        j++;
      }else if (j > r){
        // temp相比于arr新数组有一个l的偏移
        arr[k] = temp[i - l];
        i++;
      }else if (temp[i - l].compareTo(temp[j - l]) <= 0){
        arr[k] = temp[i - l];
        i++;
      }else {
        arr[k] = temp[j - l];
        j++;
      }
    }
  }
}
