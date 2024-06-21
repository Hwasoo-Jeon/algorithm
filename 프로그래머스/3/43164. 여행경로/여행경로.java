import java.util.*;

/*
풀이 아이디어
소팅하고,
이대로 직진
대신 맵에 넣어
*/
class Solution {
    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets, (a,b) -> {
            if(a[0].equals(b[0])) {
                return a[1].compareTo(b[1]);
            } else {
                return a[0].compareTo(b[0]);
            }
        });
        // HashMap<String, ArrayList<String>> map = new HashMap<>();
        // for(int i=0; i<tickets.length; i++) {
        //     String[] cur = tickets[i];
        //     if(!map.containsKey(cur[0])) {
        //         map.put(cur[0], new ArrayList<String>()); 
        //     }
        //     map.get(cur[0]).add(cur[1]);
        // }
        
        // int cnt = tickets.length;
        // String start = "ICN";
        // ArrayList<String> result = new ArrayList<>();
        // while(cnt > 0) {
        //     String next = map.get(start).remove(0);
        //     result.add(start);
        //     if(cnt == 1) {
        //         result.add(next); 
        //     }
        //     cnt--;
        //     start = next;
        // }
        
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (String[] ticket : tickets) {
            if (!map.containsKey(ticket[0])) {
                map.put(ticket[0], new PriorityQueue<>());
            }
            map.get(ticket[0]).offer(ticket[1]);
        }
        
        List<String> result = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        stack.push("ICN");

        while (!stack.isEmpty()) {
            String from = stack.peek();
            if (!map.containsKey(from) || map.get(from).isEmpty()) {
                result.add(0, from);
                stack.pop();
            } else {
                stack.push(map.get(from).poll());
            }
        }
        
        String[] answer = result.toArray(new String[result.size()]);
        return answer;
    }
}