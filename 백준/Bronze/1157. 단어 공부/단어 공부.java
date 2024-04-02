import java.io.*;
import java.util.*;
import java.util.Map.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
		HashMap<String, Integer> map = new HashMap<>();
		for (int i=0; i<str.length(); i++) {
			String s = str.substring(i, i+1).toUpperCase();
			map.put(s, map.getOrDefault(s, 0)+1);
		}
		
		int maxCnt = 0;
		for(int value : map.values()) {
			if(value > maxCnt) {
				maxCnt = value;
			}
		}
		int check = 0;
		for(Entry<String, Integer> cur : map.entrySet()) {
			if (cur.getValue()==maxCnt) {
				check++;
				bw.write(cur.getKey());
			}
			if (check > 1) {
				System.out.println("?");
				return;
			}
		}
		bw.flush();
	}
}

//참고사항 : 문자열 대문자로 바꾸는 함수 확인
