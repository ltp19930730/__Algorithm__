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
    * @param x: an integer
    * @return: a ListNode
    */
   public ListNode partition(ListNode head, int x) {
       // write your code here
       if (head == null){
           return head;
       }

       ListNode leftDummy = new ListNode(0);
       ListNode rightDummy = new ListNode(0);
       ListNode left = leftDummy;
       ListNode right = rightDummy;
       while (head != null){
           if (head.val < x){
               left.next = head;
               left = head;
           }else{
               right.next = head;
               right = head;
           }
           head = head.next;
       }
       // make sure to set the last node to point to null!!! or may lead to be a cyclic graph
       right.next = null;
       left.next = rightDummy.next;
       return leftDummy.next;
   }
}
