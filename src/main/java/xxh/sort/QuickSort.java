package xxh.sort;

import xxh.ls.ArrayGenerator;

import java.util.Random;

/**
 *@author xxh
 *@since 2021/2/3
 *@discription: Algorithm
 */
public class QuickSort {
  public static void main(String[] args) {
//    Integer[] arr = {346,756,88,901,9,456,78,77,66};
    Integer[] arr = ArrayGenerator.generateOrdedArray(100000);
    quickSort(arr, 0, arr.length - 1);
    System.out.println(SortingHelper.isSorted(arr));
  /*  for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i]+",");
    }*/
  }
  public static <E extends Comparable<E>> void quickSort(E[] arr, int l, int r){
    if (l >= r){
      return;
    }
    int pos = partition2(arr, l, r);
    quickSort(arr, l, pos - 1);
    quickSort(arr, pos + 1, r);

  }
  /**
   * partition3虽然解决了partition和partition2数组完全有序造成stackoverflow的缺陷
   * pivot的选取是重点，如果pivot为固定（比如中点）的都可以设计为一组测试测试用例使之退化为n^2，递归深度为n
   * 缺陷：采用随机选取pivot的方式也有bug，如果数组中全是相同的元素，依然会退化成n^2递归深度n造成stackoverflow
   */
  private static < E extends Comparable<E>> int partition3(E[] arr, int l, int r) {
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
  // 采用交换的方式实现partition
  // 缺陷：对于完全有序的数组可能会会出现StackOverflowError 对于完全有序的数组这样写复杂度会退化为O(n^2) 递归深度为O(n)
  private static <E extends Comparable<E>> int partition2(E[] arr, int l, int r) {
    // pivot=arr[l]  arr[l+1...j] < pivot  arr[j+1...r] >= pivot;
//    int j = l + 1; 如果初始值j为l+1的话，下面也要做相应的变化
    int j = l;
    for (int i = l + 1; i <= r; i++) {
      if (arr[i].compareTo(arr[l]) < 0){
        j++;
        swap(arr, i, j);
//        j++; 此时j的初始值为l+1
      }
    }
//    swap(arr, l, j - 1); 此时j的初始值为l+1
    swap(arr, l, j);
//    return j - 1;  此时j的初始值为l+1
    return j;
  }
  public static <T> void swap(T[] arr, int j, int minIndex) {
    T temp = arr[j];
    arr[j] = arr[minIndex];
    arr[minIndex] = temp;
  }

  /**
   *  采用覆盖的方式实现partition
   *  缺陷：对于完全有序的数组可能会会出现StackOverflowError 对于完全有序的数组这样写复杂度会退化为O(n^2) 递归深度为O(n)
   *  缺陷原因：对于有序数组如果每次pivot都选取的是arr[l]的话就造成了区间划分不平均，
   *  有序数组中没有元素比arr[l]小，所有元素不小于arr[l]
   *  解决方案：每次选取pivot的时候不选取arr[l]而是再arr[l..r]中随机选取pivot
   */
  private static <E extends Comparable<E>> int partition(E[] arr, int l, int r) {
    E pivot = arr[l];
    int low = l, high = r;
    while (low < high){
      while (arr[high].compareTo(pivot) >= 0 && low < high){
        high--;
      }
      arr[low] = arr[high];
      while (arr[low].compareTo(pivot) <= 0 && low < high){
        low++;
      }
      arr[high] = arr[low];
    }
    arr[low] = pivot;
    return low;
  }
}
