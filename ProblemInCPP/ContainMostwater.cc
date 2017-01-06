class Solution {
public:
    int maxArea(vector<int>& height) {
        int left=0;
        int right=height.size()-1;
        int maxarea=0;
        int curarea=0;
        while(left<right)
        {
            maxarea=max(maxarea,curarea);
            if(height[left]<height[right])
            {
                curarea=(right-left)*height[left];
                left++;
            }else if(height[left]>height[right])
            {
                curarea=(right-left)*height[right];
                right--;
            }else{
                curarea=(right-left)*height[right];
                right--;
                left++;
            }
            if(maxarea<curarea)
            {
                maxarea=curarea;
            }
            
        }
        return maxarea;
    }
};