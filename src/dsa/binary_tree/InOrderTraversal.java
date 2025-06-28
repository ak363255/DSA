package dsa.binary_tree;
import com.sun.source.tree.Tree;
import dsa.binary_tree.BTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class InOrderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        //Left Root Right
        List<Integer> ans = new ArrayList<>();
        inOrder(root,ans);
        return ans;
    }

    public static void inOrder(TreeNode root,List<Integer> ans){
        if(root == null)return;
        inOrder(root.left,ans);
        ans.add(root.val);
        inOrder(root.right,ans);
    }
}

