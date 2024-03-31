import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		ArrayList<String> list = new ArrayList<String>();
		Map<String, Integer> aplist = new HashMap<>();
		for(int i=0; i<tc; i++) {
			String str = br.readLine();
			list.add(str);
			for(int j=0; j<str.length(); j++) {
				int num = str.length();
				int curW = (int)Math.pow(10,num-j-1);
				String al = str.substring(j,j+1);
				if(!aplist.containsKey(al)) {
					aplist.put(al, curW);
				} else {
					int inputW = aplist.get(al);
					aplist.put(al, inputW+curW);
				}
			}
		}
		
		List<String> keyset = new ArrayList<>(aplist.keySet()); //정렬용도로 map의 key를 담은 list 구현체
		keyset.sort(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return aplist.get(o2) - aplist.get(o1);
			}
		});
		
		Map<String, Integer> valueList = new HashMap<>();
		int input = 9;
		for(String key : keyset) {
			valueList.put(key, input);
			input--;
		}
		
		int result = 0;
		for(int i =0; i<list.size(); i++) {
			String cur = list.get(i);
			String trans = "";
			for(int j=0; j<cur.length(); j++) {
				trans += valueList.get(cur.substring(j,j+1));
			}
			result += Integer.parseInt(trans);
		}
		System.out.println(result);
	}
}

/*
 * 참고사항 : map 인터페이스의 정렬방식 => 객체.keySet()을 담은 ArrayList를 생성하여 이를 객체.sort(new Comparator<String>{}) 해라
 * 가중치 아이디어 : 단순 자릿수 -> 빈도수가 아닌 , 자릿수 와 빈도수를 합친 그 가중치로 정렬.
*/