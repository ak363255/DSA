package dsa.binary_tree;
import dsa.binary_tree.BTree.TreeNode;

public class MaximumPathSum {

    public static int maxSum;
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        findMaxPathSum(root);
        return maxSum;
    }
    public static int findMaxPathSum(TreeNode root){
        if(root == null)return 0;
        int leftPathSum = findMaxPathSum(root.left)+root.val;
        int rightPathSum = findMaxPathSum(root.right)+root.val;
        maxSum = Math.max(Math.max(Math.max(Math.max(maxSum,leftPathSum + rightPathSum - root.val),leftPathSum),rightPathSum), root.val);
        return Math.max(Math.max(leftPathSum,rightPathSum),root.val);
    }
}
