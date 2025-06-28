package dsa.binary_tree;


import java.util.ArrayList;
import java.util.List;
import dsa.binary_tree.BTree.TreeNode;

public class PreOrderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
           //Root left right
        List<Integer> ans = new ArrayList<>();
        preOrder(root,ans);
        return ans;
    }

    public static void preOrder(TreeNode root,List<Integer> ans){
        if(root == null)return;
        ans.add(root.val);
        preOrder(root.left,ans);
        preOrder(root.right,ans);
    }
}
