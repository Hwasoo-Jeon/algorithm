import java.util.*;

class Solution {
    private static int cnt = 1;
    private static HashMap<String, Integer> map = new HashMap<>();
    
    public int solution(String word) {
        
        init(0, "");
        
        String s = "";
        for(int i=0; i< word.length(); i++) {
            String tar = word.substring(i, i+1);
            switch(tar) {
            case "A" :
                s += Integer.toString(0);
                break;
            case "E" :
                s += Integer.toString(1);
                break;
            case "I" :
                s += Integer.toString(2);
                break;
            case "O" :
                s += Integer.toString(3);
                break;
            case "U" :
                s += Integer.toString(4);
                break;
            }
        }
        
        
        return map.get(s);
        // return 0;
    }
    
    private static void init(int depth, String s) {
        
        
        for(int i=0; i<5; i++) {
            String next = s+Integer.toString(i);
            System.out.println(next);
            map.put(next, cnt);
            cnt++;
            if(depth < 4) {
                init(depth+1, next);
            }
            
        }
    }
}



/*
1  A 
2  AA*
3  AAA*
4  AAAA*
5  AAAAA
6  AAAAE
7  AAAAI
8  AAAAO
9  AAAAU
10 AAAE* 
11 AAAEA
12 AAAEE
13 AAAEI
14 AAAEO
15 AAAEU
16 AAAI*
17 AAAIA
18 AAAIE
19 AAAII
20 AAAIO
21 AAAIU
22 AAAO
23
24
25
26 
27 AAAOU
28 AAAU
29 30 31 32 33 
34 AAE



AAAA* => 5 + 1

AAA** => 5*(5+1) + 1
AA*** => 5*(5+1)*(5+1) +1
A**** => 5*(5+1)*(5+1)*(5+1) +1


E**** => 

1563 I(6*6*6*6)
*/