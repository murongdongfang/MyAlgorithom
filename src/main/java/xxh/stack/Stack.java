package xxh.stack;

/**
 *@author xxh
 *@since 2021/1/2
 *@discription: Algorithm
 */
public interface Stack<E> {
  int getSize();
  boolean isEmpty();
  void push(E e);
  E pop();
  E peek();
}
