package xxh.sort;

import xxh.ls.ArrayGenerator;

import java.util.Random;

/**
 *@author xxh
 *@since 2021/2/3
 *@discription: Algorithm
 */
public class QuickSortOptimize {
  public static void main(String[] args) {
    Integer[] arr = ArrayGenerator.generateOrdedArray(100000);
    Integer[] arr2 = ArrayGenerator.generateRandomArray(100000, 1);
    quickSort(arr2, 0, arr2.length - 1);
    System.out.println(SortingHelper.isSorted(arr2));
  }
  public static <E extends Comparable<E>> void quickSort(E[] arr, int l, int r){
    if (l >= r){
      return;
    }
    int pos = partition(arr, l, r);
    quickSort(arr, l, pos - 1);
    quickSort(arr, pos + 1, r);
    
  }

  /**
   * pivot的选取是重点，如果pivot为固定（比如中点）的都可以设计为一组测试测试用例使之退化为n^2，递归深度为n
   * 采用随机选取pivot的方式也有bug，如果数组中全是相同的元素，依然会退化成n^2递归深度n造成stackoverflow
   */
  private static < E extends Comparable<E>> int partition(E[] arr, int l, int r) {
    // 再[l,r]区间中生成一个随机值
    int index = new Random().nextInt(r - l + 1) + l;
    // 交换后pivot=arr[l]=arr[index]，要将数组划分成arr[l..j] < pivot arr[j+1..r] >= pivot
    // 若不交换而且arr完全有序，则会造成小于pivot=arr[l]（最小值）部分为0，大于pivot的为所有，此时递归的深度就是n（可能栈溢出），时间复杂度n^2
    swap(arr, l, index);
    int j = l;
    for (int i = l + 1; i <= r ; i++) {
      if (arr[i].compareTo(arr[l]) < 0){
        j++;
        swap(arr, i, j);
      }
    }
    swap(arr, l, j);
    return j;
  }
  public static <T> void swap(T[] arr, int j, int minIndex) {
    T temp = arr[j];
    arr[j] = arr[minIndex];
    arr[minIndex] = temp;
  }
}
