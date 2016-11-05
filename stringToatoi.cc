#include <iostream>
#include <cmath>
#include <string>

using namespace std;

double myAtoi(string str) {
    int carry=0;
    double result=0;
    for(int i=str.size()-1;i>=0;--i){
      result+=(str[i]-'0')*pow(10,carry);
      carry++;
    }
    return result;
}

int main(){
  string a = "1234561";
  cout<<myAtoi(a);
  return 0;

}
