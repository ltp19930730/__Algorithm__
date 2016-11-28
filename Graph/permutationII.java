class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of unique permutations.
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        // Write your code here
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null) {
            return result;
        }
        if (nums.length == 0){
            result.add(new ArrayList<Integer>());
            return result;
        }

        List<Integer> cur = new ArrayList<Integer>();

        int[] visited = new int[nums.length];
        Arrays.sort(nums);
        helper(result, cur, visited, nums);
        return result;

    }


    private void helper(List<List<Integer>> result, List<Integer> cur, int[] visited, int[] nums) {
        if (cur.size() == nums.length) {
            result.add(new ArrayList<Integer>(cur));
            return ;
        }

        for( int i = 0; i < nums.length; i++) {
            if (visited[i] == 1 || ( i > 0 && nums[i] == nums[i-1] &&
                visited[i-1] == 0)) {
                    continue;
            }
            cur.add(nums[i]);
            visited[i] = 1;
            helper(result, cur, visited, nums);

            cur.remove(cur.size() - 1);
            visited[i] = 0;

        }

    }
}
