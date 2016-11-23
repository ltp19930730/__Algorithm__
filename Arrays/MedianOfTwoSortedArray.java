class Solution {
    /**
     * @param A: An integer array.
     * @param B: An integer array.
     * @return: a double whose format is *.5 or *.0
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        // write your code here
        int len = A.length + B.length;
        if (len % 2 == 1){
            return findTarget(A, B, (len+1)/2);
        }else{
            return (findTarget(A,B,len/2) + findTarget(A,B, len/2+1))/2.0;
        }
    }

    private int findTarget(int[] A, int[] B, int index){
        // find the target in two sorted array;
        int count = 0;
        int i = 0;
        int j = 0;
        while (i < A.length && j < B.length){
            if (A[i] < B[j]){
                count++;
                if (index == count){
                    return A[i];
                }
                i++;
            }else{
                count++;
                if (index == count){
                    return B[j];
                }
                j++;
            }
        }
        if (i < A.length){
            return A[i+index-count-1];
        }else{
            return B[j+index-count-1];
        }
    }
}
