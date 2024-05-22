import java.util.*;

class Solution {
    boolean solution(String s) {

        int cnt = s.length();
        Stack<Character> stack = new Stack<>();
        for(int i =0; i<cnt; i++) {
            char c = s.charAt(i);
            if(c == ')') {
                if(stack.isEmpty()) {
                    return false;
                }
                if(stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            } else {
                stack.push(c);
            }
        }
        if(!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}