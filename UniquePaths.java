public class Solution {
    /**
     * @param n, m: positive integer (1 <= n ,m <= 100)
     * @return an integer
     */
    public int uniquePaths(int m, int n) {
        // write your code here
        /*
        state : f(x,y) = the totoal number of paths that can be walk to point(x,y)
        function : f(x,y) = f(x-1,y) + f(x,y-1); only from left cell and upper cell
        initialize : f[0][i] = 1 ; f[i][0] = 1
        answer : f[m-1][n-1]
        */
        int [][] f = new int[m][n];
        //initialization
        for (int i=0; i < m; i++){
            f[i][0] = 1;
        }
        for (int i=0; i < n; i++){
            f[0][i] = 1;
        }

        for (int i = 1; i < m; i++){
            for (int j = 1; j < n;j++){
                f[i][j] = f[i][j-1] + f[i-1][j];
            }
        }
        return f[m-1][n-1];
    }
}
