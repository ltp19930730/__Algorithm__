/*114. Flatten Binary Tree to Linked List
Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
                    */
/*First solution: preorder traverse the whole tree and store the result in an
 vector ,the time complexity would be O(logN) but the extra space using is O(N)
 indicate that the whole complexity is O(N)
 */
 class Solution {
public:
    void flatten(TreeNode* root) {

     if(!root)return;
     vector<TreeNode*>output;
     inorderTraversal(output,root);

     int i;
     for(i=0;i<output.size()-1;i++)
     {
         output[i]->left=nullptr;
         output[i]->right=output[i+1];
     }
     output[i]->right=nullptr;
     output[i]->left=nullptr;
    }
   void inorderTraversal(vector<TreeNode*>&output,TreeNode *root)
   {
     if(!root)return;
     output.push_back(root);
       inorderTraversal(output,root->left);
       inorderTraversal(output,root->right);

   }

};

//solution 2: the right child should be linked to the most right node of the
//left child

class Solutiion{
public:
  void flatten(TreeNode* root)
  {
    if(!root)return;
    while(root)
    {
      if(root->left)
      {
        TreeNode* pre=root->left;
        while(pre->right)
        {
          pre=pre->right;
        }
        pre->right=root->right;
        root->right=root->left;
        root->left=nullptr;
      }
      root=root->right;
    }
  }

};
