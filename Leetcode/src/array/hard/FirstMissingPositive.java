package array.hard;

import java.util.Arrays;

import org.junit.Test;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int i = 0, n = nums.length;
        while (i < n) {
            int cur = nums[i];
            if (cur > 0 && cur < n && nums[cur] != cur) {
                swap(nums, i, cur);
            }else{
                i++;
            }
        }
        for (i = 1; i < n; i++){
            if (i != nums[i]){
                break;
            }
        }
        if (n == 0 || i < n) {
            return i;
        }else{
            return nums[0] == i ? i + 1 : i;
        }
    }
    private void swap(int[] nums, int i, int j) {
        nums[i] = nums[i]^nums[j];
        nums[j] = nums[i]^nums[j];
        nums[i] = nums[i]^nums[j];
    }
    @Test
    public void test() {
    	int[] nums = new int[]{1};
    	System.out.println(firstMissingPositive(nums));
    	System.out.println(Arrays.toString(nums));
    }
}
