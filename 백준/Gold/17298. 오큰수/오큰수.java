import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

/*
기존 방식은 가까운 값을 저장하지 못함.
4321234 예시면,
3번째 2일 경우, 오큰수로 3이 아닌 4를 저장함
 */
public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine()); 
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		//input 저장
		int[] input = new int[tc];
        for(int i=0; i<tc; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        
        //index 저장용
		Stack<Integer> idx = new Stack<>();
		int[] output = new int[tc];
		
		//nge 연산
		for(int i = 0; i <tc; i++) {
			while(!idx.isEmpty()&&input[idx.peek()]<input[i]) {
				output[idx.pop()] = input[i];
			}
			idx.push(i);
		}
		
		//nge 연산 안된 idx에 -1 삽입
		for(int i : idx) {
			output[i] = -1;
		}
		
		/*
		while(!idx.isEmpty()) {
			output[idx.pop()] = -1;
		} 위와 동일
		*/
		
		// 결과출력
		for(int i=0; i < output.length; i++) {
			if(i==output.length-1) {
				sb.append(output[i]);
			} else {
				sb.append(output[i]).append(" ");
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
	}
	
}