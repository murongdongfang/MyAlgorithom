import xxh.list.LinkedList;

/**
 *@author xxh
 *@since 2020/12/21
 *@discription: Algorithm
 */
public class LinkedListTest {
  public static void main(String[] args) {
    LinkedList<Integer> list = new LinkedList<>();
    for (int i = 0; i < 10; i++) {
      list.addFirst(i);
    }
    System.out.println(list.get(3));
    System.out.println(list.contains(5));
    System.out.println(list);
    list.deleteNode(5);
    System.out.println(list);
    list.deleteNode(0);
    System.out.println(list);
    list.add(3,4);
    System.out.println(list);
  }
}
