import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String[] arr = s.split(" ");
		String num1 ="";
		String num2 ="";
		for(int i=2; i>=0; i--) {
			num1 += arr[0].charAt(i);
			num2 += arr[1].charAt(i);
		}
		System.out.println(Integer.parseInt(num1) >= Integer.parseInt(num2) ? num1: num2);
	}
	
}
