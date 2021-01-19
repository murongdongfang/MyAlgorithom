import xxh.ls.ArrayGenerator;
import xxh.sort.SortingHelper;

/**
 *@author xxh
 *@since 2020/12/13
 *@discription: Algorithm
 */
public class InsertSort {
  public static  <T extends Comparable<T>> void insertSort(T[] arr){
    for (int i = 1; i < arr.length; i++) {
      T t = arr[i];
      int index = 0;
      for ( index = i - 1; index > 0 && t.compareTo(arr[index]) < 0; index--) {
        arr[index + 1] = arr[index];
      }
      arr[index] = t;
    }

  }
  public static void main(String[] args) {
    int n = 10000;
    int bound = 1000000;
    Integer[] arr = ArrayGenerator.generateRandomArray(20, bound);
    long startTime = System.nanoTime();
    insertSort(arr);
    long endTime = System.nanoTime();
    double time = (endTime - startTime) / 1000000000.0;
    if (!SortingHelper.isSorted(arr))
      throw new RuntimeException("sort failed !");
    System.out.println(String.format("n=%s ,耗时 %f s", arr.length, time));
    SortingHelper.printArray(arr);
  }
}
