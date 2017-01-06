#include <iostream>
using namespace std;

class Solution {
public:
    int searchInsert(vector<int>& nums, int target) {
        int start=0;
		int end = nums.size()-1;
			if(nums[start]>target)
		{
			return start;
		}
		if(nums[end]<target)
		{
			return end+1;
		}
        while(start<=end)
        {
          int mid=start+(end-start)/2;
          if(nums[mid]==target)
           {
           	   return mid;
           }else if(nums[mid]<target)
           {  
           	   start=mid+1;
           }else{
           	    end=mid-1;
           }
        }
         return start;
    }
};