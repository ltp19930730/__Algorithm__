public class Solution {
    /**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0){
            return 0;
        }
        int[] f = new int[nums.length];
        f[0] = 1;
        int max_seq = 0;
        for (int i = 0; i < nums.length; i++){
            int best = 0;
            for (int j = 0; j < i; j++){
                if (nums[j] < nums[i] ){
                        best = Math.max(f[j], best);
                    }
                }
             f[i] = best + 1;
             max_seq = Math.max(f[i],max_seq);
        }
        return max_seq;
    }
}
