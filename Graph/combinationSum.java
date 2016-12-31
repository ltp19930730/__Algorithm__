public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target:An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0){
            return result;
        }
        Arrays.sort(candidates);
        List<Integer> cur = new ArrayList<Integer>();
        helper(candidates, result, cur, target, 0);
        return result;
    }

    private void helper(int[] candidates, List<List<Integer>> result, List<Integer> cur, int target, int index) {
        if (target == 0) {
            result.add(new ArrayList(cur));
            return;
        }
        int prev = -1;
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] > target){
                break;
            }
            if (prev != -1 && prev == candidates[i]){
                continue;
            }
            cur.add(candidates[i]);
            helper(candidates, result, cur, target - candidates[i], i);
            cur.remove(cur.size() - 1);

            prev = candidates[i];
        }
    }
}
