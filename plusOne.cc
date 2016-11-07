#include <iostream>
#include <vector>
using namespace std;
vector<int> plusOne(vector<int>& digits) {
        int index=digits.size()-1;
        int carry =0;
        while(digits[index]==9){
            digits[index]=0;
            carry=1;
            index--;
        }

        if(index<0&&carry==1){
            vector<int> result;
            result.push_back(1);
            for(int i=0;i<digits.size();i++){
                result.push_back(digits[i]);
            }
            return result;
        }else{
            digits[index]+=1;
            return digits;
        }
    }

int main(){
  vector<int>digits={9,9,9,9};
  vector<int>result=plusOne(digits);
  for(auto a:result){
    cout<<a<<" ";
  }
  return 0;
}
