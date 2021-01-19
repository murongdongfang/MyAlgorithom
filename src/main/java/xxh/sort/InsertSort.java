package xxh.sort;

import xxh.ls.ArrayGenerator;

import java.util.Arrays;

/**
 *@author xxh
 *@since 2020/12/13
 *@discription: O(n2)
 * 选择排序中第i轮排序[0,i]位置上的元素是整个数组中前i小且排好序的元素；
 * 插入排序中第i轮排序只是把前前i个元素拍好序，并不是整个数组中前i小
 * 对于插入排序如果待排序的数组本身是一个有序的数组，则插入排序的的时间复杂度降到O(n)\
 * 而选择排序始终是O(n2)，待排序的数组越是有序，插入排序速度越快
 */
public class InsertSort {

  // 使用交换的方式实现插入排序
  public static <E extends Comparable<E>> void insertSort(E[] arr){
    for (int i = 1; i < arr.length; i++) {
      // 循环不变量 arr[0,i)已经排好序，arr[i,n)未排好序
      for (int j = i; j > 0; j--) {
        if (arr[j].compareTo(arr[j - 1]) < 0){
          SortingHelper.swap(arr, j, j - 1);
        }
        // else break;
      }
    }
  }
  // 使用向后平移的方式实现插入排序
  public static <E extends Comparable<E>> void insertSortOptimize(E[] arr){
    // [0,i)排好序，[i,n)未排好序
   /*
   for (int i = 1; i < arr.length; i++) {
      E temp = arr[i];
      int j = 0;
      // temp.compareTo(arr[j - 1]) < 0 => temp - arr[j-1] < 0
      for (j = i; j > 0 && (temp.compareTo(arr[j - 1]) < 0); j--) {
        arr[j] = arr[j - 1];
      }
      arr[j] = temp;
    }
    */
    // [0,i)未排好序，[i,n)排好序
    for (int i = arr.length - 2; i >= 0; i--) {
      E temp = arr[i];
      int index = i;
      for (int j = i + 1; j < arr.length && temp.compareTo(arr[j]) > 0; j++){
        index = j;
        arr[j - 1] = arr[j];
      }
      arr[index] = temp;
    }
  }

  public static void main(String[] args) {

    int[] dataSize = {10000};
    System.out.println("==============ordered Array===========");
    for (int i : dataSize) {
      Integer[] arr = ArrayGenerator.generateOrdedArray(i);
      Integer[] integers = Arrays.copyOf(arr, arr.length);
      SortingHelper.sortTest("SelectionSort", arr);
      SortingHelper.sortTest("InsertSortOptimize", integers);

    }
    System.out.println("==============Random Array===========");
    for (int i : dataSize) {
      Integer[] arr = ArrayGenerator.generateRandomArray(i, 100000);
//      Integer[] arr = ArrayGenerator.generateOrdedArray(i);
      Integer[] integers = Arrays.copyOf(arr, arr.length);
      SortingHelper.sortTest("SelectionSort", integers);
      SortingHelper.sortTest("InsertSortOptimize", arr);
//      SortingHelper.sortTest("SelectionSort", integers);
    }

  }
}
