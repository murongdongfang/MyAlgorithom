package xxh.solution;

/**
 *@author xxh
 *@since 2021/1/19
 *@discription:
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
public class Solution206 {
  public ListNode reverseList(ListNode head) {
    ListNode tail = null;
    ListNode cur = head;
    while(cur != null){
      ListNode pre = cur.next;
      cur.next = tail;
      tail = cur;
      cur = pre;
    }
    return tail;
  }
  public ListNode reverseList2(ListNode head) {
    if (head == null || head.next == null){
      return head;
    }
    ListNode node = reverseList2(head.next);
    head.next.next = head;
    head.next = null;
    return node;
  }
}
