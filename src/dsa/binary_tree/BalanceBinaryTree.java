package dsa.binary_tree;
import dsa.binary_tree.BTree.TreeNode;

public class BalanceBinaryTree {

    public static boolean isBalancedBt = true;
    public boolean isBalanced(TreeNode root) {
        isBalancedBt = true;
        findHeight(root);
        return isBalancedBt;
    }
    public static int findHeight(TreeNode root){
        if(root == null)return 0;
        int left = findHeight(root.left)+1;
        int right = findHeight(root.right)+1;
        if(Math.abs(right - left) > 1)isBalancedBt = false;
        return Math.max(left,right);
    }
}
