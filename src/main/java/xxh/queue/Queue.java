package xxh.queue;

/**
 *@author xxh
 *@since 2021/1/2
 *@discription: Algorithm
 */
public interface Queue<E> {
  int getSize();
  boolean isEmpty();
  void enQueue(E e);
  E deQueue();
  E getQueue();
}
