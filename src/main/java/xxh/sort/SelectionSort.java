package xxh.sort;

import xxh.ls.ArrayGenerator;

/**
 *@author xxh
 *@since 2020/12/13
 *@discription: 选择排序
 */
public class SelectionSort {

  private SelectionSort(){}
  // 只有在泛型中实现接口用的是extends其他用的是extends
  public static <E extends Comparable<E>> void selectionSort(E[] arr){
   /*
       for (int i = 0; i < arr.length; i++) {
          // minIndex是[i,arr.length-1]中的最小值的索引
          int minIndex = i;
          //循环不变量 [0，i)已经排好序，[i，arr.n)未排好序
          for (int j = i; j < arr.length; j++) {
            if (arr[j].compareTo(arr[minIndex]) < 0){
              swap(arr, j, minIndex);
            }
          }
        }
   */
    for (int i = arr.length - 1; i >= 0 ; i--) {
      // 循环不变量 [0,i)未排好序 [i,n)排好序
      int maxIndex = i;
      for (int j = 0; j < i; j++) {
        if (arr[j].compareTo(arr[maxIndex]) > 0){
          SortingHelper.swap(arr, j, maxIndex);
        }
      }
    }
  }



  public static void main(String[] args) {
    int[] dataSize = {10000};
    int boud = 100000;
    for (int i : dataSize) {
      Integer[] arr = ArrayGenerator.generateRandomArray(i, boud);
      SortingHelper.sortTest("SelectionSort", arr);
    }
//    Integer[] arr = {23,3,2,43,11,653,7};
    /*Data[] arr = {
      new Data("xxh",100),
      new Data("abc", 99),
      new Data("xyz", 60),
    };*/

  }
}
