public class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @param target : An integer
     * @return : return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] numbers, int target) {
        // write your code here
        int dif = Integer.MAX_VALUE;
        if (numbers == null || numbers.length == 0){
            return dif;
        }
        int ans = 0;
        Arrays.sort(numbers);

        for (int i = 0; i < numbers.length - 2; i++){
            int left = i + 1;
            int right = numbers.length - 1;
            while (left < right){
                int cur = dif;
                int result = numbers[i] + numbers[left] + numbers[right];
                if (result > target){
                    right--;
                    dif = Math.min(dif, result - target);
                }else if(result < target){
                    left++;
                    dif = Math.min(dif, target - result);
                }else{
                    return result;
                }
                if (cur != dif){
                    ans = result;
                }
            }
        }
        return ans;
    }
}

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3){
            return -1;
        }
        Arrays.sort(nums);
        int best = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++){
            int left = i+1;
            int right = nums.length - 1;
            while (left < right){
                int cur = nums[i] + nums[left] + nums[right];
                if (Math.abs(target - cur) < Math.abs(target - best)){
                    best = cur;
                }
                if (cur > target){
                    right--;
                }else if (cur < target){
                    left++;
                }else{
                    return best;
                }
            }
        }
        return best;
    }
}
