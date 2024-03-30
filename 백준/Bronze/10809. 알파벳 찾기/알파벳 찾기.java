import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
		int[] arr = new int[26];
		Arrays.fill(arr, -1);
		for(int i = 0 ; i <str.length(); i++) {
			char ch = str.charAt(i);
			int num = (int)(ch - 97);
			if(arr[num]==-1) {
				arr[num] = i;
			}
		}
		
		for (int i=0; i < arr.length; i++) {
			bw.write(Integer.toString(arr[i]));
			if(i != arr.length -1) {
				bw.write(" ");
			}
		}
		bw.flush();
		
	}
}	