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
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */
    public ListNode[] rehashing(ListNode[] hashTable) {
        // write your code here
        if (hashTable == null) {
            return hashTable;
        }
        int len = hashTable.length;
        ListNode[] newHash = new ListNode[len*2];
        for (int i = 0; i < len; i++){
            if (hashTable[i] == null) {
                continue;
            }else{
                ListNode cur = hashTable[i];
                while (cur != null){
                    hashing(newHash, cur.val);
                    cur = cur.next;
                }
            }
        }
        return newHash;
    }

    private void hashing(ListNode[] A, int val){
        int hashcode = (val % A.length + A.length) % A.length;
        if (A[hashcode] == null) {
            A[hashcode] = new ListNode(val);
        } else {
            ListNode tmp = A[hashcode];
            while(tmp.next!= null) {
                tmp = tmp.next;
            }
            tmp.next = new ListNode(val);
        }
    }
};
