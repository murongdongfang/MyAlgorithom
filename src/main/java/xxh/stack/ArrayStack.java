package xxh.stack;

import xxh.list.Array;

/**
 *@author xxh
 *@since 2021/1/2
 *@discription: Algorithm
 */
public class ArrayStack<E> implements Stack<E>{
  private Array<E> array;
  public ArrayStack(){
    this.array = new Array<>();
  }
  @Override
  public int getSize() {
    return array.getSize();
  }

  public int getCapacity(){
    return array.getCapacity();
  }
  @Override
  public boolean isEmpty() {
    return array.isEmpty();
  }

  @Override
  public void push(E e) {
    array.addLast(e);
  }

  @Override
  public E pop() {
    return array.removeLast();
  }

  @Override
  public E peek() {
    return array.getLast();
  }
  @Override
  public String toString(){
    StringBuilder builder = new StringBuilder();
    builder.append("Stack: bottom")
      .append("[");
    for (int i = 0; i < array.getSize(); i++) {
      if (i != array.getSize() - 1) {
        builder.append(array.get(i)).append(", ");
      }else {
        builder.append(array.get(i));
      }
    }
    builder.append("]").append("top");
    return builder.toString();
  }
}
