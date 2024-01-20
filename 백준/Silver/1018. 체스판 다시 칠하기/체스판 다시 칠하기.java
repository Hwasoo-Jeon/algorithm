import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr= br.readLine().split(" ");
		int m = Integer.parseInt(arr[0]);
		int n = Integer.parseInt(arr[1]);
		
		//흰,검 색칠한 보드판 생성
		List<String> wFirst = new ArrayList<>();
		for(int i = 0; i<m; i++) {
			for(int j = 0; j <n; j++) {
				if((i+j)%2==0) {
					wFirst.add("W");
				} else {
					wFirst.add("B");
				}
			}
		}
		
		//m*n 보드판 생성
		StringBuilder input = new StringBuilder();
		for(int i = 0; i<m; i++) {
			input.append(br.readLine());
		}
		
		//m*n 다시 칠해야할 갯수 체크 
		int[] wInt = new int[m*n];
		for(int i = 0; i<m*n; i++) {
			if(!wFirst.get(i).equals(Character.toString(input.charAt(i)))) {
				wInt[i] = 1;
			}
		}

		//8*8만들기
		int window = 8;
		
		List<Integer> answerlist = new ArrayList<Integer>();
		//체크보드 시작점 범위 조건 행(i), 열(j)
		//-window해서 횟수 설정
		//가운데 조건문이 등호가 있는 이유 => ex 8*8의 input 떠올리기.
		for(int i=0; i<= m-window; i++) {
			for(int j=0; j<= n-window; j++) {
				int num = 0;
				//행(i)과 열(j)조건의 시작점에서 한개씩 증가하여 최대 8개 선택
				for(int x = i; x<window+i; x++) {
					for(int y = j; y< window+j; y++) {
						int idx = (x)*n+(y); //n 곱한 이유? 다음 행으로 넘어갈때 열의 갯수만큼 넘어가야해서.
						num += wInt[idx]; 
					}
				}
				if(num > 32) {
					num = (64)-num;
				}
				answerlist.add(num);	
			}
		}
		Collections.sort(answerlist);
		System.out.println(answerlist.get(0));
	}
}