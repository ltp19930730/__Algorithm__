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
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
     // version 1: divide and conquer
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null || lists.size() == 0){
            return null;
        }
        int start = 0;
        int end = lists.size() - 1;
        ListNode head = mergeHelper(lists, start, end);
        return head;
    }

    private ListNode mergeHelper(List<ListNode> lists, int start,int end){
        if (start == end){
            return lists.get(start);
        }

        int mid = start + (end-start)/2;
        ListNode left = mergeHelper(lists ,start ,mid);
        ListNode right = mergeHelper(lists ,mid+1, end);

        ListNode head = mergeTwoLists(left,right);

        return head;
    }

    private ListNode mergeTwoLists(ListNode left, ListNode right){
        ListNode dummy = new ListNode(0),cur = dummy;
        while(left != null && right != null){
            if (left.val < right.val){
                cur.next = left;
                left = left.next;
            }else{
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        if (left != null){
            cur.next = left;
        }else{
            cur.next = right;
        }

        return dummy.next;
    }

    // vision 2: heap

    private Comparator<ListNode> ListNodeComparator = new Comparator<ListNode>(){
        @Override
        public int compare(ListNode left, ListNode right){
            if (left == null){
                return 1;
            }else if (right == null){
                return -1;
            }
            return left.val - right.val;
        }
    };

    public ListNode mergeKLists(List<ListNode> lists){
        if (lists==null || lists.size() == 0){
            return null;
        }
        Queue<ListNode> heap= new PriorityQueue<ListNode>(lists.size(), ListNodeComparator);
        for (int i = 0; i < lists.size(); i++){
            if (lists.get(i) != null){
                heap.add(lists.get(i));
            }
        }

        ListNode dummy = new ListNode(0),head = dummy;
        while (heap.size() != 0){
            ListNode temp = heap.poll();
            head.next = temp;
            if (temp.next != null){
                heap.add(temp.next);
            }
            head = head.next;
        }
        return dummy.next;
    }

    // version 3: merge two by two

    public ListNode mergeKLists(List<ListNode> lists){
        if (lists == null || lists.size() == 0){
            return null;
        }

        while (lists.size() > 1){
            List<ListNode> newLists= new ArrayList<ListNode>();
            for (int i = 0; i < lists.size()-1; i+=2){
                ListNode head = mergeTwoLists(lists.get(i),lists.get(i+1));
                newLists.add(head);
            }
            if (lists.size() % 2 == 1){
                newLists.add(lists.get(lists.size()-1));
            }
            lists = newLists;
        }
        return lists.get(0);
    }

    private ListNode mergeTwoLists(ListNode left, ListNode right){
        ListNode dummy = new ListNode(0),cur = dummy;
        while(left != null && right != null){
            if (left.val < right.val){
                cur.next = left;
                left = left.next;
            }else{
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        if (left != null){
            cur.next = left;
        }else{
            cur.next = right;
        }
        return dummy.next;
    }
}
