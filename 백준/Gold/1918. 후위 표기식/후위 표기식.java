import java.io.*;
import java.util.*;

public class Main {
		//피연산자는 계속 붙임
		//괄호 우선순위 => 열리는건 그냥 넣고, 닫는 것 나오면 열리는게 나올 때 까지 pop&append => 괄호가 열릴 수록 어차피 상위 순위라서
	    //연산자 우선순위 존재
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			String s = br.readLine();
			Stack<Character> operator = new Stack<Character>();
			StringBuilder sb = new StringBuilder();
			char val = ' ';
			
			for (int i = 0 ; i < s.length(); i++) {
				val = s.charAt(i);
				if(val>= 'A'&& val<='Z') {
					sb.append(val);
				} else if (val == '(') {
					operator.push(val);
				} else if (val == ')') {
					while(!operator.isEmpty()) {
						if(operator.peek()=='(') { //'(' 버리기
							operator.pop();
							break;
						}
						sb.append(operator.pop());
					}
				} else if (val=='*'||val=='/') { // A*(B+C)*A*B+(C+D) AB*+CD+
					while(!operator.isEmpty()) {
						if (operator.peek() == '*' || operator.peek() == '/') {
							sb.append(operator.pop());
						} else {
							break;
						}
					}
					operator.push(val);
				} else if (val=='+' || val=='-') {
					while(!operator.isEmpty() && operator.peek()!='(') {
						sb.append(operator.pop());
					}
					operator.push(val);
				}
			}
			
			while(!operator.isEmpty()) {
				sb.append(operator.pop());
			}
			
			bw.write(sb.toString());
			bw.flush();
		}
}
