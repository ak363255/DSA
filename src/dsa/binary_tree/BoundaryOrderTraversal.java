package dsa.binary_tree;

import java.util.ArrayList;
import java.util.Stack;

import dsa.binary_tree.BTree.Node;

public class BoundaryOrderTraversal {
    ArrayList<Integer> boundaryTraversal(Node node) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        if(node == null)return ans;
        ans.add(node.data);
        //left view except leaf
        Node temp = node.left;
        while(temp != null){
            if(temp.left == null && temp.right == null)break;
            ans.add(temp.data);
            if(temp.left != null)temp = temp.left;
            else temp = temp.right;
        }
        temp = node;
        Stack<Node> stackNode = new Stack<>();
        while(true){
            if(temp == null){
                if(stackNode.isEmpty())break;
                Node t = stackNode.pop();
                if(t.left == null && t.right == null){
                    ans.add(t.data);
                }
                temp = t.right;
            }else{
                stackNode.add(temp);
                temp = temp.left;
            }
        }
        //right view except leaf
        temp = node.right;
        stackNode = new Stack<>();
        while(temp != null){
            if(temp.left == null && temp.right == null)break;
            stackNode.add(temp);
            if(temp.right != null)temp = temp.right;
            else temp = temp.left;
        }
        while(!stackNode.isEmpty()){
            ans.add(stackNode.pop().data);
        }
        return ans;
    }
}
