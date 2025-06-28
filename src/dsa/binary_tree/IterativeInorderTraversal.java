package dsa.binary_tree;
import dsa.binary_tree.BTree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        // left root right
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stackNode = new Stack<>();
        TreeNode node = root;
        while(true){
              if(node == null){
                  if(stackNode.isEmpty()){
                      break;
                  }else{
                      TreeNode temp = stackNode.pop();
                      ans.add(temp.val);
                      node = temp.right;
                  }
              }else{
                  stackNode.add(node);
                  node = node.left;
              }
        }
        return ans;

    }
}
