import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int num = Integer.parseInt(br.readLine());
		long[] arr = new long[num+1];

	
		if(num == 1 || num ==2) {
			bw.write("1");
		} else{	
			arr[1] = 1;
			arr[2] = 1;
			for(int i = 3; i <= num; i++) {
				arr[i] = arr[i-1] + arr[i-2];
			}
			bw.write(Long.toString(arr[num]));
		}
		bw.flush();
	}
}

