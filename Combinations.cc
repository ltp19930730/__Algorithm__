/*
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
*/
class Solution {
public:
    vector<vector<int>> combine(int n, int k) {
        vector<vector<int>>output;
        vector<int>output_fake;
        backtracking(output,output_fake,n,k,1);
        return output;
    }
    void backtracking(vector<vector<int>>&output,vector<int>&output_fake,
    int n,int k,int level)
    {
        if(output_fake.size()==k)
        {
            output.push_back(output_fake);
            return;
        }
        for(int i=level;i<=n;i++)
        {
            output_fake.push_back(i);
            backtracking(output,output_fake,n,k,i+1);
            output_fake.pop_back();
        }

    }

};
