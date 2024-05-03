class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int y = arr1.length;
        int x = arr2[0].length;
        int mid = arr1[0].length;
        int[][] answer = new int[y][x];
        for(int i=0; i<y; i++) {
     
            for(int j=0; j<x; j++) {
                for(int k=0; k<mid; k++) {
                   answer[i][j] +=  arr1[i][k] * arr2[k][j];    
                }
                
            } 
        
            
        }
        return answer;
    }
}

/*
3,2
2,2

1 4  3 3   => arr1ij * arr2ji + arr1ijj+1  * arr2ji 
3 2  3 3
4 1

00 = 00 * 00 + 01*10 (i=0, j=0, 0<=k<=1)
01 = 00 * 01 * 01 * 11

10 = 10 * 00 + 11 *10 

3+12, 3+12
9+6 


3,3
3,3
2 3 2  5 4 3
4 2 4  2 4 1
3 1 4  3 1 1

10+6+6, 8+12+2, 6+3+2


*/