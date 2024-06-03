import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        
        int left = 0;
        int right = people.length-1;
        while(left <= right) {
            int limitCheck = people[right] + people[left];
            if(left == right) {
                limitCheck -= people[left];
            } else {
                if(limitCheck > limit) {
                    limitCheck -= people[left];
                } else {
                    left++;
                }
            }
            right--;
            answer++;
        }
        return answer;
    }
}