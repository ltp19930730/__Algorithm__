package permutation.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class Permutation {
	public List<List<Integer>> permutation(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return result;
		}

		boolean[] visited = new boolean[nums.length];
		List<Integer> cur = new ArrayList<>();
		helper(result,cur,visited,nums);
		return result;
	}
	
	private void helper(List<List<Integer>> result, List<Integer> cur, boolean[] visited, int[] nums) {
		if (cur.size() == nums.length) {
			result.add(new ArrayList<Integer>(cur));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (!visited[i]) {
				cur.add(nums[i]);
				visited[i] = true;
				helper(result,cur,visited,nums);
				cur.remove(cur.size()-1);
				visited[i] = false;
			}
		}
	}
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result = new ArrayList<>();
		if ( n <= 0 || k > n) {
			return result;
		}
		List<Integer> cur = new ArrayList<>();
		helper2(result,cur,1,k,n);
		return result;
 	}
	
	private void helper2(List<List<Integer>> result, List<Integer> cur, int start, int max, int n) {
		if (cur.size() == max) {
			result.add(new ArrayList<Integer>(cur));
		}
		for (int i = start; i <= n; i++) {
			cur.add(i);
			helper2(result,cur,i+1,max,n);
			cur.remove(cur.size()-1);
		}
	}
	@Test
	public void test() {
		System.out.println( permutation(new int[]{1,2,3}));
		System.out.println(combine(4, 2));
	}
}
