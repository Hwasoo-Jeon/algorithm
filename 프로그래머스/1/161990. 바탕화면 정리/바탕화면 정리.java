import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        int tc = wallpaper.length;
        int subLen = wallpaper[0].length();
        ArrayList<Integer[]> dot = new ArrayList<>();
        int r1 = Integer.MAX_VALUE;
        int c1 = Integer.MAX_VALUE;
        int r2 = Integer.MIN_VALUE;
        int c2 = Integer.MIN_VALUE;
        for(int i=0; i<tc; i++) {
            for(int j=0; j<subLen; j++) {
                if(wallpaper[i].charAt(j) == '#') {
                    dot.add(new Integer[] {i,j});
                    r1 = Math.min(r1, i);
                    c1 = Math.min(c1, j);
                    r2 = Math.max(r2, i);
                    c2 = Math.max(c2, j);
                    //System.out.println(i+","+r2+"      "+j+","+c2);
                }  
            }      
        }
        
        answer[0] = r1;
        answer[1] = c1;
        answer[2] = r2+1;
        answer[3] = c2+1;
        return answer;
    }
}

//빈칸 . 파일 #