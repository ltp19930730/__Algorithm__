#include <iostream>
#include <string>
using namespace std;
string convert(string s, int numRows) {
        if(numRows<=1){
            return s;
        }
        string result;
        int index=1;
        int magic=2*numRows-2;
        int len=s.length();
        while(index<=numRows){
            int i=index;
            while(i<=len){
            result+=s[i-1];
            i+=magic;
            if(1<index&&index<numRows&&i<=len){
                  result+=s[i-1];
                  i+=2*(index-1);
                }
            }
            magic-=2;
          if(magic==0){
            magic=2*numRows-2;
          }
          index++;
        }
        return result;
    }
int main(){
  string s="PAYPALISHIRING";
  cout<<convert(s,3);
  return 0;
}
