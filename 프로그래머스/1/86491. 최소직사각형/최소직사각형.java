class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int longN = 0;
        int shortN = 0;
        int idx = 0;
        int cur_Big = 0;
        int cur_short = 0;
        for(int i=0; i<sizes.length; i++) {
            for(int j=0; j<2; j++) {
                if(longN < sizes[i][j]) {
                    longN = sizes[i][j];
                    if(j == 0) {
                        shortN = sizes[i][1];
                    } else {
                        shortN = sizes[i][0];
                    }
                    idx = i;
                }
            }    
        }
        
        for(int i=0; i<sizes.length; i++) {
            
            if(i == idx) {
                continue;
            }
            
            if(sizes[i][0] > sizes[i][1]) {
                cur_Big = sizes[i][0];
                cur_short = sizes[i][1];
            } else {
                cur_Big = sizes[i][1];
                cur_short = sizes[i][0];
            }
            
            if(cur_short > shortN) {
                shortN = cur_short;
            }
        }

        return longN*shortN;
    }
}