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
     * @param head: The first node of linked list.
     * @return: head node
     */
    public ListNode removeDuplicates(ListNode head) {
        // Write your code here
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode cur = head;
        HashSet<Integer> hash = new HashSet<Integer>();

        while (cur != null){
            if(hash.contains(cur.val)){
                prev.next = cur.next;
                cur = cur.next;
            }else{
                hash.add(cur.val);
                prev = prev.next;
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
