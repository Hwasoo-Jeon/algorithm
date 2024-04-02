import java.util.*;
import java.util.Map.*;
class Solution {
    
    //depth, 문자열(반복제거),빈도수 저장용 조합Map
	private static HashMap<Integer, HashMap<String, Integer>> combiResultMap = new HashMap<>();
    
    public String[] solution(String[] orders, int[] course) {
        //자릿수에 해당하는 빈도수대로 조합 결과 저장
        for(int num : course) {
        	combiResultMap.put(num, new HashMap<>());
        }
        
        for (String order : orders) {
        	// 조합 생성 전 정렬
			char[] charArr = order.toCharArray();
			Arrays.sort(charArr);
			
			//각 문자에 대하여 조합케이스별로 재귀 진행 => 재귀 결과는 map에 저장
			for (int num : course) {
				//start, 자릿수, 조합생성문자열, 문자열생성용
				recur(0, num, new String(charArr), new StringBuilder());
			}
		}
        
        ArrayList<String> resultList = new ArrayList<String>();
        for(int num : course) {
        	int maxCnt = 2;
        	HashMap<String, Integer> map = combiResultMap.get(num);
        	for(int count : map.values()) {
        		if(count > maxCnt) {
        			maxCnt = count;
        		}
        	}
        	
        	for(Entry<String, Integer> cur : map.entrySet()) {
        		if(cur.getValue() == maxCnt) {
        			resultList.add(cur.getKey());
        		}
        	}
        }
        String[] result = new String[resultList.size()];
        for(int i=0; i < resultList.size(); i++) {
        	result[i] = resultList.get(i);
        }
        Arrays.sort(result);
        
        return result;
    }
    
    //start, 자릿수, 조합생성문자열, 문자열생성용
    private static void recur(int start, int depth, String order, StringBuilder sb) {
        if(sb.length() == depth) {
        	String combi = sb.toString();
			combiResultMap.get(depth).put(combi, combiResultMap.get(depth).getOrDefault(combi, 0) + 1);
			return;
        }
        
        for(int i=start; i<order.length(); i++) {
    		recur(i+1, depth, order, sb.append(order.charAt(i)));
    		sb.deleteCharAt(sb.length() - 1);
        }
    }
}
// 수정 사항 
// 기존 : 조합을 알파벳 리스트를 Set으로 하여 주문에 등장한 모든 알파벳에 대하여 조합갯수만큼 재귀
// 수정 : 조합갯수만큼 재귀를 돌리되, 알파벳 리스트가 아닌 주문건 문자열로 돈다.
//       이렇게 되면, 주문건 간 중복 알파벳이 잇을것이고 이를 중복을 막을 Map과 이의 빈도수를 저장한다.