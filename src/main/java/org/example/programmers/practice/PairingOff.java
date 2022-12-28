package org.example.programmers.practice;

import java.util.Stack;

public class PairingOff {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long end = start;
        System.out.println("========== Stack 사용 ==========");
        start = System.currentTimeMillis();
        for (int i=0 ; i<100000 ; i++) {
            solution("baabaa");
            solution("cdcd");
        }
        end = System.currentTimeMillis() - start;
        System.out.println(end);

        System.out.println("========== StringBuffer 사용 ==========");
        start = System.currentTimeMillis();
        for (int i=0 ; i<100000 ; i++) {
            mySolution("baabaa");
            mySolution("cdcd");
        }
        end = System.currentTimeMillis() - start;
        System.out.println(end);

    }

    public static int solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else if (stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        if (stack.isEmpty())
            return 1;
        return 0;
    }

    public static int mySolution(String s) {
        StringBuffer sb = new StringBuffer();
        for (int i=0 ; i<s.length() ; i++) {
            sb.append(s.charAt(i));
            if (sb.length() < 2) {
                continue;
            }

            int length = sb.length();
            if (sb.charAt(length-1) == sb.charAt(length-2)) {
                sb.delete(length-2, length);
            }
        }

        if (sb.length() == 0) {
            return 1;
        }

        return 0;
    }
}
