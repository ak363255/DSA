package dsa.stack_queue;

import java.util.Objects;
import java.util.Stack;

class MinStack {

    Stack<Integer> main,helper;
    public MinStack() {
        main = new Stack<>();
        helper = new Stack<>();
    }

    public void push(int val) {
       main.push(val);
       if(helper.isEmpty())helper.push(val);
       else{
           if(helper.peek() >= val)helper.push(val);
       }
    }

    public void pop() {
         if(!main.isEmpty() && !helper.isEmpty() && Objects.equals(main.peek(), helper.peek()))helper.pop();
        if(!main.isEmpty())main.pop();
    }

    public int top() {
       if(main.isEmpty())return -1;
       return main.peek();
    }

    public int getMin() {
         if(helper.isEmpty())return -1;
         return helper.peek();
    }
}
