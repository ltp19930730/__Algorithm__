/*
Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
*/

    /**
     * 对arr数组中的begin~end进行全排列
     *
     * 比如：
     *  arr = {1,2,3}
     *  第一步：执行 perm({1,2,3},0,2),begin=0,end=2;
     *      j=0,因此执行perm({1,2,3},1,2),begin=1,end=2;
     *          j=1,swap(arr,0,0)-->arr={1,2,3},  perm({1,2,3},2,2),begin=2,end=2;
     *              因为begin==end，因此输出数组{1,2,3}
     *          swap(arr,1,1) --> arr={1,2,3};
     *          j=2,swap(arr,1,2)-->arr={1,3,2},  perm({1,3,2},2,2),begin=2,end=2;
     *              因为begin==end，因此输出数组{1,3,2}
     *          swap(arr,2,1) --> arr={1,2,3};
     *      j=1,swap(arr,0,1) --> arr={2,1,3},     perm({2,1,3},1,2),begin=1,end=2;
     *          j=1,swap(arr,1,1)-->arr={2,1,3}   perm({2,1,3},2,2),begin=2,end=2;
     *              因为begin==end，因此输出数组{2,1,3}
     *          swap(arr,1,1)--> arr={2,1,3};
     *          j=2,swap(arr,1,2)后 arr={2,3,1},并执行perm({2,3,1},2,2),begin=2,end=2;
     *              因为begin==end，因此输出数组{2,3,1}
     *          swap(arr,2,1) --> arr={2,1,3};
     *      swap(arr,1,0)  --> arr={1,2,3}
     *      j=2,swap(arr,2,0) --> arr={3,2,1},执行perm({3,2,1},1,2),begin=1,end=2;
     *          j=1,swap(arr,1,1) --> arr={3,2,1} , perm({3,2,1},2,2),begin=2,end=2;
     *              因为begin==end，因此输出数组{3,2,1}
     *          swap(arr,1,1) --> arr={3,2,1};
     *          j=2,swap(arr,2,1) --> arr={3,1,2},并执行perm({2,3,1},2,2),begin=2,end=2;
     *              因为begin==end，因此输出数组{3,1,2}
     *          swap(arr,2,1) --> arr={3,2,1};
     *      swap(arr,0,2) --> arr={1,2,3}

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
