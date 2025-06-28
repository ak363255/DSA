package dsa.binary_tree;
import dsa.binary_tree.BTree.TreeNode;

public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)return true;
        boolean isInvalid = p == null && q != null;
        isInvalid = isInvalid || (q==null && p != null);
        isInvalid = p.val != q.val;
        if(isInvalid)return false;
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}
