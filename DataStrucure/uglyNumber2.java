class Solution {
    /**
     * @param n an integer
     * @return the nth prime number as description.
     */
    public int nthUglyNumber(int n) {
        // Write your code here
        int[] uglyNumber = new int[n];
        uglyNumber[0] = 1;

        int index_2 = 0;
        int index_3 = 0;
        int index_5 = 0;

        int count = 0;

        while(count + 1< n) {

            int a = uglyNumber[index_2] * 2;
            int b = uglyNumber[index_3] * 3;
            int c = uglyNumber[index_5] * 5;

            if (a == findMin(a,b,c)) {
                uglyNumber[count+1] = a;
                index_2++;
            }
            if (b == findMin(a,b,c)) {
                uglyNumber[count+1] = b;
                index_3++;
            }
            if (c == findMin(a,b,c)) {
                uglyNumber[count+1] = c;
                index_5++;
            }
            count++;
        }


        return uglyNumber[n-1];
    }


    private int findMin(int a, int b, int c){
        // int min = a>b ? b:a;
        int min = Math.min(a,b);
        return Math.min(min,c);
    }
};
