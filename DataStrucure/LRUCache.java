public class Solution {
 // just using a hashmap and a double linked list to realize it
 // or using the data structure in java which called linkedHashMap
    class Node{
        Node prev;
        Node next;
        int key;
        int val;
        Node(int key, int val) {
          prev = null;
          next = null;
          this.key = key;
          this.val = val;
        }
    }

    Node head;
    Node tail;
    HashMap<Integer, Node> hm;
    int capacity;

    // @param capacity, an integer
    public Solution(int capacity) {
        // write your code here
        hm = new HashMap<Integer,Node>();
        this.capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);

        head.next = tail;
        tail.prev = head;
    }

    // @return an integer
    public int get(int key) {
        // write your code here
        if (hm.containsKey(key)) {
            // move the node to the end of the linkedlist
            Node cur = hm.get(key);
            cur.prev.next = cur.next;
            cur.next.prev = cur.prev;
            addInTail(cur.key, cur.val);
            return hm.get(key).val;
        }else{
            return -1;
        }
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
        // write your code here
        if (get(key) != -1) {
            hm.get(key).val = value;
            return;
        }
        if (hm.size() == capacity) {
            //remove the node next to the head;
            Node cur = head.next;
            head.next = head.next.next;
            head.next.prev = head;
            hm.remove(cur.key);
        }
        addInTail(key, value);
    }

    private void addInTail(int key, int value) {
        Node newNode = new Node(key, value);
        newNode.prev = tail.prev;
        newNode.prev.next = newNode;
        newNode.next = tail;
        tail.prev = newNode;
        hm.put(key,newNode);
    }
}
