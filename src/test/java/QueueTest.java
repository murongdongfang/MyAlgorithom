import xxh.queue.ArrayQueue;

/**
 *@author xxh
 *@since 2021/1/2
 *@discription: Algorithm
 */
public class QueueTest {
  public static void main(String[] args) {
    ArrayQueue<Integer> queue = new ArrayQueue<>();
    for (int i = 1; i <= 3; i++) {
      queue.enQueue(i);
      System.out.println(queue);
    }
  }
}
