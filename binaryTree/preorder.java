


public class preorder{
      // version 0:Non-Recursion
      public List<Integer> preorderTraversal(TreeNode root){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> result = new ArrayList<>();

        if (root == null){
          return result;
        }
        stack.push(root);
        while (!stack.empty()){
          TreeNode node = stack.pop();
          result.add(root.val);
          // first right and then left because of the stack
          if (root.right != null){
            stack.push(right);
          }
          if (root.left != null){
            stack.push(left);
          }
        }
        return result;
      }
}

public class preorder{
      // version 1:Traverse
      public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> result = new ArrayList<>();

        if (root == null){
          return result;
        }
        traverse(root,result);
        return result;
      }

      private void traverse(TreeNode root, List<Integer> result){
        if (root == null){
          return;
        }
        result.add(root.val);
        traverse(root.left,result);
        traverse(root.right,result);
      }
}

public class preorder{
      // version 2:Divide & Conquer
      public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> result = new ArrayList<>();

        if (root == null){
          return result;
        }
        //Divide
        List<Integer> left = preorderTraversal(root.left);
        List<Integer> right = preorderTraversal(root.right);

        //conquer
        result.add(root.val);
        result.addAll(left);
        result.addAll(right);
        return result;
      }
}
