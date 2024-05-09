import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        for(int i=2; i<=n; i++) {
        	dp[i] = dp[i-1] + 1;
        	if(i%3 == 0) dp[i] = Math.min(dp[i], dp[i/3] + 1);
        	if(i%2 == 0) dp[i] = Math.min(dp[i], dp[i/2] + 1);
        }
        System.out.println(dp[n]);
	}
	
	//top down (재귀)
	/*
	public static int d[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        d = new int[number+1];
        System.out.println(calculate(number));
    }

    public static int calculate(int number){
    	System.out.println("calulate 함수: " + number);
        if (number == 1){
        	System.out.println("number == 1");
            return 0;
        }
        if (d[number] > 0){
        	System.out.println("d[number] > 0");
            return d[number];
        }
        d[number] = calculate(number-1) + 1;
        if (number%3 == 0) {
            d[number] = Math.min(d[number],calculate(number/3) +1);
        }
        if (number%2 == 0) {
            d[number] = Math.min(d[number],calculate(number/2) +1);
        }
        return d[number];
    
	}*/
}

