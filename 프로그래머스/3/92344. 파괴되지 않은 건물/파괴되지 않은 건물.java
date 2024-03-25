class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int tc = skill.length;
        int[][] accum = new int[board.length+1][board[0].length+1];
        
        for(int i = 0; i<tc; i++) { // 250000
            int type = skill[i][0];
            int degree = skill[i][5];
            int r1 = skill[i][1];
            int c1 = skill[i][2];
            int r2 = skill[i][3];
            int c2 = skill[i][4];
            if(type == 1) { //공격
                accum[r1][c1] -= degree;
                accum[r1][c2+1] += degree;
                accum[r2+1][c1] += degree;
                accum[r2+1][c2+1] -= degree;
            } else { //회복
                accum[r1][c1] += degree;
                accum[r1][c2+1] -= degree;
                accum[r2+1][c1] -= degree;
                accum[r2+1][c2+1] += degree;
            }
        }
        
        //왼 -> 오
        for(int row=0; row<accum.length; row++) {
            for(int col = 1; col< accum[0].length; col++) {
                accum[row][col] += accum[row][col-1];
            }
        }
        
        //위 -> 아래
        for(int col = 0; col< accum[0].length; col++) {
            for(int row=1; row<accum.length; row++) {
                accum[row][col] += accum[row-1][col];
            }
        }
        
        
        //1000 * 1000
        for(int row=0; row<board.length; row++) {
            for(int col = 0; col< board[0].length; col++) {
                if(board[row][col] + accum[row][col] > 0) {
                    answer++;
                }
            }
        }
        return answer;
    }
}