class Solution {
public:
    bool containsDuplicate(vector<int>& nums) {
           return nums.size() > set<int>(nums.begin(), nums.end()).size();
    }
};
//sort the vector first , the time complexity is O(lgn*n);
//space complexity is O(1)
class Solution {
public:
    bool containsDuplicate(vector<int>& nums) {
        if(nums.empty())
        {
            return false;
        }
       sort(nums.begin(),nums.end());
       for(int i=0;i<nums.size()-1;i++){
           if(nums[i]==nums[i+1]){
               return true;
           }
       }
       return false;
    }
};

class Solution {
public:
    bool containsDuplicate(vector<int>& nums) {
        if(nums.empty())
        {
            return false;
        }
        unordered_map<int,int> p;
        for(int i:nums)
        {
            if(++p[i]>1){
                return true;
            }
        }
        return false;
    }
};
