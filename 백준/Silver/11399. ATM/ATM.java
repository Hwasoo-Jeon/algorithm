import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[tc];
		for(int i=0; i<tc; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int result = 0;
		int reArr[] = new int[tc];
		for(int i=0; i<tc; i++) {
			for(int j=0; j<=i;j++) {
				reArr[i] += arr[j];
			}
		}
		
		for(int i=0; i<tc; i++) {
			result += reArr[i];
		}
		System.out.println(result);
	}
}

/*
 * 
 *1 2 3 3 4 
 * 
 * 
 * 1 = 1 
 * 1 2 = 3 
 * 1 2 3  = 6
 * 1 2 3 3 = 9
 * 1 2 3 3 4 = 13
 * 
 * 
 * 
 * 
*/