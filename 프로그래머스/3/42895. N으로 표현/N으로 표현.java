import java.util.*;

class Solution {
    public static int solution(int N, int number) {
        int answer = -1;
        ArrayList<ArrayList<Integer>> dp = new ArrayList<>();
        
        for(int i=0; i<=8; i++) {
            dp.add(new ArrayList<Integer>());
            if(i == 1) {
                dp.get(i).add(N);    
            } else if (i >= 2) {
                String s = Integer.toString(dp.get(i-1).get(0));
                dp.get(i).add(Integer.parseInt(s+N));    
            }
            if(i > 0) {
                if(dp.get(i).get(0) == number) return i;    
            }
        }
        
        for(int i=2; i<=8; i++) {
            for(int x=i-1; x>0; x--) {
                int y = i-x;
                HashSet<Integer> set = new HashSet<>();
                for(int n : dp.get(x)) {
                    for(int n2 : dp.get(y)) {
                        int[] arr = new int[] {n+n2, n-n2, n*n2, n/n2};
                        if(arr[0] == number || arr[1] == number || arr[2] == number || arr[3] == number) {
                        	return i;
                        }
                        for(int arrN : arr) {
                            if(arrN != 0) {
                                set.add(arrN);
                            }
                        }
                    }    
                }
                dp.get(i).addAll(set);     
            }
        }
        return answer;
    }
}