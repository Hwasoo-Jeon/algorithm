import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<ArrayList<String>> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
    	int n = Integer.parseInt(st.nextToken());
    	long target = Integer.parseInt(st.nextToken());
      	for(int i=0; i<=n; i++) {
      		 list.add(new ArrayList<String>());
    	}
      	list.get(0).add("");
      	for(int i=1; i<=n; i++) {
      		ArrayList<String> pre = list.get(i-1);
    		for(String s : pre) {
    			s += "1";
    			list.get(i).add(s);
    		}

    		if(i-2 >= 0) {
    			ArrayList<String> minus2 = list.get(i-2);
    			for(String s : minus2) {
        			s += "2";
        			list.get(i).add(s);
        		}
    		}
    		
    		if(i-3 >= 0) {
    			ArrayList<String> minus3 = list.get(i-3);
    			for(String s : minus3) {
        			s += "3";
        			list.get(i).add(s);
        		}
    			
    		}
      	}

      	Collections.sort(list.get(n));
    	
        if(list.get(n).size() < target) System.out.println(-1);
        else {
        	String s = list.get(n).get((int)target-1);
        	for(int i=0; i<s.length();i++) {
        		System.out.print(s.substring(i,i+1));
        		if(i!= s.length()-1) System.out.print("+");
        	}
        }
    	
	}
}
