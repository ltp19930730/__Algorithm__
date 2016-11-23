class Solution {
    /**
     * @param A: sorted integer array A which has m elements,
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
        // int index = 0;
        // for (int i = m; i < m+n; i++){
        //     A[i] = B[index++];
        // }
        // Arrays.sort(A);
        int i = m - 1,k = n - 1;

        while(k >= 0 && i>=0){
            if (A[i] >= B[k]){
                A[i+k+1] = A[i];
                i--;
            }else{
                A[i+k+1] = B[k];
                k--;
            }
        }
        while (k >= 0){
            A[k] = B[k--];
        }
    }
}
