import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        int[] students = new int[n+1];
        Arrays.fill(students, 1);
        
        for(int i=0; i<lost.length; i++) {
            int l = lost[i];
            students[l]--;
        }
        for(int i=0; i<reserve.length; i++) {
            int r = reserve[i];
            students[r]++;
        }
        
        for(int i=1; i<n; i++) {
            int pre = students[i-1];
            int cur = students[i];
            int next = students[i+1];
            if(cur > 1) {
                if(pre < 1) {
                    students[i-1]++;
                    students[i]--;
                    continue;
                } else if(next < 1) {
                    students[i+1]++;
                    students[i]--;
                    continue;
                }
            }
        }
        if(students[n] > 1 && students[n-1] < 1) {
            students[n]--;
            students[n-1]++;
        }
        
        int answer = 0;
        for(int i=1; i<=n; i++) {
            if(students[i] > 0) {
                answer++;    
            }
        }
        return answer;
    }
}