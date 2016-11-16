public class Solution {
    /**
     * @param grid: a list of lists of integers.
     * @return: An integer, minimizes the sum of all numbers along its path
     */
    public int minPathSum(int[][] grid) {
        // write your code here
        /*
            state: f(x,y) = the minimum path to reach the point
            function : f(x,y) = Min(f(x,y-1),f(x-1,y)) + weight;
            initialize: f(i,0) and f(0,i)
            answer: f(x,y);
        */
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] f = new int[rows][cols];
        //initialize
        f[0][0] = grid[0][0];
        for (int i = 1; i < rows; i++){
            f[i][0] = f[i-1][0] + grid[i][0];
            }
        for (int i = 1; i < cols; i++){
                f[0][i] = f[0][i-1] + grid[0][i];
            }
        for (int i = 1; i < rows; i++){
            for (int j = 1; j < cols; j++){
                f[i][j] = Math.min(f[i-1][j], f[i][j-1]) + grid[i][j];
            }
        }
        return f[rows-1][cols-1];
    }
}
