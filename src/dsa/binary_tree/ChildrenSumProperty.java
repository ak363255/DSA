package dsa.binary_tree;
import dsa.binary_tree.BTree.BinaryTreeNode;

public class ChildrenSumProperty {

    public static void changeTree(BinaryTreeNode<Integer> root){
        changeTree_(root);
    }
    public static int changeTree_(BinaryTreeNode < Integer > root) {
        // Write your code here.
        if(root == null)return 0;
        int left = 0,right = 0;
        if(root.left != null){
            left = root.left.data;
        }
        if(root.right != null){
            right = root.right.data;
        }
        if(left + right < root.data){
            if(root.left != null)root.left.data = root.data;
            if(root.right != null)root.right.data = root.data;
        }
        int leftValue = changeTree_(root.left);
        int rightValue = changeTree_(root.right);
        if(!(root.left == null && root.right == null)){
            root.data = leftValue + rightValue;
        }

        return root.data;
    }
}
