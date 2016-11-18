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
     * @param head: The head of linked list.
     * @return: You should return the head of the sorted linked list,
                    using constant space complexity.
     */
    public ListNode sortList(ListNode head) {
        // write your code here
        if (head == null || head.next == null){
            return head;
        }

        ListNode leftDummy = new ListNode(0),left = leftDummy;
        ListNode midDummy = new ListNode(0),mid = midDummy;
        ListNode rightDummy = new ListNode(0),right = rightDummy;
        ListNode midNode = getMid(head);
        ListNode cur = head;
        while (cur != null){
            if (cur.val > midNode.val){
                right.next = cur;
                right = cur;
            }else if (cur.val < midNode.val){
                left.next = cur;
                left = cur;
            }else{
                mid.next = cur;
                mid = cur;
            }
            cur = cur.next;
        }
        // don't forget to set the last index to point to null to avoid the cycle!
        left.next = null;
        right.next = null;
        mid.next = null;

        left = sortList(leftDummy.next);
        right = sortList(rightDummy.next);

        return concat(left,midDummy.next,right);
    }

    private ListNode concat(ListNode left, ListNode mid, ListNode right){
        ListNode Dummy = new ListNode(0), tail = Dummy;
        tail.next = left; tail = getTail(tail);
        tail.next = mid; tail = getTail(tail);
        tail.next = right;
        return Dummy.next;
    }

    private ListNode getTail(ListNode tail){
        while (tail.next != null){
            tail = tail.next;
        }
        return tail;
    }

    private ListNode getMid(ListNode head){
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
