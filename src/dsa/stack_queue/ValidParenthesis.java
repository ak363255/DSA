package dsa.stack_queue;

import java.util.Stack;

public class ValidParenthesis {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char []cArray = s.toCharArray();
        boolean isValid = true;
        for(int i = 0;i<cArray.length;i++){
            if(cArray[i]=='(' || cArray[i]=='{' || cArray[i]=='[' ){
               stack.add(cArray[i]);
            }else{
                if(cArray[i] == ')'){
                   if(stack.isEmpty() || stack.pop() != '('){
                       isValid = false;
                       break;
                   }
                }else if(cArray[i] == '}'){
                    if(stack.isEmpty() || stack.pop() != '{'){
                        isValid = false;
                        break;
                    }
                }else{
                    if(stack.isEmpty() || stack.pop() != '['){
                        isValid = false;
                        break;
                    }
                }
            }
        }
        return isValid;
    }
}
