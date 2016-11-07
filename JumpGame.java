public class Solution {
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     */
    public boolean canJump(int[] A) {
        // wirte your code here
        // state : f(i) means if any cell can jump to the index of i
        // function : f(i) = f(j) when f(j) can be reached and j+A[j] >= i
        // answer : f[n-1] 
        boolean[] f = new boolean[A.length];
        f[0] = true;
        for (int i = 1;i < A.length; i++){
            for (int j = 0 ;j < i; j++){
             if (j + A[j] >= i && f[j]){
                 f[i] = f[j];
                 break;
                }
            }
        }
        return f[A.length-1];
    }
}
