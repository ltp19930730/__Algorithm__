
// using a hashmap + priorityqueue
// Leetcode 347
public class Solution {
    class FreqEle {
        int freq;
        int val;
        FreqEle(int val) {
            this.val = val;
            freq = 0;
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        PriorityQueue<FreqEle> pq = new PriorityQueue<FreqEle>(new Comparator<FreqEle>() {
                @Override
                public int compare(FreqEle a, FreqEle b) {
                    return b.freq - a.freq;
                }
            });
        HashMap<Integer,FreqEle> hm = new HashMap<Integer, FreqEle>();
        for (int i = 0; i < nums.length; i++){
            if (hm.containsKey(nums[i])){
                hm.get(nums[i]).freq += 1;
            }else{
                hm.put(nums[i],new FreqEle(nums[i]));
            }
        }
        for (Map.Entry<Integer,FreqEle> entry : hm.entrySet()) {
        	pq.offer(entry.getValue());
        }

        List<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i < k; i++) {
            result.add(pq.poll().val);
        }
        return result;
    }
}
