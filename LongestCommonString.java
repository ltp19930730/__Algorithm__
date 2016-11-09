public class Solution {
    /**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String A, String B) {
        // write your code here
        if (A == null || B == null || A.length() == 0 || B.length() == 0){
            return 0;
        }
        int m = A.length();
        int n = B.length();

        int[][] f = new int[m+1][n+1];
        for (int i = 1; i <= m; i++){
            for (int j = 1; j <= n; j++){
                if (A.charAt(i-1) == B.charAt(j-1)){
                    f[i][j] = f[i-1][j-1] + 1;
                }
            }
        }
        int max = 0;
        for (int i = 1; i <= m; i++){
            for (int j = 1; j <= n; j++){
                max = Math.max(f[i][j], max);
            }
        }
        return max;
    }
}
