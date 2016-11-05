#include <iostream>
#include <string>
#include <cmath>

using namespace std;
// 越界 when the number is too big ,this method is suck!!!
// int binaryTransfer(string a){
//   int number=0;
//   int len=a.length();
//   for(int i=0;i<a.length();i++){
//     number+=(a[i]-'0')*pow(2,len-1);
//     len--;
//   }
//   return number;
// }
//
// string addBinary(string a,string b){
//   string result="";
//   int number=binaryTransfer(a)+binaryTransfer(b);
//   if(number==0){
//     return "0";
//   }
//   while(number>0){
//     int index=number%2;
//     if(index==1){
//       result.insert(result.begin(),'1');
//     }else{
//       result.insert(result.begin(),'0');
//     }
//     number/=2;
//   }
//   return result;
// }

string addBinary(string a,string b){
  string result="";
  int carry=0;
  for(int i=a.length()-1,j=b.length()-1;i>=0||j>=0;i--,j--){
    int na=i>=0?a[i]-'0':0;
    int nb=j>=0?b[j]-'0':0;
    int val=(na+nb+carry)%2;
    carry=(na+nb+carry)/2;
    result.insert(result.begin(),val+'0');
  }
  if(carry==1){
    result.insert(result.begin(),'1');
  }
  return result;
}



int main(){
  string a="1111111111111111111111111111111111111111111111";
  string b="1";
  cout<<addBinary(a,b);
  return 0;
}
