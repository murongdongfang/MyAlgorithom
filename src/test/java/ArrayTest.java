import xxh.list.Array;

/**
 *@author xxh
 *@since 2020/12/13
 *@discription: Algorithm
 */
public class ArrayTest {
  public static void main(String[] args) {
    Array<Integer> array = new Array<>();
  /*  for (int i = 0; i < 30; i++) {
      array.addLast(i);
      System.out.println(array);
    }
    for (int i = 0; i < 30; i++) {
      array.removeLast();
      System.out.println(array);
    }*/
    for (int i = 1; i <= 30; i++) {
      array.addLast(i);
      System.out.println(array);
    }
    for (int i = 0; i < 30; i++) {
      array.removeFirst();
      System.out.println(array);
    }
  }
}
