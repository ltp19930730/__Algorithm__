#include <iostream>
#include <vector>
using namespace std;


public:
    bool containsNearbyDuplicate(vector<int>& nums, int k) {
        unordered_map<int,int>map;
        for(int i=0;i<nums.size();i++){
            if(map.count(nums[i])&&i-map[nums[i]]<=k){
                return true;
            }
            map[nums[i]]=i;
        }
        return false;
    }


int main(){
  vector<int>nums={0,1,2,3,4,5,0};
  if(containsNearbyDuplicate(nums,6)){
    cout<<"true"<<endl;
  }
  return 0;
}
