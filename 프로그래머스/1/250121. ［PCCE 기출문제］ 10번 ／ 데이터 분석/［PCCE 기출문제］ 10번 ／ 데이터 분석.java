import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int size = data.length;
        ArrayList<int[]> result = new ArrayList<>();
        for(int i=0; i<size; i++) {
            int[] cur = data[i];
            if(ext.equals("code")) {
                if(cur[0] < val_ext) result.add(cur);
            } else if(ext.equals("date")) {
                if(cur[1] < val_ext) result.add(cur);
            } else if(ext.equals("maximum")) {
                if(cur[2] < val_ext) result.add(cur);
            } else {
                if(cur[3] < val_ext) result.add(cur);
            }
        }
        result.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(sort_by.equals("code")) {
                    return o1[0] - o2[0];
                } else if(sort_by.equals("date")) {
                    return o1[1] - o2[1];
                } else if(sort_by.equals("maximum")) {
                    return o1[2] - o2[2];
                } else {
                    return o1[3] - o2[3];
                }
            }
        });
        
        int rSize = result.size();
        int[][] answer = new int[rSize][4];
        for(int i=0; i<rSize; i++) {
            for(int j=0; j<4; j++) {
                answer[i][j] = result.get(i)[j];
            }
        }
        
        return answer;
    }
}
/*
*code, date, maximum, remain
*ext는 위의 것
*val_ext는 int
*sort_by는 오름차순
*/