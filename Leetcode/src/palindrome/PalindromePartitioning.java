package palindrome;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/*
 *  dfs same with combination and permutation
 */
public class PalindromePartitioning {
	public List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<>();
		if (s == null || s.length() == 0) {
			return result;
		}
		List<String> cur = new ArrayList<>();
		helper(result,cur,0,s);
		return result;

	}
	
	private void helper(List<List<String>> result, List<String> cur, int index, String s){
		if(index == s.length()){
			result.add(new ArrayList<String>(cur));
			return;
		}
		for (int i = index+1; i <= s.length(); i++){
			String subStr = s.substring(index, i);
			if (!isPalindrome(subStr)) {
				continue;
			}
			cur.add(subStr);
			helper(result,cur,i,s);
			cur.remove(cur.size() - 1);
		}
	}
	private boolean isPalindrome(String s){
		if (s == null || s.length() == 0){
			return true;
		}
		int i = 0, j = s.length()-1;
		while(i < j){
			if (s.charAt(i++) != s.charAt(j--)) {
				return false;
			}
		}
		return true;
	}
	@Test		
	public void test() {
		System.out.println(partition("aab"));
	}
}
