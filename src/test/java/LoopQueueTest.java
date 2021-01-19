import xxh.queue.LoopQueue;
import xxh.queue.Queue;


/**
 *@author xxh
 *@since 2021/1/3
 *@discription: Algorithm
 */
public class LoopQueueTest {
  public static void main(String[] args) {
    Queue<Integer> queue = new LoopQueue<Integer>();
    for (int i = 1; i <= 30; i++) {
      queue.enQueue(i);
      System.out.println(queue);
    }
    for (int i = 1; i <= 30; i++) {
      queue.deQueue();
      System.out.println(queue);
    }

  }
}
