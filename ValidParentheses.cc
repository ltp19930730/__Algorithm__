/*Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.


*/

class Solution {
public:
    bool isValid(string s) {
        stack<char> c_t;
        for(char &c:s){
            if(c=='('||c=='{'||c=='[')
            {
                c_t.push(c);
            }else{
                if(c_t.empty())return false;
                if(c==')'&&c_t.top()!='(')return false;
                if(c=='}'&&c_t.top()!='{')return false;
                if(c==']'&&c_t.top()!='[')return false;

                c_t.pop();
            }
        }
        return c_t.empty();
    }
};
