import java.util.*;
import java.io.*;

public class Main {
	
	static int[] arr;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int target = Integer.parseInt(br.readLine());
		int sumAll = 0;
		int start = 0;
		int end = -1;
		int answer = -1;
		for(int i =0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sumAll+= arr[i];
			end = Math.max(arr[i], end);
		}
		
		if(sumAll<= target) {
			System.out.println(end);
		} else {
			while(start <= end) {
				
				int mid = (start+end) /2;
				int total = 0;
				
				for(int i : arr) {
					total += Math.min(mid, i);
				}
				
				if(total <= target) {
					start = mid +1;
					answer = mid;
				} else if (total > target) {
					end = mid -1;
				}
			}
			System.out.println(answer);
		}
	}
}
