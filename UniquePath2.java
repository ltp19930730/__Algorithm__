public class Solution {
    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;

        int[][] f = new int[row][col];
        // initialize
        boolean isBlock = false;
        for (int i = 0 ; i < col; i++){
            if(obstacleGrid[0][i] == 1){
                isBlock = true;
            }
            if(!isBlock){
                f[0][i] = 1;
            }else{
                f[0][i] = 0;
            }
        }
        isBlock = false;
        for (int i = 0 ; i < row; i++){
            if(obstacleGrid[i][0] == 1){
                isBlock = true;
            }
            if(!isBlock){
                f[i][0] = 1;
            }else{
                f[i][0] = 0;
            }
        }

        for (int i = 1; i < row; i++){
            for (int j = 1; j < col; j++){
                 if(obstacleGrid[i][j] == 1){
                     f[i][j] = 0;
                 }else{
                     f[i][j] = f[i-1][j] + f[i][j-1];
                 }
            }
        }
        return f[row-1][col-1];
    }
}
