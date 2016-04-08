/*
Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
*/
#include<iostream>
using namespace std;

#include<vector>
#include<algorithm>
class Solution {
public:
    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>>output;
        Permutation(output,nums,0);
        return output;
    }

    void Permutation(vector<vector<int>>output,vector<int>& nums,int begin)
    {
      if(begin==nums.size())
      {
        output.push_back(nums);
        for(auto it=nums.begin();it!=nums.end();it++)
        {
          cout<<*it<<' ';
        }
        cout<<endl;
      }
      for(int i=begin;i<nums.size();i++)
      {
        swap(nums[begin],nums[i]);
        Permutation(output,nums,begin+1);
        swap(nums[begin],nums[i]);
      }
    }
};

int main()
{
  Solution a;
  vector<int>nums;
  for(int i=1;i<5;i++)
  {
    nums.push_back(i);
  }
  vector<vector<int>>b=a.permute(nums);
}
