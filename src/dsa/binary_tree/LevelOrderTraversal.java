package dsa.binary_tree;
import dsa.binary_tree.BTree.TreeNode;

import java.util.*;

public class LevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        Queue<TreeNode> temp = new ArrayDeque<>();
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ansTemp = new ArrayList<>();
        if(root != null)queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            ansTemp.add(node.val);
            if(node.left != null)temp.add(node.left);
            if(node.right != null)temp.add(node.right);
            if(queue.isEmpty()){
                queue = new ArrayDeque<>(temp);
                temp = new ArrayDeque<>();
                ans.add(new ArrayList<>(ansTemp));
                ansTemp = new ArrayList<>();
            }
        }
        return ans;
    }
}
