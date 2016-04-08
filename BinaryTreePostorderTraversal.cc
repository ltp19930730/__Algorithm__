/*Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [3,2,1].
*/

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
 //first solution: easy recursive way
class Solution {
public:
    vector<int> postorderTraversal(TreeNode* root) {
        vector<int>output;
        if(!root)return output;
        stack<int>out;
        inorderTraversal(root,out);
        while(!out.empty())
        {
            output.push_back(out.top());
            out.pop();
        }
        return output;
    }
    void inorderTraversal(TreeNode* root,stack<int>& out)
    {
        if(!root)return;
        out.push(root->val);
        inorderTraversal(root->right,out);
        inorderTraversal(root->left,out);

    }
};

void postorder(TreeNode* root, vector<int>& nodes) {
    if (!root) return;
    postorder(root -> left, nodes);
    postorder(root -> right, nodes);
    nodes.push_back(root -> val);
}
vector<int> postorderTraversal(TreeNode* root) {
    vector<int> nodes;
    postorder(root, nodes);
    return nodes;
}


vector<int> postorderTraversal(TreeNode* root) {
    vector<int> nodes;
    stack<TreeNode*> toVisit;
    TreeNode* curNode = root;
    TreeNode* lastNode = NULL;
    while (curNode || !toVisit.empty()) {
        if (curNode) {
            toVisit.push(curNode);
            curNode = curNode -> left;
        }
        else {
            TreeNode* topNode = toVisit.top();
            if (topNode -> right && lastNode != topNode -> right)
                curNode = topNode -> right;
            else {
                nodes.push_back(topNode -> val);
                lastNode = topNode;
                toVisit.pop();
            }
        }
    }
    return nodes;
}

void reverseNodes(TreeNode* start, TreeNode* end) {
    if (start == end) return;
    TreeNode* x = start;
    TreeNode* y = start -> right;
    TreeNode* z;
    while (x != end) {
        z = y -> right;
        y -> right = x;
        x = y;
        y = z;
    }
}
void reverseAddNodes(TreeNode* start, TreeNode* end, vector<int>& nodes) {
    reverseNodes(start, end);
    TreeNode* node = end;
    while (true) {
        nodes.push_back(node -> val);
        if (node == start) break;
        node = node -> right;
    }
    reverseNodes(end, start);
}
vector<int> postorderTraversal(TreeNode* root) {
    vector<int> nodes;
    TreeNode* dump = new TreeNode(0);
    dump -> left = root;
    TreeNode* curNode = dump;
    while (curNode) {
        if (curNode -> left) {
            TreeNode* predecessor = curNode -> left;
            while (predecessor -> right && predecessor -> right != curNode)
                predecessor = predecessor -> right;
            if (!(predecessor -> right)) {
                predecessor -> right = curNode;
                curNode = curNode -> left;
            }
            else {
                reverseAddNodes(curNode -> left, predecessor, nodes);
                predecessor -> right = NULL;
                curNode = curNode -> right;
            }
        }
        else curNode = curNode -> right;
    }
    return nodes;
}
