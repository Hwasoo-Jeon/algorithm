import java.util.*;
import java.io.*;


public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		for (int i=0; i <num; i++) {
			for(int j= num-i-1; j>0;j--) {
				System.out.print(" ");
			}
			for(int j = 0; j<1+i*2; j++ ) {
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i=num-1; i>0; i--) {
			for(int j = 1; j<=num-i; j++ ) {
				System.out.print(" ");
			}
			for(int j= 2*(i-1)+1; j>0;j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}