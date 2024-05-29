import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        
        int sum = brown+yellow;
            
        for(int i=3; i<sum;i++) {
            if(sum % i == 0) {
                int row = i;
                int col = sum/i;
                if(((row+col)*2-4) == brown) {
                    if(row < col) {
                        int temp = col;
                        col = row;
                        row = temp;
                    }
                    return new int[] {row, col};
                }
            }
        }
        
        int[] answer = {};
        return answer;
    }
    
    
}