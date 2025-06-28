package dsa.binary_tree;
import dsa.binary_tree.BTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PostOrderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        //Left Right Root
        List<Integer> ans = new ArrayList<>();
        postOrder(root,ans);
        return ans;
    }

    public static void postOrder(TreeNode root,List<Integer> ans){
        if(root == null)return;
        postOrder(root.left,ans);
        postOrder(root.right,ans);
        ans.add(root.val);
    }
}

