package array.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class LongestChain {
	public int longestChain(String[] input) {
		if (input == null || input.length == 0) {
			return 0;
		}
		Set<String> hs = new HashSet<>();
		for (String str : input) {
			hs.add(str);
		}
		Map<String,Integer> hm = new HashMap<>();
		int maxLen = 0;
		for (String str: input) {
			maxLen = Math.max(maxLen,dfs(hs,hm,str));
		}
		return maxLen;
	}
	private int dfs(Set<String> hs,Map<String,Integer> hm,String word) {
		int result = 0;
		for (int i = 0; i < word.length(); i++) {
			String newWord = word.substring(0, i) + word.substring(i+1);
			if (hs.contains(newWord)){
				if (hm.containsKey(newWord)){
					result = Math.max(result, hm.get(newWord));
				}else{
					result = Math.max(result, dfs(hs,hm,newWord));
				}
			}
		}
		hm.put(word, result+1);
		return result+1;
	}
	
	@Test
	public void test(){
		String[] input = {"","a","b","abc","abcd"};
		System.out.println(longestChain(input));

	}
	
}
