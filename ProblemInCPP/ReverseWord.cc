#include <string>
#include <iostream>
using namespace std;
class solution{
public:
  void ReverseWord(string&s){
    int from = 0;
    int new_from = 0;
    int l = 0;
    int length=s.length();
    int wordcount = 0;
    while(1){
      while(from<length && s[from]==' ')from++;
      if(from==length)break;
      if(wordcount)s[new_from++]=' ';
      l=new_from;
      while(from<length && s[from]!= ' '){
        s[new_from]=s[from];
        from++;
        new_from++;
      }
      ReverseString(s,l,new_from-1);
      wordcount++;
    }
    s.resize(new_from);
    ReverseString(s,0,new_from-1);
  }
  void ReverseString(string &s,int from,int to){
    char lastChar;
    while(from < to){
      lastChar=s[from];
      s[from++]=s[to];
      s[to--]=lastChar;
    }
  }
};

int main(){
  string str="     I am      a student.        ";
  solution a;
  a.ReverseWord(str);
  cout << str;

  return 0;
}
