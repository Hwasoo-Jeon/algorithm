import java.util.*;

class Solution {
    class Word {
        String words;
        int cnt;
        boolean[] visited;
        Word(String words, int cnt, boolean[] visited) {
            this.words = words;
            this.cnt = cnt;
            this.visited = visited;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        int len = begin.length();
        Queue<Word> q = new LinkedList<>();
        q.offer(new Word(begin, 0, new boolean[words.length]));
        
        while(!q.isEmpty()) {
            Word cur = q.poll();
            
            if(cur.words.equals(target)) {
                if(answer != 0) answer = Math.min(answer, cur.cnt);
                else answer = cur.cnt;
            }
            
            for(int i=0; i<words.length; i++) {
                ArrayList<Integer> cntCheck = new ArrayList<>();
                String compareStr = words[i];
                if(!cur.visited[i]) {
                    
                    for(int j=0; j<len; j++) {
                        if(cur.words.charAt(j) != compareStr.charAt(j)) {
                            cntCheck.add(j);
                        }
                    }
                    
                    if(cntCheck.size() == 1) {
                        cur.visited[i] = true;
                        q.offer(new Word(words[i], cur.cnt+1, cur.visited));
                    }
                    
                }
                
            }
        }
        return answer;
    }

}