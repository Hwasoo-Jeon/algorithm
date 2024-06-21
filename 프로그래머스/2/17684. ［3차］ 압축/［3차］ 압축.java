import java.util.*;

class Solution {
    public int[] solution(String msg) {
        HashMap<String, Integer> map = new HashMap<>();
        int val = 1;
        for(int i=1; i<=26; i++) {
            char c = (char)('A' - 1 + val);
            map.put(Character.toString(c), val);
            val++;
        }
        // Queue<String> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<msg.length(); i++) {
            String cur = msg.substring(i,i+1);
            sb.append(cur);
            if(map.containsKey(sb.toString())) {
                continue;
            } else {
                map.put(sb.toString(),val);
                val++;
                int cnt = sb.length();
                list.add(map.get(sb.substring(0, cnt-1)));
                sb.delete(0, cnt-1);
            }
        }
        if(sb.length() > 0 && map.containsKey(sb.toString())) {
            list.add(map.get(sb.toString()));
        }
        int listSize = list.size();
        int[] answer = new int[listSize];
        for(int i=0; i<listSize; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}