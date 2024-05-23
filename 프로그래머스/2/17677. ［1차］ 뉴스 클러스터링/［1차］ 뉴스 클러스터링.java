import java.util.*;
import java.util.Map.Entry;

class Solution {
    public int solution(String str1, String str2) {
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        
        for(int i=0; i<str1.length()-1; i++) {
            String s = (str1.substring(i, i+2)).toUpperCase();
            if(!s.matches("[A-Z]*")) {
                continue;                
            }
            map1.put(s, map1.getOrDefault(s, 0)+1);
        }
        for(int i=0; i<str2.length()-1; i++) {
            String s = (str2.substring(i, i+2)).toUpperCase();
            if(!s.matches("[A-Z]*")) {
                continue;                
            }
            map2.put(s, map2.getOrDefault(s, 0)+1);
        }
        
        int gyoNum =0;
        int hapNum =0;
        
        // 교,합 집합 구하기
        for(Map.Entry s : map2.entrySet()) { 
            if(map1.containsKey(s.getKey())) {
                gyoNum += Math.min((int)s.getValue(), map1.get(s.getKey()));
                hapNum += Math.max((int)s.getValue(), map1.get(s.getKey()));
            } else {
                hapNum += (int)s.getValue(); 
            }
        }
        
        // 합집합 구하기(map1은 위에서 합집합 숫자 채움, map2가 가지지 않은 map1의 요소를 더하기)
        for(Map.Entry s : map1.entrySet()) {
            if(!map2.containsKey(s.getKey())) {
                hapNum += (int)s.getValue();
            }
        }
        
        int answer = hapNum==0 ? 65536 : (int)(((double)gyoNum/hapNum) * 65536);
        return answer;
    }
}