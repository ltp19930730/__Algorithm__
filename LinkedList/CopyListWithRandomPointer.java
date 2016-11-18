/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
// public class Solution {
//     /**
//      * @param head: The head of linked list with a random pointer.
//      * @return: A new head of a deep copy of the list.
//      */
//     public RandomListNode copyRandomList(RandomListNode head) {
//         // write your code here
//         if (head == null){
//             return null;
//         }
//         RandomListNode dummy = new RandomListNode(0);
//         RandomListNode prev = dummy,newNode,oldHead = head, newHead;
//
//         HashMap<RandomListNode,RandomListNode> map = new HashMap<>();
//         while (head != null){
//             newNode = new RandomListNode(head.label);
//             map.put(head, newNode);
//             prev.next = newNode;
//             prev = newNode;
//             head = head.next;
//         }
//         newHead = dummy.next;
//
//         while (oldHead != null){
//             if (oldHead.random != null){
//                newHead.random = map.get(oldHead.random);
//             }
//             oldHead = oldHead.next;
//             newHead = newHead.next;
//         }
//         return dummy.next;
//     }
// }

// new version with only one iteration
public class Solution {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
        if (head == null){
            return null;
        }
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode prev = dummy,newNode;

        HashMap<RandomListNode,RandomListNode> map = new HashMap<>();
        while (head != null){
            if (map.containsKey(head)){
                newNode = map.get(head);
            }else{
                newNode = new RandomListNode(head.label);
                map.put(head, newNode);
            }
            if (head.random != null){
                if (map.containsKey(head.random)){
                    newNode.random = map.get(head.random);
                }else{
                    newNode.random = new RandomListNode(head.random.label);
                    map.put(head.random,newNode.random);
                }
            }
            prev.next = newNode;
            prev = newNode;
            head = head.next;
        }
        return dummy.next;
    }
}
