import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr= br.readLine().split(" ");
		int rightX = Integer.parseInt(arr[0]);
		int topY = Integer.parseInt(arr[1]);
		
		int k = Integer.parseInt(br.readLine());
		int idx = 0;
		int leftX = 2;
		int bottomY =1;
		int curX =1;
		int curY =0;
		if(k>rightX*topY) {
			System.out.println("0");
			return;
		}
		Loop : while(idx<k) {
			//한 싸이클 만들기
			//위
			while(curY<topY) {
				if(idx>=k) {
					break Loop;
				}
				curY+=1;
				idx+=1;
			} topY-=1;
			
			//우
			while(curX<rightX) {
				if(idx>=k) {
					break Loop;
				}
				curX+=1;
				idx+=1;
			} rightX-=1;
			
			//아래
			while(curY>bottomY) {
				if(idx>=k) {
					break Loop;
				}
				curY-=1;
				idx+=1;
			} bottomY+=1;
			
			//좌
			while(curX>leftX) {
				if(idx>=k) {
					break Loop;
				}
				curX-=1;
				idx+=1;
			} leftX+=1;
		}
		System.out.println(curX+" "+curY);
	}
}
