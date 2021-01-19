package xxh.sort;

/**
 *@author xxh
 *@since 2020/12/13
 *@discription: Algorithm
 */
public class SortingHelper {

  private SortingHelper(){}

  public static <E extends Comparable<E>> boolean isSorted(E[] arr){
    for (int i = 1; i < arr.length; i++) {
      if (arr[i].compareTo(arr[i - 1]) < 0){
        return false;
      }
    }
    return true;
  }


  public static <K> void printArray(K[] arr) {
    StringBuilder builder = new StringBuilder();
    builder.append("[");
    for (int i = 0; i < arr.length; i++) {
      builder.append(arr[i]);
      if (i != arr.length - 1){
        builder.append(",");
      }
    }
    builder.append("]");
    System.out.println(builder.toString());
  }
  public static <E extends Comparable<E>> void sortTest(String className, E[] arr){
      long startTime = System.nanoTime();
      if ("SelectionSort".equals(className)) {
        SelectionSort.selectionSort(arr);
      }else if ("InsertSort".equals(className)) {
        InsertSort.insertSortOptimize(arr);
      }else if ("InsertSortOptimize".equals(className)){
        InsertSort.insertSortOptimize(arr);
      }else if ("MergeSort".equals(className)){
        MergeSort.sort(arr);
      }
      long endTime = System.nanoTime();
      double time = (endTime - startTime) / 1000000000.0;
      if (!SortingHelper.isSorted(arr))
        throw new RuntimeException("sort failed !");
      System.out.println(String.format("%s, n=%s ,耗时 %f s",className, arr.length, time));
  }

  public static <T> void swap(T[] arr, int j, int minIndex) {
    T temp = arr[j];
    arr[j] = arr[minIndex];
    arr[minIndex] = temp;
  }
}
