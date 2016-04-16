/*Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

Example:
For num = 5 you should return [0,1,1,2,1,2].

It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
Space complexity should be O(n).
Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.

There is NO __builtin_popcount in c++, it's a built in function of GCC.

The function prototype is as follows:
 int  __builtin_popcount(unsigned int)

It returns the numbers of  bits in an integer (the number of ones in the binary representation of the integer).

For example,
 cout<< __builtin_popcount (4);
The above code gives "1" as output.

Why to use it?
This function tries to use CPU specific instructions, which will always  be orders of magnitude faster than any algorithm you manage to come up  with.
*/
class Solution {
public:
    vector<int> countBits(int num) {
        vector<int> curinput;
        int arr[4]={0,1,1,2};
        if(num<4)
        for(int i=0;i<num;i++){
        curinput.push_back(arr[i]);
        }else{
            int times = num / 4;
            int temp = (num+1) % 4;
            int iterate=1;
            while(iterate<times){
            for(int i=0;i<4;i++)
            {
                curinput.push_back(arr[i]+iterate);
            }
            iterate++;
            }
            for(int j=0;j<temp;j++)
            {
                curinput.push_back(arr[j]+times);
            }
        }
        return curinput;
    }
};
