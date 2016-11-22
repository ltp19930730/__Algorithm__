public class Solution {
    /**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        // write your code here
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if (numbers == null || numbers.length == 0){
            return list;
        }

        Arrays.sort(numbers);

        for (int i = 0; i < numbers.length - 2; i++){
            int target = numbers[i];
            int j = i + 1;
            int k = numbers.length - 1;
            while (j < k){
                if (numbers[j] + numbers[k] > -target){
                    k--;
                }else if (numbers[j] + numbers[k] < -target){
                    j++;
                }else{
                    ArrayList<Integer> result = new ArrayList<>();
                    result.add(numbers[i]);
                    result.add(numbers[j++]);
                    result.add(numbers[k--]);
                    list.add(result);
                    while (j < k && numbers[j] == numbers[j-1]){
                        j++;
                    }
                    while (j < k && numbers[k] == numbers[k+1]){
                        k--;
                    }
                }
            }
            while (i < numbers.length - 2 && numbers[i] == numbers[i+1]){
                i++;
            }
        }
        return list;
    }
}
