package dsa.recursion;

import dsa.string.SortCharFreq;

import java.util.ArrayList;
import java.util.List;


public class ExpressionAndOperators {

    public static List<String> addOperators(String num, int target) {

        /*
           a b c d
         */
        ArrayList<String> ans = new ArrayList<>();
        solveExpression(1,num.charAt(0)+"",num,target,ans,num.charAt(0)+"");
        return ans;
    }

    public static void solveExpression(int i, String s, String num, int target, List<String> ans, String leading) {
        if (i == num.length()) {
            if (eval(s,target)) {
                ans.add(s);
            }
            return;
        }
        //concatenate
        String prev = s;
        if (!leading.equals("0")) {
            solveExpression(i + 1, s + num.charAt(i), num, target, ans, leading);
            s = prev;
        }
        //add
        solveExpression(i + 1, s + "+" + num.charAt(i) + "", num, target, ans, num.charAt(i) + "");
        s = prev;
        //subtract
        solveExpression(i + 1, s + "-" + num.charAt(i) + "", num, target, ans, num.charAt(i) + "");
        s = prev;
        //multiply
        solveExpression(i + 1, s + "*" + num.charAt(i) + "", num, target, ans, num.charAt(i) + "");
        s = prev;
    }

    public static boolean eval(String s,int target) {
        ArrayList<Long> digits = new ArrayList<>();
        ArrayList<Character> operators = new ArrayList<>();
        String temp = "";
        for (char ch : s.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                temp += ch;
            } else {
                digits.add(Long.parseLong(temp));
                operators.add(ch);
                temp = "";
            }
        }
        digits.add(Long.parseLong(temp));
        long result = digits.get(0), prev = digits.get(0);
        char prevOperator = '.';
        for (int i = 0; i < operators.size(); i++) {
            if (operators.get(i) == '+') {
                prev = digits.get(i + 1);
                result += digits.get(i + 1);
                prevOperator = '+';
            } else if (operators.get(i) == '-') {
                prev = digits.get(i + 1);
                result -= digits.get(i + 1);
                prevOperator = '-';
            } else {
                if(prevOperator=='+'){
                    result -= prev;
                    result += prev*digits.get(i+1);
                    prev *= digits.get(i+1);

                }else if(prevOperator=='-'){
                    result += prev;
                    result -= prev*digits.get(i+1);
                    prev = -1*prev*digits.get(i+1);
                }else{
                    result -= prev;
                    result += prev*digits.get(i+1);
                    prev *= digits.get(i+1);
                }

                prevOperator = '*';
            }
        }
        return result==target;
    }
}
