#include <iostream>
using namespace std;

class solution{
public:
	int searchInsert(vector<int>& num,int target)
	{
		int start=0;
		int end = num.size()-1;
		if(num[start]>target)
		{
			return start;
		}
		if(num[end]<target)
		{
			return end+1;
		}
        while(start<end)
        {
           int mid=(start+end)/end;
           if(num[mid]==target)
           {
           	   return mid;
           }else if(num[mid]<target)
           {  
           	   start=mid;
           }else{

           	    end=mid;
           }
           return start;
        }
	}

};
