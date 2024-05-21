import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Arrays.sort(participant);
        Arrays.sort(completion);
        LinkedList<String> cList = new LinkedList<>();
        for(String s : completion) {
            cList.add(s);
        }
        
        for(int i=0; i<participant.length; i++) {
            String s = participant[i];
            if(cList.contains(s)) {
                cList.remove(s);
            } else {
                answer = s;
                break;
            }
        }
        
        return answer;
    }
}