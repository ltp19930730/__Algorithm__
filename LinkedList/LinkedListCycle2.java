/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @return: The node where the cycle begins.
     *           if there is no cycle, return null
     */
    public ListNode detectCycle(ListNode head) {
        // write your code here
        // just rememeber and know how to use the two pointer
        if (head == null || head.next == null){
            return null;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != slow){
            if (fast == null || fast.next == null){
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        while (head != slow.next){
            slow = slow.next;
            head = head.next;
        }
        return head;
    }
}
