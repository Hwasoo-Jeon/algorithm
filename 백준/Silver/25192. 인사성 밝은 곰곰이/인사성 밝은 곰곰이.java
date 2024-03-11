import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Set<String> set = new HashSet<String>();
		int tc = Integer.parseInt(br.readLine());
		int result = 0;
		for(int i=0; i<tc; i++) {
			String st = br.readLine();
			if(st.equals("ENTER")) {
				result += set.size();
				set.clear();
			} else {
				set.add(st);
			}
		}
		result += set.size();
		bw.write(result+"");
		bw.flush();
	}
}
