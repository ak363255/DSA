package dsa.binary_tree;
import dsa.binary_tree.BTree.TreeNode;

public class HeightOfBinaryTree {

    public int maxDepth(TreeNode root) {
        if(root == null)return 0;
        return Math.max(maxDepth(root.left)+1,maxDepth(root.right)+1);
    }
}
