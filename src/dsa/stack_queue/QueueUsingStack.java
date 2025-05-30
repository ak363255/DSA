package dsa.stack_queue;

import java.util.Stack;

public class QueueUsingStack {
    class MyQueue {

        Stack<Integer> stack ,helper;
        public MyQueue() {
           stack = new Stack<>();
           helper = new Stack<>();
        }

        public void push(int x) {
           while(!stack.isEmpty()){
               helper.add(stack.pop());
           }
           stack.add(x);
           while(!helper.isEmpty()){
               stack.add(helper.pop());
           }
        }

        public int pop() {
           if(stack.isEmpty())return -1;
           return stack.pop();
        }

        public int peek() {
           if(!stack.isEmpty())return stack.peek();
           return -1;
        }

        public boolean empty() {
           return stack.isEmpty();
        }
    }
}
