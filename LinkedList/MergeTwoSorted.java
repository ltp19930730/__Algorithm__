public class Solution {
    /**
     * @param ListNode l1 is the head of the linked list
     * @param ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write your code here
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }

        ListNode dummy = new ListNode(0), cur = dummy;
        while ( l1 != null && l2 != null){
            if (l1.val > l2.val){
                cur.next = l2;
                l2 = l2.next;
            }else{
                cur.next = l1;
                l1 = l1.next;
            }
            cur = cur.next;
        }

        if(l1 != null){
            cur.next = l1;
        }else{
            cur.next = l2;
        }

        return dummy.next;
    }
}
