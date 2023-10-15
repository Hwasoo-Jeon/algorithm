import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
         
        int result = 0;
        int open = 0;
        for(int i=0; i<input.length(); i++) {
        	if(input.charAt(i)=='(') {
        		open++;
        	} else {
        		open--;
        		if(input.charAt(i-1)==')') {
        			result++;
        		} else {
        			result += open;
        		}
        	}
        }
        System.out.println(result);
    }
}