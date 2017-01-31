package dynamic.programming.hard;
/**
* @author Tianpei Luo 
* @email teslaluo@gmail.com
* @date Jan 6, 2017 4:58:11 PM
* 
*/

/*
 *  dynamic programming recursive version
 */
public class EditDistance {
	public static int min(int x, int y, int z){
		return Math.min(x, Math.min(y, z));
	} 
	
	public static int minDistance(String word1, String word2) {
		if (word1 == null && word2 == null){
			return -1;
		}
		if (word1 == null || word1.length() == 0) {
			return word2.length();
		}
		if (word2 == null || word2.length() == 0) {
			return word1.length();
		}
		return helper(word1,word2,word1.length(),word2.length());
	}
	
	private static int helper(String word1,String word2, int m, int n) {
		if (m == 0) {
			return n;
		}
		if (n == 0) {
			return m;
		}
		
		if (word1.charAt(m-1) == word2.charAt(n-1)) {
			return helper(word1, word2, m-1, n-1);
		}
		
		return 1 + min(helper(word1, word2, m, n-1),
				helper(word1, word2, m-1, n), 
				helper(word1, word2, m-1, n-1));
	}
	public static void main(String[] args) {
		System.out.println(minDistance("gaaaood", "gooa"));
	}
}
