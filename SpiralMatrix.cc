//using recursive, not too difficult
#include <vector>
#include <iostream>
using namespace std;

class solution{
  public:
    vector<int> spiralMatrix(vector<vector<int>>& input){
    vector<int>output;
    int row_len=input.size();
    if(row_len==0)return output;
    int col_len=input[0].size();
    Spiral(input,0,row_len,0,col_len,output);
    return output;
  }

  void Spiral(vector<vector<int>>& input,int row_s,int row_len,int col_s,int col_len,vector<int>& output){
    if(row_len<=0||col_len<=0)return;
    if(row_len==1){
      for(int i=col_s;i<col_s+col_len;++i)
      {
        output.push_back(input[row_s][i]);
      }
      return;
    }
    if(col_len==1){
      for(int i=row_s;i<row_s+row_len;++i){
        output.push_back(input[i][col_s]);
      }
      return;
    }
    //top
    for(int i=col_s;i<col_len+col_s-1;++i)
    {
      output.push_back(input[row_s][i]);
    }
    //right
    for(int i=row_s;i<row_s+row_len-1;++i){
      output.push_back(input[i][col_s+col_len-1]);
    }
    //bottom
    for(int i=col_s+col_len-1;i>col_s;--i){
      output.push_back(input[row_s+row_len-1][i]);
    }
    //left
    for(int i=row_s+row_len-1;i>row_s;--i){
      output.push_back(input[i][col_s]);
    }
    Spiral(input,row_s+1,row_len-2,col_s+1,col_len-2,output);
  }
};

int main(){
  vector<vector<int>>Matrix={{1,2,3,4},
                             {5,6,7,8},
                             {9,10,11,12},
                             {13,14,15,16}};

  solution a;
  vector<int>output;
  output=a.spiralMatrix(Matrix);

  for(auto &a:output){
    cout<<a<<'\t';
  }

  return 0;
}
