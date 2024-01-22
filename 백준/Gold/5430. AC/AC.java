import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer numToken;
		int tc = Integer.parseInt(br.readLine());

		for (int i = 0; i < tc; i++) {
			String method = br.readLine();
			// 정수 없는것 확인하려고
			int numCount = Integer.parseInt(br.readLine());
			
			// 스트링을 int리스트로 변환
			List<Integer> numList = new ArrayList<Integer>(); //remove 메소드에 대해 시간복잡도 O1, ArrayList는 On이다.
			if (numCount != 0) {
				numToken = new StringTokenizer(br.readLine(), "[],"); //delimeter에 이렇게 넣으면 한번에 구분됨.
				while(numToken.hasMoreTokens()) {
					numList.add(Integer.parseInt(numToken.nextToken()));
				}
			} else {
				br.readLine();
				numList = new ArrayList<Integer>();
			}
			
			// 함수 로직과 포인터 사용(remove함수 대체)
			int stPointer = 0;
			int endPointer = numList.size();
			boolean errorFlag = false;
			boolean reverseFlag = false;
			Loop:
			for(char token : method.toCharArray()) {
				if(token== 'R') {
					reverseFlag = !reverseFlag; //bool반전
				} else if(token== 'D') {
					if(stPointer==endPointer) { //numList.size()가 0인경우
						errorFlag = true;
						break Loop;
					}
					if(reverseFlag) {
						endPointer--;
					} else {
						stPointer++;
					}
				}
			}
			
			StringBuilder sb = new StringBuilder(); 
			if(errorFlag) {
				sb.append("error");
			} else {
				sb.append("[");
				if (stPointer!=endPointer) {
					if(reverseFlag == true) {
						for(int j=endPointer-1;j>=stPointer;j--) {
							sb.append(numList.get(j));
				            if(j!=stPointer){
				                sb.append(",");
				            }
						}
					} else {
						for(int j=stPointer;j<endPointer;j++) {
							sb.append(numList.get(j));
				            if(j!=endPointer-1){
				                sb.append(",");
				            }
						}
					}
				}
				sb.append("]");
			}
			bw.write(sb.toString()+"\n");
			bw.flush();
		}
		br.close();
		bw.close();
	}
}
