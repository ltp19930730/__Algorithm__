package array.easy;

import java.util.Arrays;

/**
* @author Tianpei Luo 
* @email teslaluo@gmail.com
* @date Jan 2, 2017 11:06:26 PM
* 
*/
public class rotateArray {
	public static void rotate(int[] nums, int k) {
        int index = nums.length - k ;
        int[] result = new int[nums.length];
        System.arraycopy(nums,0,result,k,index);
        System.arraycopy(nums,index,result,0,k);
        System.arraycopy(result,0,nums,0,nums.length);
	}
	
	
	// approach that in place which space complexity is O(1)
	public static void rotate2(int[] nums, int k) {
        if (nums == null) {
            return;
        }
        k = k % nums.length;
	    reverse(nums,0,nums.length-1);
	    reverse(nums,0,k-1);
	    reverse(nums,k,nums.length-1);
	}
    private static void reverse(int[] nums, int start, int end){
        while(start < end){
            nums[start] ^= nums[end];
            nums[end] ^= nums[start];
            nums[start] ^= nums[end];
            start++;
            end--;
        }
    }
	public static void main(String[] args) {
		int k = 1;
		int[] nums = new int[]{1,2};
		rotate(nums, k);
		System.out.println(Arrays.toString(nums));
	}

}
