package dsa.binary_tree;
import dsa.binary_tree.BTree.Node;

public class ChildrenSumBinaryTree {

    public static boolean satisfied = true;
    public static int isSumProperty(Node root) {
        // add your code here
        satisfied = true;
        sumProperty(root);
        return satisfied ?1:0;
    }
    public static int sumProperty(Node root){
        if(root == null)return  0;
        int left = sumProperty(root.left);
        int right = sumProperty(root.right);
        if(!(root.left == null && root.right == null)){
            int sum = left + right;
            if(sum != root.data){
                satisfied = false;
            }
        }
        return left + right + root.data;
    }
}
