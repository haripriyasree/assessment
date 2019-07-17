package com.talfinder.assessment;

import java.util.EmptyStackException;
import java.util.Stack;

public class RedundantBracesCheck {
    public static boolean containsRedundantBraces(String exp) throws EmptyStackException {
        Stack<Character> st = new Stack<Character>();
        boolean flag=true;
        // char[] str = exp.toCharArray();

        char[] ch=exp.toCharArray();
        for (int i=0;i<exp.length();i++) {

            if (exp.charAt(i) == '}'||exp.charAt(i)==')'||exp.charAt(i)==']') {

                st.pop();


                if (st.peek() == '{'||st.peek()=='('||st.peek()=='[')
                    flag= true;
                else {
                    if (st.peek() != '{'|| st.peek()!='('||st.peek()!='[') {

                        if (st.peek() == '+' || st.peek() == '-'
                                || st.peek() == '*' || st.peek() == '/') {
                            flag = false;
                        }


                        st.pop();
                    }
                }
                if (flag == true) {
                    return true;
                }
            } else {
                st.push(exp.charAt(i));
            }                
        }
        return false;

    }
    public static void main(String args[])
    {
        String exp="[[a+b]]";
        System.out.println(RedundantBracesCheck.containsRedundantBraces(exp));
    }
}
