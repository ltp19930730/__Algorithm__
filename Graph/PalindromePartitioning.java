public class Solution {
    /**
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        // write your code here
        List<List<String>> result = new ArrayList<List<String>>();
        if (s == null || s.length() == 0){
            return result;
        }
        List<String> tmp = new ArrayList<String>();
        helper(result, tmp, s, 0);

        return result;
    }


    private void helper(List<List<String>> result, List<String> tmp, String s, int index){
        if (index == s.length()){
            result.add(new ArrayList<String>(tmp));
            return;
        }

        for (int i = index + 1; i <= s.length(); i++) {
            String str = s.substring(index,i);
            if (!isPalindrome(str)){
                continue;
            }
            tmp.add(str);
            helper(result, tmp, s, i);
            tmp.remove(tmp.size() - 1);
        }

    }

    private boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while(left < right){
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
