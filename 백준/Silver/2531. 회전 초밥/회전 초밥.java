import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); //20000
		int d = Integer.parseInt(st.nextToken()); //3000
		int K = Integer.parseInt(st.nextToken()); //3000
		int c = Integer.parseInt(st.nextToken()); //3000
		int[] plate = new int[N];
		int[] eating = new int[d+1];
		
		for(int i=0; i<N; i++) {
			plate[i] = Integer.parseInt(br.readLine());
		}
		
		//투포인터 사용
		int answer = 0;
		eating[c]=1;
		
		int cnt = 1;
		for(int i=0; i<K;i++) {
			if(eating[plate[i]]==0) {
				cnt++;
			}
			eating[plate[i]]++;
		}
		answer = cnt;

		for(int i=1; i<N; i++) {
			int right = (i+K-1)%N; //i
			if(eating[plate[i-1]]==1) {
				cnt--;
			}
			eating[plate[i-1]]--;
			if(eating[plate[right]]==0) {
				cnt++;
			}
			eating[plate[right]]++;
			
			answer = Math.max(answer, cnt);
		}
		
		System.out.println(answer);
	}

}

/*
// right list,twoList를 삭제하고 바로 set에 담으면 시간절약됨.
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
*/