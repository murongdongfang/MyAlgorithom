package xxh.solution;

/**
 *@author xxh
 *@since 2021/1/19
 *@discription: 删除链表中所有指定元素
 */
public class Solution203 {
  public ListNode removeElements(ListNode head, int val) {
    if (head == null){
      return null;
    }
    ListNode node = removeElements(head.next, val);
    if (head.val == val){
      head = node;
    }else {
      head.next = node;
    }
    return head;
  }
  public ListNode removeElements2(ListNode head, int val) {
    if (head == null){
      return head;
    }
    head.next = removeElements2(head.next, val);
   return head.val == val ? head.next : head;
  }
  //使用普通方法删除单链表中指定的节点
  public ListNode removeElements3(ListNode head, int val) {
    //如果待删除的节点是头节点
    while (head != null && head.val == val){
      ListNode delNode = head;
      head = delNode.next;
      delNode.next = null;
    }
    //必须要做这个判断
    if(head == null) {
      return null;
    }
    ListNode cur = head;
    //如果待删除的节点不是头节点
    while(cur.next != null){
      ListNode delNode = cur.next;
      if(delNode.val == val){
        cur.next = delNode.next;
        delNode.next = null;
      }else{
        cur = cur.next;
      }
    }

    return head;
  }
}
