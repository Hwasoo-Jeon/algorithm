import java.util.*;
class Solution {

    public String solution(String number, int k) {
        int len = number.length() - k;
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i<number.length(); i++) {
            char curDigit = number.charAt(i);
            while(!stack.isEmpty() && curDigit > stack.peek() && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(curDigit);
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().substring(0, len);
    }
}

/*
// 실패코드 2 : n^2 실패
public String solution(String number, int k) {
int digit = number.length() - k; //7 -3 = 4자릿수 원함
int startIdx = 0;
StringBuilder sb = new StringBuilder();
for (int i = digit; i > 0; i--) {
    int tmp = 0;
    for (int j = startIdx; j <= number.length() - i; j++) {
        int num = Character.getNumericValue(number.charAt(j));
        System.out.println(i +" : " + num);
        if (tmp < num) {
            tmp = num;
            startIdx = j + 1;
        }
    }
    System.out.println("==");
    sb.append(tmp);
}
return sb.toString();
}
====

// 실패코드 1 : 전체 탐색 O(n^length-k) 이상.?
private static int answer;
public String solution(String number, int k) {
    answer = Integer.MIN_VALUE;
    makeNum(0,0,number.length() - k, 0, number);
    return Integer.toString(answer);
}

private static void makeNum(int start, int depth, int K, int num, String number) {
    if(depth == K) {
        if(num != 0) {
            answer = Math.max(answer, num);    
        }
        return;
    }
    int temp = num;
    for(int i = start; i<number.length(); i++) {
        num = num*10 + Integer.parseInt(number.substring(i, i+1));
        makeNum(i+1, depth+1, K, num, number);
        num = temp;
    }
}
*/