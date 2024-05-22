import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        Queue<Integer> proQ = new LinkedList<>();
        Queue<Integer> speQ = new LinkedList<>();
        for(int i=0; i<progresses.length; i++) {
            proQ.offer(progresses[i]);
            speQ.offer(speeds[i]);
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        while(!proQ.isEmpty()) {
            
            int pCur = proQ.poll();
            int sCur = speQ.poll();
            int days = (100-pCur)%sCur==0 ? (100-pCur)/sCur : (100-pCur)/sCur+1;
            //System.out.println(days);
            int size = proQ.size();
            int outputCnt = 1;
            boolean flag = true;
            for(int i =0; i<size; i++) {
                pCur = proQ.poll();
                sCur = speQ.poll();
                int plus = sCur*days;
                System.out.print(pCur);
                if((pCur += plus) >= 100) {
                    if(flag) {
                        outputCnt += 1;
                    } else {
                        proQ.offer(pCur);
                        speQ.offer(sCur);
                    }
                } else {
                    proQ.offer(pCur);
                    speQ.offer(sCur);
                    flag = false; 
                }
            }
            list.add(outputCnt);
        }
        
        int cnt = list.size();
        int[] answer = new int[cnt];
        for(int i=0; i<cnt; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}

/*
progresses 
speeds




*/