package binarytree.hard;

import java.util.ArrayList;
import java.util.List;

/**
* @author Tianpei Luo 
* @email teslaluo@gmail.com
* @date Dec 30, 2016 12:33:29 PM
* 
*/

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int val) {
		this.val = val;
	}
}

public class Codec {

    public String serialize(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root,result);
        return result.toString();
    }
    private void helper(TreeNode root, List<Integer> result) {
        if (root == null){
            result.add(null);
            return;
        }
        result.add(root.val);
        helper(root.left,result);
        helper(root.right,result);
    }

    public TreeNode deserialize(String data) {
    	String[] node = data.substring(1, data.length()-1).split(", ");
    	int[] index = new int[]{0};
    	for(String n:node){
    		System.out.println(n);
    	}
    	TreeNode root = helper2(node,index);
    	return root; 
    }
    
    private TreeNode helper2(String[] node, int[] index){

    	if(index[0] >= node.length || node[index[0]].equals("null")){
    		return null;
    	}
    	TreeNode root = new TreeNode(Integer.valueOf(node[index[0]++]));
    	index[0] = index[0] + 1;
    	root.left = helper2(node, index);
    	index[0] = index[0] + 1;
    	root.right = helper2(node, index);
    	return root;
    }

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode a1 = new TreeNode(3);
		TreeNode a2 = new TreeNode(4);
		root.right = a1;
		Codec a = new Codec();
		System.out.println(a.serialize(root));
		a.deserialize(a.serialize(root));
	}

}
