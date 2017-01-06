#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class subset{
public:
  vector<vector<int>> subsets(vector<int>& nums){
    vector<vector<int>> result;
    vector<int> temp;
    int n = nums.size();
    result.push_back(temp);

    if(n!=0){
      sort(nums.begin(),nums.end());
      backtracking(result,temp,nums,0);
    }
    return result;
  }
  void backtracking(vector<vector<int>>& result,vector<int>& temp,vector<int>& nums,int start){
    for(int i=start;i<nums.size();i++){
      temp.push_back(nums[i]);
      result.push_back(temp);
      if(i<nums.size()-1){
        backtracking(result,temp,nums,i+1);
      }
        temp.pop_back();

    }
  }
};

int main(){
  subset a;
  vector<int> nums = {1,2,3,5,4};
  vector<vector<int>> output;
  output = a.subsets(nums);
  for(int i = 0;i<output.size(); i++){
      cout<<"[";
    for(int j = 0;j<output[i].size(); j++){

      cout<<output[i][j]<<" ";
    }
    cout<<"]"<<endl;
  }
  return 0;
}
