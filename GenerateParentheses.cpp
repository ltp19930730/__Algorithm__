#include <iostream>
#include <vector>
#include <string>
using namespace std;
class Parentheses{
public:
    vector<string> generateParentheses(int n){
      vector<string> result;
      if(n<1){
        return result;
      }
      string temp;
      generate(result,temp,n,0,0,0);
      return result;
  }

  void generate(vector<string>&result,string& temp,int n,int deep,int leftP,int rightP){
    if(deep==2*n){
      result.push_back(temp);
      return;
    }
    if(leftP<n){
      temp.push_back('(');
      generate(result,temp,n,deep+1,leftP+1,rightP);
      temp.pop_back();
    }
    if(rightP<leftP){
      temp.push_back(')');
      generate(result,temp,n,deep+1,leftP,rightP+1);
      temp.pop_back();
    }
  }
};

int main(){
  Parentheses a;
  vector<string> b;
  b=a.generateParentheses(3);
  for(int i = 0;i<b.size();i++){
    cout<<b[i]<<endl;
  }
  return 0;
}
