/*clear c++ solutions for binary tree inorder traversal
 1.Iterative solution using stack --- o(n)time and o(n) space
 2.Recursive solution --o(n) time and o(n) space
 3.Morris traversal -- o(n) time and o(1) space

Iterative solution using stack:
*/
vector<int> inorderTraversal(TreeNode* root)
{
     vector<int> output;
     if(!root)return output;
    stack<TreeNode*> stack;
    stack.push(root);
    while(!stack.empty())
    {
      TreeNode* pNode=stack.top();
      if(pNode->left)
      {
        stack.push(pNode->left);
      }else{
        output.push_back(pNode->val);
        stack.pop();
        if(pNode->right)
        {
          stack.push(pNode->right);
        }
      }
    }
    return output;
}

//Recursive solution:
vector<int> inorderTraversal(TreeNode* root) {
    vector<int>Traversal;
    InorderTraversal(root,Traversal);
    return Traversal;
}
void InorderTraversal(TreeNode* root,vector<int>& Traversal)
{
    if(!root)return;
    InorderTraversal(root->left,Traversal);
    Traversal.push_back(root->val);
    InorderTraversal(root->right,Traversal);
}

//Morris solution
vector<int> inorderTraversal(TreeNode* root)
{
     vector<int> output;
     TreeNode *p=root,*temp;
     if(!root)return output;
     while(p){
         if(p->left==NULL)
         {
             output.push_back(p->val);
             p=p->right;
         }
         else{
             temp=p->left;
             while(temp->right!=NULL&& temp->right!=p)
             {temp=temp->right;}
             if(temp->right==NULL){
                 temp->right =p;
                 p = p->left;
             }
             else{
                 output.push_back(p->val);
                 temp->right=NULL;
                 p=p->right;
             }
         }
     }
    return output;
}
