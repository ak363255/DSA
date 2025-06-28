package dsa.binary_tree;

import java.util.*;
import java.util.stream.Collector;

import dsa.binary_tree.BTree.TreeNode;
import dsa.binary_tree.BTree.TreeNodeWithCoordinate;

public class VerticalOrderTraversal {
    public static TreeMap<Integer,TreeMap<Integer, PriorityQueue<Integer>>> nodeMap;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        nodeMap = new TreeMap<>();
         List<List<Integer>> ans = new ArrayList<>();
         if(root == null)return  ans;
         TreeNodeWithCoordinate node = new TreeNodeWithCoordinate(0,0,root);
         preOrderTraversal(node);
         for(Map.Entry<Integer,TreeMap<Integer,PriorityQueue<Integer>>> entry : nodeMap.entrySet()){
             List<Integer> temp = new ArrayList<>();
             for(Map.Entry<Integer,PriorityQueue<Integer>> level:entry.getValue().entrySet()){
                 while(!level.getValue().isEmpty()){
                     temp.add(level.getValue().poll());
                 }
             }
              ans.add(temp);
         }
         return ans;
    }
    public static void preOrderTraversal(TreeNodeWithCoordinate root){
        if(root == null)return;
        int x = root.x;
        int y = root.y;
        if(nodeMap.containsKey(x)){
            TreeMap<Integer,PriorityQueue<Integer>> treeMap = nodeMap.get(root.x);
            if(treeMap.containsKey(root.y)){
                PriorityQueue<Integer> pq = treeMap.get(root.y);
                pq.add(root.node.val);
            }else{
                PriorityQueue<Integer> pq = new PriorityQueue<>();
                pq.add(root.node.val);
                treeMap.put(root.y,pq);
            }
        }else{
            TreeMap<Integer,PriorityQueue<Integer>> treeMap = new TreeMap<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            pq.add(root.node.val);
            treeMap.put(root.y,pq);
            nodeMap.put(root.x,treeMap);
        }
        if(root.node.left != null)preOrderTraversal(new TreeNodeWithCoordinate(root.x -1,root.y+1,root.node.left));
        if(root.node.right != null)preOrderTraversal(new TreeNodeWithCoordinate(root.x +1,root.y+1,root.node.right));
    }
}
