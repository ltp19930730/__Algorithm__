package palindrome;

import org.junit.Test;

public class ShortestPalindrome {
    /*
     * this algorithm will be out of limit time
     */
	public String shortestPalindrome(String s) {
		if (isPalindrome(s)) {
			return s;
		}
		for (int i = s.length() -1; i > 0; i--){
			String subStr = s.substring(0, i);
			if (isPalindrome(subStr)) {
				String a = s.substring(i,s.length());
				String rev = reverse(a);
				s = rev + s;
				return s;
			}
		}
		return s;
	}
	private String reverse(String s) {
		int i = 0, j = s.length() - 1;
		char[] arr = s.toCharArray();
		while (i < j) {
			char tmp = arr[i];
			arr[i] = arr[j];
			arr[j] = tmp;
			i++;
			j--;
		}
		return new String(arr);
	}
	private boolean isPalindrome(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}
		int i = 0, j = s.length() - 1;
		while (i < j) {
			if (s.charAt(i++) != s.charAt(j--)) {
				return false;
			}
		}
		return true;
	}
	@Test
	public void test() {
		System.out.println("test");
		System.out.println(shortestPalindrome("aacecaaa"));
	}
}
