/*
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets.
*/

class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
       vector<vector<int>>output;
      if( nums.size()<=2)return output;
      sort(nums.begin(),nums.end());
      for(int i=nums.size()-1;i>=2;i--)
      {
       if(i<nums.size()-1 &&nums[i]==nums[i+1])continue;
        vector<vector<int>>cur_output = twoSum(nums,i-1,-nums[i]);
        for(int j=0;j<cur_output.size();j++)
        {
          cur_output[j].push_back(nums[i]);
        }
        output.insert(output.end(),cur_output.begin(),cur_output.end());
      }
      return output;
    }
    vector<vector<int>> twoSum(vector<int>&nums,int end,int target)
    {
      vector<vector<int>>output;
      if(nums.size()<=1)return output;
      int l=0;
      int r=end;
      while(l<r)
      {
        if(nums[l]+nums[r]==target)
        {
          vector<int>items;
          items.push_back(nums[l]);
          items.push_back(nums[r]);
          output.push_back(items);
          l++;
          r--;
          while(l<r&&nums[l]==nums[l-1])l++;
          while(l<r&&nums[r]==nums[r+1])r--;
        }
        else if(nums[l]+nums[r]>target)
        {
          r--;
        }
        else if(nums[l]+nums[r]<target)
        {
          l++;
        }
      }
      return output;
    }
};;
