package xxh.ls;

import java.util.Random;

/**
 *@author xxh
 *@since 2020/12/13
 *@discription: Algorithm
 */
public class ArrayGenerator {
  private ArrayGenerator(){}

  // 生成有序数组[1...n)
  public static Integer[] generateOrdedArray(int n){
    n = (n <= 0) ? 10 : n;
    Integer[] arr = new Integer[n];
    for (int i = 0; i < n; i++) {
      arr[i] = i;
    }
    return arr;
  }
  // 生成元素个数为n的随机数组，随机数的范围为[0,boud)
  public static Integer[] generateRandomArray(int n, int boud){
    n = n <= 0 ? 10 : n;
    Integer[] arr = new Integer[n];
    Random random = new Random();
    for (int i = 0; i < n; i++) {
      // 生成的随机数为[0,bound)
      arr[i] = random.nextInt(boud);
    }
    return arr;
  }
}
