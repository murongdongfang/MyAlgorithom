package xxh.list;

/**
 *@author xxh
 *@since 2020/12/21
 *@discription:
 */
public class LinkedList<E> {
  private int size;
  /**
   * 带有虚拟头节点的链表所有有效节点都有了前驱节点的好处的好处
   * 1. 不需要对插入index=0处的时候特殊处理
   * 2. 删除元素的时候不需要对删除index=0的元素特殊处理
   * 3. 没有虚拟头节点销毁链表的时候分类情况更为复杂
   */
  Node dummyHead;

/*  public LinkedList(Node head) {
    this.head = head;
    this.size ++;
  }*/

  public LinkedList() {
    dummyHead = new Node(null, null);
    size = 0;
  }
  public boolean isEmpty(){
    return size == 0;
  }
  public void addFirst(E e){
    /*
      Node node = new Node(e);
      node.next = head;
      head = node;
    */
    // 等价于上面三句话
    dummyHead.next = new Node(e, dummyHead.next);
    size++;
  }
  public void addLast(E data){
    add(size, data);
  }

  /**
   * 在链表index位置插入元素
   * @param index 索引从0开始
   * @param data
   */
  public void add(int index, E data){
    if (index < 0 || index > size){
      throw new IllegalArgumentException("add failed, index is illegal !");
    }
    Node prev = dummyHead;
    /*
     * 由于头节点没有前驱节点，所以头节点要特殊处理
     * 没有使用虚拟头节点的单链表在插入的时候由于首节点没有特殊前驱节点，必须要对首节点做特殊处理
     *   if (index == 0){
     *       this.addFirst(data);
     *     }else {
     *      // 插到到第index位置的节点，head需要移动index - 1次才能找到index号节点的前驱
     *       for (int i = 0; i < index - 1; i++) {
     *         prev = prev.next;
     *       }
     */
    // 插到index位置节点出，dummyHead需要移动index （下标0对应的时链表中第一个有数据的元素）
    for (int i = 0; i < index; i++) {
      prev = prev.next;
    }
    /*  Node node = new Node(data);
      node.next = prev.next;
      prev.next = node;*/
      // 以上三句话等价于
      prev.next = new Node(data, prev.next);
      this.size ++;
  }

  private class Node{
     public E data;
     public Node next;
     public Node(E data, Node next){
      this.data = data;
      this.next = next;
     }
     public Node(E data){
      this.data = data;
      this.next = next;
     }
     @Override
     public String toString(){
       return data+"";
     }
  }
  public  int getSize(){
    return this.size;
  }
     public E get(int index){
       if (index < 0 || index >= size || size <= 0){
         throw new IllegalArgumentException("get failed, index is illegal !");
       }
       Node cur = dummyHead.next;
       for (int i = 0; i < index; i++) {
         cur = cur.next;
       }
       return cur.data;
     }

    /**
     * 修改index位置处的节点值
     * @param index
     * @param data 输入的数据
     * @return
     */
     public E set(int index, E data){
       if (index < 0 || index > size || size <= 0){
         throw new IllegalArgumentException("get failed, index is illegal !");
       }
       Node cur = dummyHead.next;
       for (int i = 0; i < index; i++) {
         cur = cur.next;
       }
       E ret = cur.data;
       cur.data = data;
       return ret;
     }
  public E removeFirst(){
      return this.deleteNode(0);
  }
  public E getFirst(){
       return this.get(0);
  }
    /**
     * 删除索引为index处的节点
     * @param index
     * @return
     */
  public E deleteNode(int index){
    if (index < 0 || index >= size){
      throw new IllegalArgumentException("delete failed, index is illegal");
    }
    // 删除的时候cur = dymmyHead，增加的时候cur = dummyHead
    Node cur = dummyHead;
    for (int i = 0;i < index; i++){
      cur = cur.next;
    }
    Node delNode = cur.next;
    E delData = cur.next.data;
    cur.next = delNode.next;
    size --;
    return delData;
   }
     public boolean contains(E data){
       Node cur = dummyHead.next;
       while (cur != null){
         if (cur.data.equals(data)){
           return true;
         }
         cur = cur.next;
       }
       return false;
     }
     @Override
     public String toString() {
       StringBuilder builder = new StringBuilder();
       Node cur = dummyHead.next;
       while (cur != null){
         builder.append(cur.data).append("->");
         cur = cur.next;
       }
       builder.append("NULL");
       return builder.toString();
     }

 }
