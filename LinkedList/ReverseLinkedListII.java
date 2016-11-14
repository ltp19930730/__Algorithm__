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
     * @oaram m and n
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m , int n) {
        // write your code
        if (head == null || head.next == null || m >= n){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;

        for (int i = 1; i < m; i++){
            if (head == null){
                return dummy.next;
            }
            head = head.next;
        }
        ListNode prev = head;
        ListNode Nnode = head.next;
        ListNode FirstNode = Nnode;
        ListNode SecondNode = FirstNode.next;

        for (int i = m; i < n; i++){
            ListNode tmp = FirstNode;
            FirstNode = SecondNode;
            SecondNode = SecondNode.next;
            FirstNode.next = tmp;
        }
        Nnode.next = SecondNode;
        prev.next = FirstNode;

        return dummy.next;
    }

}
