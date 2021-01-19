package xxh.queue;

/**
 *@author xxh
 *@since 2021/1/3
 *@discription:
 * 用数组实现的循环队列，从过操作front，和tail指针来实现入队和出队操作
 * front和tail类似于动态数组的size指针，元素并没有被删除，只是被覆盖
 * 队列满：（tail + 1） % length == front
 * 队列空：front == tail
 * 出队：front = （front + 1）% length
 * 入队：tail = （tail + 1 ） % length
 * front。。。。tail
 * 0.。。。。。。size - 1
 */
public class LoopQueue<E> implements Queue<E> {
  private E[] data;
  // font指向队首元素，tail指向队尾元素的下一个位置（初始化的tail为0）
  private int front, tail ;
  private int size ;
  public LoopQueue(int capacity){
    // 为了区分队列满和队列空浪费了一个元素
    this.data = (E[])new Object[capacity + 1];
    front = tail = size = 0;
  }
  public LoopQueue(){
    // 为了区分队列满和队列空浪费了一个元素
    this.data = (E[])new Object[11];
    front = tail = size = 0;
  }

  /**
   * @return 数组长度 - 1才是这个队列的真正队列长度
   * 为了区分循环队列满和队列空浪费了一个数组空间
   */
  public int getCapacity(){
    return data.length - 1;
  }
  @Override
  public int getSize() {
    return this.size;
  }

  /**
   * @return front == tail 队空
   * front + 1 = tail 队满
   */
  @Override
  public boolean isEmpty() {
    return front == tail;
  }

  @Override
  public void enQueue(E e) {
    // 1. 入队之前序言先判断队列是否已经满，满则扩容
    if ((tail + 1) % data.length == front){
      resize(getCapacity() << 1);
    }
    // 2.入队，并移动tail = (tail + 1) % data.length改变size
    // 由于tail初始值为0，所以tail实际指向的是队尾元素的下一个位置，因此必须先入队才修改tail
    data[tail] = e;
    tail = (tail + 1) % data.length;
    size ++;
  }

  private void resize(int capacity) {
    E[] newData = (E[]) new Object[capacity + 1];
    /*
      原来循环队列front对应新扩容后新队列0，front+1对应1
      也就是说所有元素复制到新数组后相对于原来会有front的偏移量
    * */
    for (int i = 0; i < size; i++) {
      newData[i] = data[(front + i) % data.length];
    }
    this.data = newData;
    front = 0;
    tail = size;
  }

  @Override
  public E deQueue() {
    // 出队之前判断队列是否为空
    if (isEmpty()){
      throw new IllegalArgumentException("can't dequeue from an empty queue");
    }
    // front初始为空，指向的是队首元素，先出队后修改front
    E res = data[front];
    // 由于数组中放的是引用对象，手动垃圾清理
    data[front] = null;
    front = (front + 1) % data.length;
    size --;
    // 判断是否需要缩容
    if (size <= (getCapacity() >> 2) && (getCapacity() >> 1) > 0){
      resize(data.length >> 1);
    }
    return res;
  }

  @Override
  public E getQueue() {
    if (isEmpty()){
      throw new IllegalArgumentException("can't getQueue from an empty queue");
    }
    return data[front];
  }
  @Override
  public String toString(){
    StringBuilder builder = new StringBuilder();
    builder.append(String.format("LoopQueue: size=%d, capacity=%d\n front [",size,getCapacity()));
    // 对比和resize的遍历区别，两种方式可以互换
    for (int i = front; i != tail; i = (i + 1) % data.length) {
      if ((i + 1) % data.length != tail) {
        builder.append(data[i]).append(",");
      }else {
        builder.append(data[i]);
      }
    }
    builder.append("]").append(" tail");
    return builder.toString();
  }
}
