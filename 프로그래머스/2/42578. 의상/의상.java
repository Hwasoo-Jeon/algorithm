import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String, Integer> map = new HashMap<>();
        for(String[] s : clothes) {
            String cate = s[1];
            map.put(cate,map.getOrDefault(cate, 0)+1);
        }
        
        for(Integer i : map.values()) {
            answer *= (i+1);
        }
        
        
        return answer-1;
    }
}

//갯수 구하기
//조합 1 2 / 2 * 3 -1  