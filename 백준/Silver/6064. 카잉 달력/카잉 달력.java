import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int tc = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		int m = 0;
		int n = 0;
		int x = 0;
		int y = 0;

		for (int i = 0; i < tc; i++) {
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			int l = m*n/gcd(m,n);
			bw.write(cal(m,n,x,y,l)+"\n");
		}
		bw.flush();
	}

	private static int gcd(int n, int m) {

		int temp;
		if (m < n) {
			temp = m;
			m = n;
			n = temp;
		}

		int r;
		while (m > 0) {
			r = n % m;
			n = m;
			m = r;
		}

		return n;
	}
	
	private static int cal(int m, int n, int x, int y, int l) {
		
		int a = x;
		int b = (x-1)%n+1;
		while(a<=l) {
			if(b == y) {
				return a;
			}
			a += m;
			b = (b+m-1)%n +1;
		}
		
		return -1;
	}

}
