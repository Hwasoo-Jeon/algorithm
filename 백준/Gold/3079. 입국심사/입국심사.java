import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //100000
		int M = Integer.parseInt(st.nextToken()); //1000000000
		long[] arr = new long[N];
		for(int i=0; i<N; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		Arrays.sort(arr);
		
		long low = 0;
		long high = arr[0]*M;
		ArrayList<Long> resultList = new ArrayList<>();
		while(low <= high) {
			long cnt = 0;
			long mid = (low+high)/2;
			for(int i=0; i<N; i++) {
				cnt += mid/arr[i];
			}
			if(cnt >= M) {
				high = mid-1;
				resultList.add(mid);
			} else {
				low = mid+1;
			}
		}
		Collections.sort(resultList);
		System.out.println(resultList.get(0)+"");
	}
}
