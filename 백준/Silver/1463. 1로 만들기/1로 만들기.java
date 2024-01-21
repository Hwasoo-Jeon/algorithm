import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		
		long[] array = new long[n+1];
		if(n == 1) {
			System.out.println("0");
			return;
		} else if (n ==2 || n==3){
			System.out.println("1");
			return;
		}
		
		array[0] = 0;
		array[1] = 0;
		array[2] = 1;
		array[3] = 1;
		
		for(int i=4; i<=n; i++) {
			if(i%6==0) array[i] = Math.min(Math.min(array[i/3], array[i/2]), array[i-1]) + 1;
			else if(i%3==0) array[i] = Math.min(array[i/3], array[i-1])+1;
			else if(i%2==0) array[i] = Math.min(array[i/2], array[i-1])+1;
			else array[i] = array[i-1]+1;
		}
		bw.write(array[n]+"");
		bw.flush();
	}
}
