public class Solution {
    /**
     * @param arrays k sorted integer arrays
     * @return a sorted array
     */
    public List<Integer> mergekSortedArrays(int[][] arrays) {
        // Write your code here
        List<Integer> result = new ArrayList<Integer>();
        if (arrays == null || arrays.length == 0) {
            return result;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays[i].length; j++) {
                pq.offer(arrays[i][j]);
            }
        }

        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }
        return result;
    }
}
