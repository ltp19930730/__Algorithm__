/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param ListNode head is the head of the linked list
     * @return: ListNode head of linked list
     */
    public static ListNode deleteDuplicates(ListNode head) {
        // write your code here
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode cur = head;
        int curNum = 0;
        boolean first = true;
        while (cur != null){
            if(first){
                curNum = cur.val;
                first = false;
                prev = prev.next;
                cur = cur.next;
            }else{
                if (cur.val == curNum){
                    prev.next = cur.next;
                    cur = cur.next;
                }else{
                    curNum = cur.val;
                    prev = prev.next;
                    cur = cur.next;
                }
            }
        }
        return dummy.next;
    }
    // an much easy way but lack of readability
  public ListNode deleteDuplicates(ListNode head) {
      // write your code here
      if (head == null){
          return head;
      }
      ListNode node = head;
      while (node.next != null){
          if (node.val == node.next.val){
              node.next = node.next.next;
          }else{
              node = node.next;
          }
      }
      return head;
  }
}
