import java.util.*;
import java.io.*;

public class Main {
	private static int[][] map = new int[9][9];
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		
		
		int fy = -1;
		int fx = 0-1;
		
		for(int i=0; i<9; i++) {
			String st = br.readLine();
			for(int j=0; j<9; j++) {
				int n = Integer.parseInt(st.charAt(j)+"");
				map[i][j] = n;
				
				if(n ==0 && fy ==-1 && fx == -1) {
					fy = i;
					fx = j;
				}
			}
		}
		sudoku(fy, fx);
		
	}
	
	private static void sudoku(int y, int x) throws IOException {
		

		boolean[] visitY = new boolean[10];
		
		//행 탐색
		for(int i=0; i<9; i++) {
			if(i==x) continue;
			int n = map[y][i];
			if(n != 0) {
				visitY[n] = true;
			}
//			if(visitY[n]) {
//				return;
//			}
			
		}
		
		
		//열 탐색
		for(int i=0; i<9; i++) {
			if(i==y) continue;
			int n = map[i][x];
			if(n != 0) {
				visitY[n] = true;
			}
//			if(visitY[n]) {
//				return;
//			}
		}
		
		//사각형 탐색
		//y 0~2 ly 0 ry 2 / 3~5 3 5 / 6~8 6 8        x 0~2 lx 0 rx 2 
		int ly = (y/3)*3;
		int ry = ly+2;
		int lx = (x/3)*3;
		int rx = lx+2;
		for(int i=ly; i<=ry; i++) {
			for(int j=lx; j<=rx; j++) {
				if(i==y && j==x) continue;
				int n = map[i][j];
				if(n != 0) {
					visitY[n] = true;
				}
//				if(visitY[n]) {
//					return;
//				}
			}
		}
		
		//넣을 수 있는 값 돌기.
		for(int i=1; i<=9; i++) {
			if(!visitY[i]) {
                map[y][x] = i;
                if(check(y, x)) {
                    // 다음 0 위치 찾기
                    boolean filled = true;
                    for(int ny = 0; ny < 9 && filled; ny++) {
                        for(int nx = 0; nx < 9 && filled; nx++) {
                            if(map[ny][nx] == 0) {
                                filled = false;
                                sudoku(ny, nx);
                            }
                        }
                    }
                    // 모든 칸이 채워졌으면 결과 출력
                    if(filled) {
                        for(int ny = 0; ny<9; ny++) {
                            for(int nx=0; nx <9; nx++) {
                                bw.write(map[ny][nx]+"");
                            }
                            if(ny!=8) bw.write("\n");
                        }
                        bw.flush();
                        // 여기에서 프로그램 종료하거나, 추가적인 처리를 위해 return
                        System.exit(0);
                    }
                }
                // 실패한 경우 원상복구
                map[y][x] = 0;
            }
//			if(!visitY[i]) { //넣을 수 있다.
//				map[y][x] = i;
//				if(check(y,x)) {
//					for(int ny = 0; ny<9; ny++) {
//						for(int nx=0; nx <9; nx++) {
//							if(map[ny][nx] == 0) {
//								sudoku(ny, nx);
//							}
//						}
//					}
//				}
////				for(int ny = 0; ny<9; ny++) {
////					for(int nx=0; nx <9; nx++) {
////						if(map[ny][nx] == 0) {
////							sudoku(ny, nx);
////						}
////					}
////				}
//				map[y][x] = 0;
//				//visitY[i] = true;
//			}
		}
	}
	
	private static boolean check(int y, int x) {
		
		int num = map[y][x];
		
		//행탐색(가로축)
		for(int i=0; i<9; i++) {
			if(i==x) continue;
			int n = map[y][i];
			if(n == num) {
				return false;
			}
		}
		
		//열 탐색(세로축)
		for(int i=0; i<9; i++) {
			if(i==y) continue;
			int n = map[i][x];
			if(n == num) {
				return false;
			}
		}
		
		
		
		//사각형 탐색
		int ly = (y/3)*3;
		int ry = ly+2;
		int lx = (x/3)*3;
		int rx = lx+2;
		for(int i=ly; i<=ry; i++) {
			for(int j=lx; j<=rx; j++) {
				if(i==y && j==x) continue;
				int n = map[i][j];
				if(n == num) {
					return false;
				}
			}
		}
		
		return true;
	}

}
