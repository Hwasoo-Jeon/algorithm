import java.util.*;

class Solution {
    private static ArrayList<Integer> list = new ArrayList<>();
    public int solution(String numbers) {
        int cnt = numbers.length();
        int[] arr = new int[cnt];
        for(int i =0; i< cnt; i++) {
            arr[i] = Integer.parseInt(numbers.substring(i, i+1));
        }
        makeNum(0, cnt, arr, "", new boolean[cnt]);
        HashSet<Integer> set = new HashSet<>();
        for(int i : list) {
            set.add(i);
        }
        
        return set.size();
    }
    
    private static void makeNum(int depth, int cnt, int[] arr, String s, boolean[] visited) {
        if(depth <= cnt && depth > 0) {
            int num = Integer.parseInt(s);
            if (isPrime(num)) {
                list.add(num);
            }
        }
        
        for(int i =0; i<cnt; i++) {
            if(visited[i]) continue;
            String newS = s+String.valueOf(arr[i]);
            if(newS.length() == 1 && newS.equals("0")) continue;
            visited[i] = true;
            makeNum(depth+1, cnt, arr, newS, visited);
            visited[i] = false;
        }
    }
    
    private static boolean isPrime(int num) {
        if (num <= 1) return false;
        for(int i=2; i<=Math.sqrt(num); i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
}