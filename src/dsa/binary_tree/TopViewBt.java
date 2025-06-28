package dsa.binary_tree;

import java.util.*;

import dsa.binary_tree.BTree.NodeWithCoordinate;

import dsa.binary_tree.BTree.Node;
public class TopViewBt {

    public static TreeMap<Integer,Integer> topViewMap;
    static ArrayList<Integer> topView(Node root) {
        // code here
        topViewMap = new TreeMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null)return ans;
        NodeWithCoordinate node = new NodeWithCoordinate(0,0,root);
        levelOrderTraversal(node);
        for(Map.Entry<Integer,Integer> entry: topViewMap.entrySet()){
            ans.add(entry.getValue());
        }

        return ans;

    }
    public static void levelOrderTraversal(NodeWithCoordinate root){
        Queue<NodeWithCoordinate> queue = new ArrayDeque<>();
        if(root == null)return;
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0;i<size;i++){
                NodeWithCoordinate temp = queue.poll();
                if(!topViewMap.containsKey(temp.x)){
                    topViewMap.put(temp.x,temp.node.data);
                }
                if(temp.node.left != null)queue.add(new NodeWithCoordinate(temp.x-1,temp.y+1,temp.node.left));
                if(temp.node.right!= null)queue.add(new NodeWithCoordinate(temp.x+1,temp.y+1,temp.node.right));
            }
        }
    }

}
