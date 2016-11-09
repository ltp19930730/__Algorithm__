public class Solution {
    /**
     * @param A, B: Two strings.
     * @return: The length of longest common subsequence of A and B.
     */
     // for the solution on lintcode
    public int longestCommonSubsequence(String A, String B) {
        // write your code here
        // state : f[i][j] means the max value that the pre i character match with the pre j
        // function f[i][j] = max(f[i-1][j] , f[i][j-1]) when A[i] == B[j] => f[i][j] = f[i-1][j-1] + 1;
        // initialize: f[0][j] and f[i][0] is zero
        // answer: f[m][n]
        int m = A.length();
        int n = B.length();

        if( A == null || B == null || m == 0 || n == 0){
            return 0;
        }

        int[][] f = new int[m+1][n+1];

        for (int i = 1; i <= m; i++){
            for (int j = 1; j <= n; j++){
                 f[i][j] = Math.max(f[i][j-1], f[i-1][j]);
                if (A.charAt(i-1) == B.charAt(j-1)){
                    f[i][j] = f[i-1][j-1] + 1;
                }
            }
        }
        return f[m][n];
    }
}
