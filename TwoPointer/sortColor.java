class Solution {
    /**
     * @param nums: A list of integer which is 0, 1 or 2
     * @return: nothing
     */
     // two pointer
    private void swap(int[] nums, int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
    public void sortColors(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0){
            return ;
        }
        int left = 0;
        int right = nums.length - 1;
        int i = 0;
        while (i <= right){
            if (nums[i] == 0){
                swap(nums, left, i);
                i++;
                left++;
            }else if (nums[i] == 2){
                swap(nums, right, i);
                right--;
            }else{
                i++;
            }
        }
    }

    //counting sort with two passing algorithm
    public void sortColors(int[] nums) {
    //first using counting sort
      if(nums == null || nums.length == 0){
          return ;
      }
      int[] count = new int[3];
      for (int i = 0; i < nums.length; i++){
          count[nums[i]]+=1;
      }
      for (int i = 0; i < nums.length; i++){
          if (i < count[0]){
              nums[i] = 0;
          }else if (i < count[0]+count[1] && i >= count[0]){
              nums[i] = 1;
          }else{
              nums[i] = 2;
          }
      }
    }
}
