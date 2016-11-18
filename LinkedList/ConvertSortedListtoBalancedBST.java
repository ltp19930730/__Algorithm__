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
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @return: a tree node
     */
    public TreeNode sortedListToBST(ListNode head) {
        // write your code here
        if (head == null){
            return null;
        }

        ListNode mid = findMid(head),left = null, right = mid.next;
        if (head != mid){
            left = head;
        }


        TreeNode leftRoot = sortedListToBST(left);
        TreeNode rightRoot = sortedListToBST(right);

        TreeNode root = new TreeNode(mid.val);
        root.left = leftRoot;
        root.right = rightRoot;

        return root;
    }

    private ListNode findMid(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        ListNode prev = null;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        if( prev != null){
            prev.next = null;
        }

        return slow;
    }
}
