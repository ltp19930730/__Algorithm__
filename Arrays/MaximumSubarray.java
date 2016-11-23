public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
     // prefix sum algorithm
    public int maxSubArray(int[] nums) {
        // write your code
        if (nums == null|| nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return nums[0];
        }
        int max = Integer.MIN_VALUE,sum = 0, minSum = 0;

        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
            max = Math.max(max,sum-minSum);
            minSum = Math.min(minSum,sum);
        }
        return max;
    }
}
