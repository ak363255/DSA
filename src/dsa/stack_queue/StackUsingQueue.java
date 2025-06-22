package dsa.stack_queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class StackUsingQueue {
    class MyStack {

        Queue<Integer> queue, temp;
        public MyStack() {
             queue = new ArrayDeque<>();
             temp = new ArrayDeque<>();
        }

        public void push(int x) {
             if(queue.isEmpty())queue.add(x);
             else{
                 while(!queue.isEmpty()){
                     temp.add(queue.poll());
                 }
                 queue.add(x);
                 while (!temp.isEmpty()){
                     queue.add(temp.poll());
                 }
             }
        }

        public int pop() {
             if(queue.isEmpty())return -1;
             return queue.poll();
        }

        public int top() {
            if(queue.isEmpty())return -1;
            return queue.peek();
        }

        public boolean empty() {
             return queue.isEmpty();
        }
    }
}
