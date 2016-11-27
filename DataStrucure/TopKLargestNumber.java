class Solution {
    /*
     * @param nums an integer array
     * @param k an integer
     * @return the top k largest numbers in array
     */
    public int[] topk(int[] nums, int k) {
        // Write your code here
        int[] result = new int[k];
        if (nums == null || nums.length == 0){
            return result;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k, new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b){
                return b - a;
            }
        });

        for (int i = 0; i < nums.length; i++){
            pq.offer(nums[i]);
        }

        for (int i = 0; i < k; i++){
            result[i] = pq.poll();
        }
        return result;
    }
};
