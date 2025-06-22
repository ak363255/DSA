package dsa.stack_queue;

import java.util.HashMap;
import java.util.Stack;

public class StackUsingLinkedList {

    class MyStack {
         class StackNode {
             int data;
             StackNode next;
             StackNode(int a) {
                 data = a;
                 next = null;
             }
         }
        StackNode top;
         HashMap<StackNode,StackNode> nodeMap = new HashMap<>();

        // Function to push an integer into the stack.
        void push(int a) {
            // Add your code here
            if(top == null){
                top = new StackNode(a);
                nodeMap.put(null,top);
            }else{
                StackNode t = new StackNode(a);
                nodeMap.put(t,top);
                top = t;
                top.next = t;
            }
        }

        // Function to remove an item from top of the stack.
        int pop() {
            // Add your code here
            if(top== null)return -1;
            int val = top.data;
            StackNode newHead = nodeMap.get(top);
            if(newHead != null)newHead.next = null;
            top = newHead;
            return val;
        }
    }
}
