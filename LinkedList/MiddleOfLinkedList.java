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
     * @param head: the head of linked list.
     * @return: a middle node of the linked list
     */
    public ListNode middleNode(ListNode head) {
        // Write your code here
        // if (head == null){
        //     return head;
        // }
        // ListNode dummy = new ListNode(0);
        // dummy.next = head;
        // ListNode cur = dummy;
        // int sum = 0;
        // while (cur.next!=null){
        //     cur = cur.next;
        //     sum++;
        // }
        // cur = dummy;
        // for (int i = 0; i < (sum+1)/2; i++){
        //     cur = cur.next;
        // }
        // return  cur;
        if (head == null || head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
