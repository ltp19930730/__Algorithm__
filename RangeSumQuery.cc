class NumArray {
public:
    vector<int>input;
    NumArray(vector<int> &nums) {
        //must resize or the time will be out of limited 如果不resize的话vector会grow大小，然后进行复制会慢很多！！！
        input.resize(nums.size()+1);
        input[0]=0;
        for(int i=1;i<=nums.size();++i){
            input[i]=nums[i-1]+input[i-1];
        }
    }

    int sumRange(int i, int j) {
        return input[j+1]-input[i];
    }
};


// Your NumArray object will be instantiated and called as such:
// NumArray numArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);
