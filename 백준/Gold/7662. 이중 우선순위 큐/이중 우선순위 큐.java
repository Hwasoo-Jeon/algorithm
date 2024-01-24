import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	
	//treemap 이용, 중복값 처리를 위한 로직 추가.자동오름차순 정렬
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());

		for (int i = 0; i < tc; i++) {
			TreeMap<Integer,Integer> map = new TreeMap<>();
			int k = Integer.parseInt(br.readLine()); // k ≤ 1,000,000
			
			for (int j = 0; j < k; j++) {
				String[] com = br.readLine().split(" ");
				int num = Integer.parseInt(com[1]);
				
				if (com[0].equals("I")) {
					map.put(num,map.getOrDefault(num,0)+1); //(num,값+1)
				} else {
					if(map.size()!=0) {
						if (num==-1) {//작은키삭제
							int fkey = map.firstKey();
							if(map.get(fkey)>1) { 
								map.put(fkey, map.get(fkey)-1);
							} else {//1개 이하면 삭제
								map.remove(fkey);
							}
						} else {//큰키삭제
							int lkey = map.lastKey();
							if(map.get(lkey)>1) {
								map.put(lkey, map.get(lkey)-1);
							} else {
								map.remove(lkey);
							}
						}
					}
				}
			}
			
			if (map.size()!=0) {
				sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
			} else {
				sb.append("EMPTY\n");
			}
		}
		bw.write(sb.toString());
		bw.flush();
	}

}
