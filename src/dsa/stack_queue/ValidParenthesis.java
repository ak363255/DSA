package dsa.stack_queue;

import java.util.Stack;

public class ValidParenthesis {
    public boolean isValid(String s) {
       Stack<Character> stack = new Stack<>();
       char []c = s.toCharArray();
       boolean isValid = true;
       for(char ch:c){
           if(ch == ')'){
               if(stack.isEmpty() || stack.pop() != '(')return false;
           }
           else if(ch == '}'){
               if(stack.isEmpty() || stack.pop() != '{')return false;
           }
           else if(ch == ']'){
               if(stack.isEmpty() || stack.pop() != '[')return false;
           }
           else{
               stack.add(ch);
           }
       }
       return stack.isEmpty();
    }
}
