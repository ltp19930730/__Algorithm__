package palindrome;

public class PalindromeNumber {
	public boolean isPalindrome(int x) {		
        if (x < 0) {
            return false;
        }
        int reverse = 0,cur = x;
        while(cur != 0) {
            int digit = cur % 10;
            cur = cur /10;
            reverse = reverse*10 + digit;
        }
        if (reverse == x) {
            return true;
        }
        return false;
	}
}
