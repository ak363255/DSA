package dsa.binary_tree;
import dsa.binary_tree.BTree.TreeNode;

public class DiameterOfBinaryTree {

    public static int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
         diameter = 0;
         if(root == null)return diameter;
         getHeight(root);
         return diameter -1;

    }
    public static int getHeight(TreeNode root){
        if(root == null)return 0;
        int left = getHeight(root.left)+1;
        int right = getHeight(root.right)+1;
        diameter = Math.max(diameter,left+right-1);
        return Math.max(left,right);
    }
}
