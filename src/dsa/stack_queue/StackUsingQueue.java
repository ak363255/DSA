package dsa.stack_queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class StackUsingQueue {
    class MyStack {

        Queue<Integer> queue,helper;
        public MyStack() {
            queue = new ArrayDeque<>();
            helper = new ArrayDeque<>();
        }

        public void push(int x) {
           while(!queue.isEmpty()){
               helper.add(queue.poll());
           }
           queue.add(x);
           while(!helper.isEmpty()){
               queue.add(helper.poll());
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
