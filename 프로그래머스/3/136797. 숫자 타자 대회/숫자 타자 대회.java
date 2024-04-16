import java.util.*;

class Solution {
    private static int len;
	private static int[][][] dp;
	private static int[][] cost = new int[10][10];
    public int solution(String numbers) {
        initCost(); //숫자에 따른 가중치 배열 생성
		len = numbers.length();
        dp = new int[len][10][10];
        
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < 10; j++)
                Arrays.fill(dp[i][j], -1); //각 위치
        }
        
        return solve(0,4,6,numbers);
    }
    
    private static int solve(int idx, int left, int right, String numbers){
        if(idx==len){
            return 0; //문자열 끝까지 탐색한 경우
        }
        
        //이미 계산된 경우
        if(dp[idx][left][right]!=-1) return dp[idx][left][right];
        
        int num = numbers.charAt(idx) - '0';
        int ans = Integer.MAX_VALUE;
        
        //왼쪽 손가락을 움직이는 경우
        if(num!=right){ //오른손이 num과 같으면 아래 조건에 의하여 1 가중치 전달
            ans = Math.min(solve(idx+1, num, right,numbers)+cost[left][num], ans);   
        }
        
        //오른쪽 손가락을 움직이는 경우
        if(num!=left){ //왼손이 num과 같으면 위 조건에 의하여 1 가중치 전달
            ans = Math.min(solve(idx+1, left, num,numbers)+cost[right][num], ans);
            //상위 호출된 해당 위치에서의 좌우 이동에 따른 가중치 값을 return해서 dp에 저장.
        }
        
        return dp[idx][left][right] = ans;
    }
	
	private static void initCost() {
    
        int r1, c1, r2, c2;
        
        //cost 1차는 현재 숫자 cost 2차는 갈 숫자, 값은 가중치
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j<10; j++) {
                if(i==j){
                    cost[i][j] = 1;
                    continue;
                }
                
                if(i==0) {
                    r1 = 3;
                    c1 = 1;
                }
                else{
                    r1 = (i-1)/3;
                    c1 = (i-1)%3;
                }
                if(j==0) {
                    r2 = 3;
                    c2 = 1;
                }
                else{
                    r2 = (j-1)/3;
                    c2 = (j-1)%3;
                }
                
                int dr = Math.abs(r1-r2);
                int dc = Math.abs(c1-c2);
                int min = Math.min(dr, dc);
                int max = Math.max(dr, dc);
                int diff = dr+dc;
                
                if(diff==1){ //인접 숫자로 직선 이동
                    cost[i][j] = 2;
                }
                else if(diff>1){ //인접하지 않은 숫자 => 대각 + 직선 이동
                    cost[i][j] = min*3 + (max-min)*2;
                }
            }
        }
    }
}

/* 가까운 순서로 접근하는 좌&우 우선순위 차이를 둔 틀린코드. 원하는대로 동작안함. 재귀를 써서 비교를 했어야함
private static int[][][] dp;

	public static int solution(String numbers) {
        int n = numbers.length(); 
		dp = new int[n][4][5];

        int inY = 0;
        int inX = 0;
        
		for(int i=0; i<n; i++) {
			int tar = Integer.parseInt(numbers.substring(i, i+1));
	        inY = (tar-1)/3; //0~3
	        inX = (tar-1)%3; //0~2
	        if(tar==0) {
                inY = 3;
                inX = 1;
            }
	        
	        if(i!=0) {
	        	dp[i][0] = tapping(i, 0,inY, inX);
				dp[i][1] = tapping(i, 1,inY, inX);
				dp[i][2] = tapping(i, 2,inY, inX);
				dp[i][3] = tapping(i, 3,inY, inX);
	        } else {
	        	int[] result1 = tapping(0, 0,inY,inX);
	    		int[] result2 = tapping(0, 1,inY,inX);
	            dp[0][0] = result1;
	    		dp[0][2] = result1;
	    		dp[0][1] = result2;
	    		dp[0][3] = result2;
	        }
		}
		int num1 = Math.min(dp[n-1][0][0], dp[n-1][1][0]);
		int num2 = Math.min(dp[n-1][2][0], dp[n-1][3][0]);
		
		return Math.min(num1, num2);
    }
    
	//depth => i, dir => 0:좌-좌 1:좌-우 2:우-좌 3:우-좌, inY inX => target 위치
	//dp i는 depth, 2차는 방향, 3차는 값& 좌 우 xy위치
    public static int[] tapping(int depth, int dir, int inY, int inX) {
        int[] result = new int[5];
        int straight = 0;
        int diagonal = 0;
        int y = 0;
    	int x = 0;
    	if(depth != 0) {
        	switch (dir) {
			case 0://좌->좌
				y = dp[depth-1][0][1];
				x = dp[depth-1][0][2];
				break;
			case 1://좌->우
				y = dp[depth-1][1][3];
				x = dp[depth-1][1][4];		
				break;
			case 2://우->좌
				y = dp[depth-1][2][1];
				x = dp[depth-1][2][2];
				break;
			case 3://우->우
				y = dp[depth-1][3][3];
				x = dp[depth-1][3][4];
				break;	
        	}
        	
        	straight = (Math.abs(inY-y)+Math.abs(inX-x))*2;
        	diagonal = diagonal(y,x,inY,inX);
        	if(y==inY && x==inX) {
        		result[0] = dp[depth-1][dir][0] +1;
        	} else {
        		result[0] = Math.min(diagonal, straight)+dp[depth-1][dir][0];
        	}
        	
        	if(dir == 0 || dir == 2) { //좌 포인터 이동
        		result[1] = inY;
        		result[2] = inX;
        		result[3] = dp[depth-1][dir][3];
        		result[4] = dp[depth-1][dir][4];
        	} else if(dir == 1 || dir == 3) { //우 포인터 이동
        		result[1] = dp[depth-1][dir][1];
        		result[2] = dp[depth-1][dir][2];
        		result[3] = inY;
        		result[4] = inX;
        	}
        	return result; 
        } else {
        	
        	if(dir == 0) { //좌이동
        		y = 1;
        		x = 0;
        		result[1] = inY;
        		result[2] = inX;
        		result[3] = 1;
        		result[4] = 2;
        	} else {
        		y = 1;
        		x = 2;
        		result[1] = 1;
        		result[2] = 0;
        		result[3] = inY; //우이동
        		result[4] = inX;
        	}
        	straight = (Math.abs(inY-y)+Math.abs(inX-x))*2;
        	diagonal = diagonal(y,x,inY,inX);
        	if(y==inY && x==inX) {
        		result[0] = 1;
        	} else {
        		result[0] = Math.min(diagonal, straight);
        	}
        	
        	return result;
        }
    }

    public static int diagonal(int y, int x, int inY, int inX) {
        int answer = 0;
        int res = 0;
        if(inY > inX) {
            res = inY-inX;
            answer = (Math.abs(inX-x)*3) + (res*2);
            
        } else if(inY < inX) {
            res = inX-inY;
            answer = (Math.abs(inY-y)*3) + (res*2);
        } else {
            if(y>=x) {
                res = y-x;
                answer = Math.abs(inX-x)*3 + res*2;
            } else {
                res = x-y;
                answer =  Math.abs(inY-y)*3 + res*2;
            }
        }
        
        return answer; 
    }
*/
    