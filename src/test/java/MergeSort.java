import java.util.Arrays;

/**
 *@author xxh
 *@since 2021/1/26
 *@discription: Algorithm
 */
public class MergeSort {
  public static void main(String[] args) {
    Integer[] arr = {1,23,2,7,97,78};
    sort(arr,0, arr.length - 1);
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i]+",");
    }
  }
  public static <T extends Comparable<T>> void sort(T[] arr, int l, int r) {
    if (l >= r)
      return;
    int mid = (r + l) >>> 1;
    sort(arr, l, mid);
    sort(arr, mid + 1, r);
    merge(arr, l, mid, r);
  }
    /**
     * 将数组两个有序部分arr[l...mid]和arr[mid+1...r]合并成一个有序数组
     * @param arr
     * @param from  左边界下标inclusive
     * @param mid 中间部分
     * @param to 有边界下标exclusive
     * @param <T>
     */
  public static <T extends Comparable<T>> void merge(T[] arr, int from, int mid, int to){
    T[] copy = Arrays.copyOfRange(arr, from, to + 1);
    int l = from, r = mid + 1;
    for (int i = from; i <= to; i++) {
      if (l > mid){
        arr[i] = copy[r - from];
        r++;
      }else if (r > to){
        arr[i] = copy[l - from];
        l++;
      }else if (copy[l - from].compareTo(copy[r - from]) < 0){
        arr[i] = copy[l - from];
        l++;
      }else {
        arr[i] = copy[r - from];
        r++;
      }

    }
  }
}
