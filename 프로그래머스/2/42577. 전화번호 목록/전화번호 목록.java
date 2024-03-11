import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        
        // 공백제거
        // for(int i=0; i< phone_book.length; i++) {
        //     phone_book[i].replace(" ","");
        // }
        
        //사전순 정렬(유사 접두사)
        Arrays.sort(phone_book);
        
        //1개 요소를 가지고 나머지 요소 탐색, matches, 최대 1억
        for(int i=0; i< phone_book.length -1; i++) {
            int p_length = phone_book[i].length();
            String p_str = phone_book[i];
            int c_length = phone_book[i+1].length();
            String c_str = phone_book[i+1];
            if(p_str.charAt(0) != c_str.charAt(0) || c_length < p_length) {
                continue;
            } else if (c_str.startsWith(p_str)) {
                return false;
            }
            
        }
        
        return true;
    }
}