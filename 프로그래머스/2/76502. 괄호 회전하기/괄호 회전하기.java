import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int n = s.length();
        if (n == 1) {
            return 0;
        } else {
            Queue<Character> q = new LinkedList<>();
            for(int i=0; i<n; i++) {
                char c = s.charAt(i);
                q.offer(c);
            }

            for(int i=0; i<n; i++) {
                Queue<Character> qCopy = new LinkedList<>(q);
                answer += search(qCopy);
                q.offer(q.poll());
            }

            return answer;
        }
        
    }
    
    private static int search(Queue<Character> q) {
        Stack<Character> oper = new Stack<>();
        
        while(!q.isEmpty()) {
            char c = q.poll();
            
            if(c == '{' || c == '(' || c== '[') {
                oper.add(c);
            } else if(c == '}') {
                if(!oper.isEmpty() && oper.pop() == '{') {
                    continue;
                } else {
                    return 0;
                }
            } else if(c == ']') {
                if(!oper.isEmpty() && oper.pop() == '[') {
                    continue;
                } else {
                    return 0;
                }
            } else if(c == ')') {
                if(!oper.isEmpty() && oper.pop() == '(') {
                    continue;
                } else {
                    return 0;
                }
            }        
        }
        
        if(oper.isEmpty()) return 1;
        else return 0;
    }
}