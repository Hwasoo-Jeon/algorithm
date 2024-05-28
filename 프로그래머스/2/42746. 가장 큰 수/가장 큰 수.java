import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        int cnt = numbers.length;
        String[] strs = new String[cnt];
        for(int i=0; i<cnt; i++) {
            strs[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(strs, (s1, s2) -> (s2+s1).compareTo(s1+s2));
        StringBuilder sb = new StringBuilder();
        for(String s : strs) {
            sb.append(s);
        }
        
        return String.valueOf(sb).substring(0,1).equals("0") ? "0" : String.valueOf(sb);
    }
}