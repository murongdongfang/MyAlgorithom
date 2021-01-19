package xxh.list;

/**
 *@author xxh
 *@since 2020/12/13
 *@discription: Algorithm
 */
public class Array<E> {
  private E[] data;
  private int size;

  public Array() {
    size = 0;
    this.data = (E[])new Object[10];
  }

  public Array(int capacity) {
    size = 0;
    capacity = (capacity > 0 ? capacity : 10);
    this.data = (E[])new Object[capacity];
  }
  public int getCapacity() {
    return data == null ? 0 : data.length;
  }

  public int getSize() {
    return data == null ? 0 : size;
  }


  public void addLast(E e){
    this.add(e, size);
  }
  public void addFirst(E e){
    this.add(e, 0);
  }
  public void add(E e, int index){
    if (size >= data.length){
      resize(data.length << 1);
    }
    checkRangeForAdd(index);
    for (int i = size - 1; i >= index ; i--) {
      data[i + 1] = data[i];
    }
    data[index] = e;
    size++;
  }
  public E get(int index){
    checkRange(index);
    return data[index];
  }

  public E getFirst(){
    return data[0];
  }
  public E getLast(){
    return get(size - 1);
  }
  public boolean contains(E e){
    int index = getIndex(e);
    return index != -1;
  }
  public boolean isEmpty(){
    return this.size <= 0;
  }
  public int getIndex(E e){
    for (int i = 0; i < size; i++) {
      if (data[i] == e){
        return i;
      }
    }
    return -1;
  }
  public void set(int index, E e){
    checkRange(index);
    data[index] = e;
  }
  public void checkRangeForAdd(int index){
    if (index < 0 || index > size){
      throw new IllegalArgumentException("get failed, index is illegal");
    }
  }
  public void checkRange(int index){
    if (index < 0 || index >= size){
      throw new IllegalArgumentException("index is illegal");
    }
  }
  public E remove(int index){
    checkRange(index);
    E e = data[index];
    for (int i = index; i < size - 1; i++) {
      data[i] = data[i+1];
    }
    size --;
    data[size] = null;
    // 扩容capacity*2，缩容1/2，防止复杂度震荡，只有当前size当capacity的1/4才针正缩容1/2
    if (size <= (data.length >> 2) && (data.length >> 1) != 0){
      resize(data.length >> 1);
    }
    return e;
  }
  public void removeElement(E e){
    int index = getIndex(e);
    remove(index);
  }
  public E removeFirst(){
    E e = data[0];
    remove(0);
    return e;
  }
  public E removeLast(){
    E e = data[size - 1];
    remove(size - 1);

    return e;
  }

  public void resize(int newCapacity){
    E[] newData = (E[])new Object[newCapacity];
    if (newCapacity > 0){
      for (int i = 0; i < size; i++) {
        newData[i] = data[i];
      }
    }
    data = newData;
  }
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder
      .append(String.format("size:%d capacity:%d \n", size, getCapacity()))
      .append("[");
    for (int i = 0; i < size; i++) {
      if (i != size - 1) {
        builder.append(data[i]).append(",");
      }else {
        builder.append(data[i]);
      }
    }
    builder.append("]");
    return builder.toString();
  }
}
