import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String st = br.readLine();
		String[] arr = new String[st.length()];
		for(int i =0; i<st.length(); i++) {
			arr[i] = st.charAt(i)+"";
		}
		
		String num = "";
		ArrayList<String> list = new ArrayList<String>();
		
		for(int i = 0; i<arr.length; i++) {
			if(arr[i].matches("[0-9]|\\+")) {
				num += arr[i];
			} else {
				list.add(num);
				num = "";
			}
		}
		if(!num.isEmpty()) {
		    list.add(num);
		}
		
		int result = 0;
		if(list.get(0).contains("+")) {
			String[] numArr = list.get(0).split("\\+");
			for(int i =0; i<numArr.length;i++) {
				result += Integer.parseInt(numArr[i]);
			}
		} else {
			result += Integer.parseInt(list.get(0));
		}
		for(int i=1; i<list.size(); i++) {
			if(list.get(i).contains("+")) {
				String[] str = list.get(i).split("\\+");
				int num2 = 0;
				for(int j=0; j<str.length; j++) {
					num2 += Integer.parseInt(str[j]);
				}
				result -= num2;
			} else {
				result -= Integer.parseInt(list.get(i));
			}
		}
		System.out.println(result);
		
	}	
}
