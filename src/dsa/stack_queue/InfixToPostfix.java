package dsa.stack_queue;

import java.util.Stack;

public class InfixToPostfix {


    public static int precedence(char c){
        if(c=='^')return 4;
        else if(c=='*')return 3;
        else if(c=='/')return 2;
        else if(c=='+' || c=='-')return 1;
        return 0;
    }
    public static boolean isOperand(char ch){
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9');
    }
    public static String infixToPostfix(String s) {
        // code here
        char[] cArray = s.toCharArray();
        Stack<Character> operators = new Stack<>();
        StringBuilder operands = new StringBuilder();
        for (int i = 0; i < cArray.length; i++) {
            if (isOperand(cArray[i])) {
                operands.append(cArray[i]);
            } else {
                if (cArray[i] == ')') {
                    while (operators.peek() != '(') {
                        operands.append(operators.pop());
                    }
                    operators.pop();
                } else if (cArray[i] == '(') {
                    operators.add(cArray[i]);
                } else {
                    while (!operators.isEmpty() && precedence(cArray[i]) <= precedence(operators.peek())) {
                        operands.append(operators.pop());
                    }
                    operators.add(cArray[i]);
                }
            }
        }
        while(!operators.isEmpty()){
            operands.append(operators.pop());
        }
        return operands.toString();
    }
}
