package dsa.binary_tree;
import dsa.binary_tree.BTree.TreeNode;

import java.util.*;

public class ZigZagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if(root != null)queue.add(root);
        int order = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> temp = new ArrayList<>(size);
            for(int i = 0;i<size;i++){
                TreeNode node = queue.poll();
                if(order == 0){
                    temp.add(node.val);
                }else{
                    temp.add(0,node.val);
                }
                if(node.left != null)queue.add(node.left);
                if(node.right != null)queue.add(node.right);
            }
            ans.add(temp);
            order = 1^order;
        }
        return ans;
    }
}
