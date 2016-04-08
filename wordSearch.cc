/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
*/
class Solutiom{
public:
  bool exist(vector<vector<char>>& board,string word){   
    if(word==NULL || word.length()==0)
    {
      return true;
    }
    if(board.empty() || board.size()==0 || board[0].size()==0){
      return false;
    }
    bool used[board.size()][board[0].size()]
    for(int i=0;i<board.size();i++)
    {
      for(int j=0;j<board[i].size();j++)
      {
        used[i][j]=false;
      }
    }
    for(int i=0;i<board.length;i++)
    {
        for(int j=0;j<board[0].length;j++)
        {
            if(search(board,word,0,i,j,used))
                return true;
        }
    }
    return false;
  }

  bool search(vector<vector<char>>& board,string word,int index,int i,int j,bool used[][])
  {
    if(index==word.length())
    {
      return true;
    }
    if(i<0 || j<0 || i>=board.length || j>=board[0].length || used[i][j] || board[i][j]!=word.at(index)){
      return false;
    }
    used[i][j]=true;
    bool res = search(board,word,index+1,i-1,j,used)
                || search(board,word,index+1,i+1,j,used)
                || search(board,word,index+1,i,j-1,used)
                || search(board,word,index+1,i,j+1,used);
    used[i][j] = false;
    return res;
  }
};
