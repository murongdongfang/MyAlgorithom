package xxh.sort;


import java.util.Arrays;

/**
 *@author xxh
 *@since 2021/1/26
 *@discription: Algorithm
 */
public class MergeSortOptimize {
  public static void main(String[] args) {
    Integer[] arr = {1,23,3,4,346,756,88,901,9,456,78,77,66};
    sortBU(arr);
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i]+",");
    }
  }
  public static <E extends Comparable<E>> void sortTest(E[] arr){
    E[] copy = Arrays.copyOfRange(arr, 0, arr.length);
    sort(arr,copy, 0, arr.length - 1);
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i]+",");
    }
  }
  // 自定向下归并排序
  public static <E extends Comparable<E>> void sort(E[] arr, E[] copyArr, int from, int to){
   /* if (from >= to){
      return;
    }*/
    // 优化点二： 小规模数据使用插入排序
    if (to - from <= 5){
      insertSort(arr, from, to);
      return;
    }
    int mid = (from + to) >>> 1;
    sort(arr,copyArr, from, mid);
    sort(arr, copyArr,mid + 1, to);

    // 优化点一：arr[mid] < arr[mid+1]表示此时整个数组已经是有序数组
    if (arr[mid].compareTo(arr[mid + 1]) > 0){
      merge(arr,copyArr, from, mid, to);
    }
  }
  // 自底向上归并排序 BU:bottom up
  public static <E extends Comparable<E>> void sortBU(E[] arr){
    int n = arr.length;
    E[] copy = Arrays.copyOfRange(arr, 0, n);
    // 要合并的区间长度
    for (int size = 1; size < n; size += size) {
      // 将两个有序区间arr[i,i+size-1]和arr[i+size,Math.min(i + size*2 - 1, n - 1)]区间合并为一个有序区间
      // i+size*2-1可能会数组越界
      for (int i = 0; i + size - 1 < n; i+=(size << 1)){
        merge(arr, copy, i,i + size - 1, Math.min(i + size*2 - 1, n - 1));
      }
    }

  }
  // 将arr数组的两个有序部分[from,mid]和[mid+1,to]合并成一个有序部分
  private static <E extends Comparable<E>> void merge(E[] arr, E[] copyArr, int from, int mid, int to) {
    // 优化点三：以前每次merge都需要开辟一个copy数组。优化后只需要开辟一次copy数组
//    E[] copy = Arrays.copyOfRange(arr, from, to + 1);
    System.arraycopy(arr, from, copyArr, from, to - from + 1);
    int l = from, r = mid + 1;
    for (int i = from; i <= to; i++) {
      if (l > mid){
        arr[i] = copyArr[r];
        r++;
      }else if (r > to){
        arr[i] = copyArr[l];
        l++;
      }else if (copyArr[l].compareTo(copyArr[r]) < 0){
        arr[i] = copyArr[l];
        l++;
      }else {
        arr[i] = copyArr[r];
        r++;
      }
    }

  }

  /**
   * 对数组中arr[l...r]范围的数组进行插入排序
   * @param arr
   * @param l
   * @param r
   * @param <E>
   */
  private static <E extends Comparable<E>> void insertSort(E[] arr, int l, int r){
    if (arr == null || arr.length == 0){
      return;
    }
    for (int i = l + 1; i <= r; i++) {
      E temp = arr[i];
      int j;
      // 不能将temp.compareTo(arr[j - 1]) < 0放到for内用if做判断
      // temp是和arr[j - 1]不是和arr[j]比较 j初始为i
      for (j = i; j > l && temp.compareTo(arr[j - 1]) < 0 ; j--) {
        // j > l保证j-1不会数组越界
        // if (temp.compareTo(arr[j - 1]) < 0) 这样做错误
          arr[j] = arr[j - 1];
      }
      arr[j] = temp;
    }
  }
}
