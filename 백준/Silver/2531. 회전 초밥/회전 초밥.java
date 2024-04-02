import java.io.*;
import java.util.*;

public class Main {
	private static int[] plate;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //20000
		int d = Integer.parseInt(st.nextToken()); //3000
		int K = Integer.parseInt(st.nextToken()); //3000
		int c = Integer.parseInt(st.nextToken()); //3000
		plate = new int[N];
	
		for(int i=0; i<N; i++) {
			plate[i] = Integer.parseInt(br.readLine());
		}

		//회전초밥모양 만들기
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			list.add(plate[i]);
		}
		for(int i=0; i<K-1; i++) {
			list.add(plate[i]);
		}
		
		//투포인터 list,set 생성
		ArrayList<Integer> twoList = new ArrayList<>();
		HashSet<Integer> set = new HashSet<>();
		int left = 0;
		int right = K-1;
		int answer = 0;
		for(int i=0; i<=K-1; i++) {
			twoList.add(plate[i]);
			set.add(plate[i]);
		}
		
		while(true) {
			if(set.contains(c)) {
				answer= Math.max(answer, set.size());
			} else {
				answer= Math.max(answer, set.size()+ 1); 
			}
			
			left++;
			right++; //left 0 right 3 list size 11
			twoList.remove(list.get(left-1));
			twoList.add(list.get(right));
			set = new HashSet<>(twoList);
			if(right == list.size()-1) {
				break;
			}
		}
		
		if(set.contains(c)) {
			answer= Math.max(answer, set.size());
		} else {
			answer= Math.max(answer, set.size()+ 1); 
		}
		System.out.println(answer);
	}
}
// 참고사항 : 투포인터 활용, poll이 필요하지 않다면, list를 추가로 연결하여 위와 같이 활용 가능.
