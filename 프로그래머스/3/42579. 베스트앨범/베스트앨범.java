import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, ArrayList<Integer>> innerMap = new HashMap<>();
        int cnt = genres.length;
        for(int i=0; i<cnt; i++) {
            String g = genres[i];
            int p = plays[i];
            map.put(g, map.getOrDefault(g, 0)+p);
            
            if(innerMap.get(g) == null) {
                innerMap.put(g, new ArrayList<Integer>());
            }
            innerMap.get(g).add(i);
            
        }
        
        ArrayList<String> gList = new ArrayList<>(map.keySet());
        Collections.sort(gList, new Comparator<String>() {
            
            @Override
            public int compare(String s1, String s2) {
                int o1 = map.get(s1);
                int o2 = map.get(s2);
                return o2-o1;
            }
        });
        
        ArrayList<Integer> resultList = new ArrayList<>();
        for(String s : gList) {
            ArrayList<Integer> innerList = innerMap.get(s);
            Collections.sort(innerList, new Comparator<Integer>() {
                
                @Override
                public int compare(Integer o1, Integer o2) {
                    int oo1 =plays[o1];
                    int oo2 =plays[o2];
                    if(oo1 != oo2) {
                        return oo2 - oo1;  
                    } 
                    return 0;
                }
            });
            
            for(int i=0; i<innerList.size(); i++) {
                if(i > 1) break;
                resultList.add(innerList.get(i));
            }
        }
        int lSize = resultList.size();
        int[] answer = new int[lSize];
        for(int i =0; i<lSize; i++) {
            answer[i] = resultList.get(i);
        }
        return answer;
    }
}