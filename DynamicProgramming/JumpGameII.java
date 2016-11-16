public class Solution {
    /**
     * @param A: A list of lists of integers
     * @return: An integer
     */
    public int jump(int[] A) {
        // write your code here
        /*
            state: f(i) the minimum step to jump to the index i
            initilize: f(0) = 0;
            function: f(x) = min(f(j)) + 1 which satisify the statement: j + A[j] >= x && j < x
            answer: f(n-1)
        */
        int[] f = new int[A.length];
        f[0] = 0;
        for (int i = 1; i < A.length; i++){
            int best = 0;
            boolean isFirst = true;
            for (int j = 0; j < i; j++){
                if (A[j] + j >= i){
                    if (isFirst){
                        best = f[j];
                        isFirst = false;
                    }else{
                        best = Math.min(f[j], best);
                    }
                }
            }
            f[i] = best + 1;
        }
        return f[A.length-1];
    }
}
