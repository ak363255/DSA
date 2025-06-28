package dsa.binary_tree;
import dsa.binary_tree.BTree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativePreOrderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
       //root left right
        Stack<TreeNode> stackNode = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        if(root != null)stackNode.add(root);
        while(!stackNode.isEmpty()){
            TreeNode node = stackNode.pop();
            ans.add(node.val);
            if(node.right != null)stackNode.add(node.right);
            if(node.left != null)stackNode.add(node.left);
        }
        return ans;
    }
}
