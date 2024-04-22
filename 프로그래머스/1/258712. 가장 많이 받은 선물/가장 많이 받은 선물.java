import java.util.*;
import java.util.Map.*;

class Solution {
    
    public int solution(String[] friends, String[] gifts) {
        int n = friends.length;
        Map<String, Integer> idx = new HashMap<>();
        int[][] map = new int[n][n]; //맵정리
        int[][] resultMap = new int[n][3]; //지수
        
        for(int i=0; i<n; i++) {
            idx.put(friends[i], i);
        }
        
        for(int i=0; i<gifts.length; i++) {
            String[] arr = gifts[i].split(" ");
            int sender = idx.get(arr[0]);
            int given = idx.get(arr[1]);
            map[sender][given] += 1;
        }
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                // System.out.print(map[i][j]+" ");
                if(i==j) continue;
                
                if(map[i][j] > 0) {
                    resultMap[i][0] += map[i][j];
                    resultMap[j][1] += map[i][j];
                }
            }
            //System.out.println();
        }
        
        for(int i=0; i<n;i++) {
            resultMap[i][2] = resultMap[i][0] - resultMap[i][1];
            //System.out.println(resultMap[i][0]+" "+resultMap[i][1]+" " +resultMap[i][2]);
        }
        
        //선물 주고 받기
        Map<Integer,Integer> result = new HashMap<>();
        for(int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                //System.out.print(map[i][j]+" ");
                
                if(map[i][j] != map[j][i]) {
                    if(map[i][j] > map[j][i]) {
                        result.put(i,result.getOrDefault(i,0)+1);
                    } else {
                        result.put(j,result.getOrDefault(j,0)+1);
                    }
                } else if(map[i][j] == map[j][i]) {
                    
                    if(resultMap[i][2] != resultMap[j][2]) {
                        if (resultMap[i][2] > resultMap[j][2]) {
                            result.put(i,result.getOrDefault(i,0)+1);
                        } else {
                            result.put(j,result.getOrDefault(j,0)+1);   
                        }
                    }
                } 
            }
        }
        
        //결과 출력
        //map으로 list 생성
        ArrayList<Integer> list = new ArrayList<>(result.keySet());
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return result.get(o2) - result.get(o1); 
            }
        });
        
        for(Integer i : list) {
            System.out.println(result.get(i));
        }
        
        int gift = 0;
        for(Integer i : list) {
            if(result.get(i) > gift) {
                gift = result.get(i);
            } 
        }
        return gift;
    }
}