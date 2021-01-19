/**
 *@author xxh
 *@since 2020/12/19
 *@discription: Algorithm
 */
public class Math {
  public static void main(String[] args) {
//    System.out.println(gcd(18, 36));
    int[] arr = {1,2,3,4,5};
    System.out.println(sum(arr));
  }
  public static int gcd(int x, int y){
    return y > 0 ? gcd(y, x % y) : x;
  }
  public static int sum(int[] arr){
    return sum(arr, 0);
  }

  // 计算arr[i,n)范围数组元素之和
  private static int sum(int[] arr, int i) {
    if (i == arr.length) {
      return 0;
    }
    return arr[i] + sum(arr, i+1);
  }
}
