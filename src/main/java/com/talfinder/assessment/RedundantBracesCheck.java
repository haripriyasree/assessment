package com.talfinder.assessment;

import java.util.EmptyStackException;
import java.util.Stack;

public class RedundantBracesCheck {
    public static boolean containsRedundantBraces(String exp) throws EmptyStackException {
        Stack<Character> st = new Stack<Character>();
        boolean flag=true;
        // char[] str = exp.toCharArray();
        // Iterate through the given expression
        char[] ch=exp.toCharArray();
        for (int i=0;i<exp.length();i++) {

            // if current character is close parenthesis ')'
            if (exp.charAt(i) == '}'||exp.charAt(i)==')'||exp.charAt(i)==']') {

                st.pop();

                // If immediate pop have open parenthesis '('
                // duplicate brackets found

                if (st.peek() == '{'||st.peek()=='('||st.peek()=='[')
                    flag= true;
                else {
                    if (st.peek() != '{'|| st.peek()!='('||st.peek()!='[') {

                        // Check for operators in expression
                        if (st.peek() == '+' || st.peek() == '-'
                                || st.peek() == '*' || st.peek() == '/') {
                            flag = false;
                        }

                        // Fetch top element of stack

                        st.pop();
                    }
                }
                // If operators not found
                if (flag == true) {
                    return true;
                }
            } else {
                st.push(exp.charAt(i)); // push open parenthesis '(',
            }                // operators and operands to stack
        }
        return false;

    }
    public static void main(String args[])
    {
        String exp="[[a+b]]";
        System.out.println(RedundantBracesCheck.containsRedundantBraces(exp));
    }
}
