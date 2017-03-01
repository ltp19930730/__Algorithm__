package two_pointer;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class MissRange {
	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
		List<String> result = new ArrayList<>();
		int prev = lower;
		for (int i = 0; i <= nums.length; i++) {
			if (prev == Integer.MAX_VALUE+1) {
				break;
			}
			int cur = 0;
			if (i != nums.length && nums[i] <= upper){
				cur = nums[i];
			}else{
				cur = upper+1;
			}
			if (prev == cur) {
				prev++;
			}else if (prev < cur){
				if (cur - prev == 1){
					result.add(String.valueOf(prev));
				}else{
					result.add(String.valueOf(prev)+"->"+String.valueOf(cur-1));
				}
				prev = cur+1;
			}else{
				continue;
			}
		}
		return result;
	}
	// test case 1: lower = 0, upper = 99 and Given array [0,1,3,50,75]
	// the output should be ["2","4->49","51->74","76->99"]
	@Test
	public void test() {
		int[] nums = {1,3,50,Integer.MAX_VALUE,Integer.MAX_VALUE};
		System.out.println(findMissingRanges(nums, 0,Integer.MAX_VALUE ));
	}
}
