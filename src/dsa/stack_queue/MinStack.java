package dsa.stack_queue;

import java.util.Stack;

class MinStack {

    Stack<Integer> stack, helper;

    public MinStack() {
        stack = new Stack<>();
        helper = new Stack<>();
    }

    public void push(int val) {
        stack.add(val);
        if(helper.isEmpty()){
            helper.add(val);
        }else{
            if(helper.peek()>= val){
                helper.add(val);
            }
        }
    }

    public void pop() {
        if(!stack.isEmpty()){
            int val = stack.pop();
            if(val == helper.peek())helper.pop();
        }
    }

    public int top() {
       if(stack.isEmpty())return -1;
       return stack.peek();
    }

    public int getMin() {
       if(helper.isEmpty())return -1;
       return helper.peek();
    }
}
