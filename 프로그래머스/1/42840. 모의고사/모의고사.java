import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
       
        int[] p1 = {1, 2, 3, 4, 5};
        int[] p2 = { 2, 1, 2, 3, 2, 4, 2, 5};
        int[] p3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5,};
        
        int cnt1 = 0;
        int cnt2 = 0;
        int cnt3 = 0;
        for(int i=0; i<answers.length; i++) {
            int idx1 = i%p1.length; 
            int idx2 = i%p2.length; 
            int idx3 = i%p3.length; 
            
            if(answers[i] == p1[idx1]) cnt1++;
            if(answers[i] == p2[idx2]) cnt2++;
            if(answers[i] == p3[idx3]) cnt3++;
        }
        
        LinkedList<int[]> list = new LinkedList<>();
        list.add(new int[] {cnt1, 1});
        list.add(new int[] {cnt2, 2});
        list.add(new int[] {cnt3, 3});
        
        Collections.sort(list, new Comparator<int[]>() {
            
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0]) return o2[0] - o1[0];
                else return 0;
            }
            
        });
        int[] answer;
        if(list.get(0)[0] == list.get(2)[0]) {
            answer = new int[] {1, 2 ,3};
        } else if (list.get(0)[0] == list.get(1)[0]) {
            answer = new int[] {list.get(0)[1], list.get(1)[1]};
        } else {
            answer = new int[] {list.get(0)[1]};
        }
        Arrays.sort(answer);
        return answer;
    }
}
/*
0 1 2 3 4
i == 5
idx1 은 0이 나와야해.
6이면 idx 1이

*/