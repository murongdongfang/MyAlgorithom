package xxh.ls;

import java.util.Objects;

/**
 *@author xxh
 *@since 2020/12/13
 *@discription: Algorithm
 */
public class LinerSearch {
  private LinerSearch(){};
  // 泛型方法的使用
  public static <T> int search(T[] arr, T target) {
    for (int i = 0; i < arr.length; i++) {
      if (Objects.equals(arr[i], target)){
        return i;
      }
    }
    return -1;
  }
  public static void main(String[] args) {
    Student[] arr = {
      new Student("xxh"),
      new Student("xyz"),
      new Student("abc"),
    };
    // jdk8以前没有自动类型推断，调用泛型方法的时候只能用 <Student> search(arr, new Student("xyz");
    int index = search(arr, new Student("xyz"));
    int[] dataSize = {1000000, 10000000};
    for (int j : dataSize) {
      int n = j;
      Integer[] data = ArrayGenerator.generateOrdedArray(n);
      long startTime = System.nanoTime();
      for (int i = 0; i < 100; i++) {
        search(data, n);
      }
      long endTime = System.nanoTime();
      // 结果取值为浮点数除数后面要加0
      double time = (endTime - startTime) / 100000000.0;
      System.out.println("n = "+n+" 100runs time = " + time + "s");
    }

  }
}
