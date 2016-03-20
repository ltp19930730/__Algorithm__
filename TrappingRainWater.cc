#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    int trap(vector<int>& height) {
        int water=0;
        int leftmax=0,rightmax=0;
        int left_P=0;
        int right_P=height.size()-1;
        while(left_P<=right_P)
        { 
            if(height[left_P]<=height[right_P]){
                if(height[left_P]>=leftmax)
                {
                    leftmax=height[left_P];
                }else{
                    water+=leftmax-height[left_P];
                }
                left_P++;
                
            }else{
                if(height[right_P]>=rightmax)
                {
                    rightmax=height[right_P];
                }else{
                    water+=rightmax-height[right_P];    
                }
                right_P--;
            }
        }
        return water;
    }
};
int main()
{
	Solution sol;
	vector<int> a {0,1,0,2,1,0,1,3,2,1,2,1};
	cout<<sol.trap(a);
		return 0;
}