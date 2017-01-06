#include <iostream>
#include <vector>
using namespace std;

class solution{
public:
	vector<int> productExceptSelf(vector<int>& num)
	{
        vector<int> res(num.size(),1);
        for(int i=1;i<num.size();i++)
        {
        	res[i]=res[i-1]*num[i-1];
        }
        int rig=1;
        for(int i=num.size()-1;i>=0;i--)
        {
        	res[i]*=rig;
        	rig*=num[i];

        }
        return res;
	}
vector<int> productExceptSelf_optim(vector<int>& nums)
{
        int n=nums.size();
        int left=1, right=1;
        vector<int> result(n, 1);
        for(int i=0; i<n; i++){
            result[i]*=left;
            result[n-1-i]*=right;
            left*=nums[i];
            right*=nums[n-1-i];
        }
        return result;
   }
};

int main()
{
	solution a;
	vector<int> res{1,2,3,4};
	vector<int> b=a.productExceptSelf_optim(res);
    for(int i=0;i<b.size();i++)
    {
    	cout<<b[i]<<'\t';
    }
	return 0;
}