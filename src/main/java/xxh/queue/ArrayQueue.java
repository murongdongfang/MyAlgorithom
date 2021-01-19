package xxh.queue;

import xxh.list.Array;

/**
 *@author xxh
 *@since 2021/1/2
 *@discription:
 * 用动态数组实现的循环队列，存在缺点出队的时候从index=0出队，
 * 出对后动态数组所有的数组都会向前移动一个元素，造成性能下降
 */
public class ArrayQueue<E> implements Queue<E> {
  private Array<E> array;
  public ArrayQueue(){
    array = new Array<E>();
  }
  public ArrayQueue(int capacity){
    array = new Array<>(capacity);
  }
  @Override
  public int getSize() {
    return array.getSize();
  }

  @Override
  public boolean isEmpty() {
    return array.isEmpty();
  }

  @Override
  public void enQueue(E e) {
    array.addLast(e);
  }

  @Override
  public E deQueue() {
    return array.removeFirst();
  }

  @Override
  public E getQueue() {
    return array.getFirst();
  }

  @Override
  public String toString(){
    StringBuilder builder = new StringBuilder();
    builder.append("Queue: front")
      .append("[");
    for (int i = 0; i < array.getSize(); i++) {
      if (i != array.getSize() - 1) {
        builder.append(array.get(i)).append(", ");
      }else {
        builder.append(array.get(i));
      }
    }
    builder.append("]").append("tail");
    return builder.toString();
  }
}
