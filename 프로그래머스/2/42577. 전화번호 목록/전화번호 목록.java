import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        
        Arrays.sort(phone_book);
        int cnt = phone_book.length;
        for(int i=0; i<cnt-1; i++) {
            String preWord = phone_book[i];
            String cur = phone_book[i+1]; //다음 문자와 비교만해도 판별 가능
            if(cur.startsWith(preWord)) {
                return false;
            }
        }
        
        return true;
    }
}