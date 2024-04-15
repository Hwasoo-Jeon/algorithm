import java.io.*;

public class Main {
    
	private static int cnt = 0;
	private static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int num = Integer.parseInt(br.readLine());
		moving(1,2,3, num);
		bw.write(String.valueOf(cnt+"\n"));
		bw.write(sb.toString());
		bw.flush();
	}
	
	//1,2,3
	private static void moving(int from, int mid, int to, int num) {
		cnt++;
		if(num == 1) {
			sb.append(from + " " + to + "\n");
			return;	
		}
		
		moving(from,to,mid,num-1);
		sb.append(from+" "+to+"\n");
		moving(mid,from,to,num-1);
	}
}
