import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		Stack<Character> stackL = new Stack<>();
		Stack<Character> stackR = new Stack<>();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
		for (int i = 0; i < str.length(); i++) {
			stackL.push(str.charAt(i));
		}

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			String com = br.readLine();
			if (com.equals("L")) {
				if (!stackL.empty()) {
					stackR.push(stackL.pop());
				}
			} else if (com.equals("D")) {
				if (!stackR.empty()) {
					stackL.push(stackR.pop());
				}
			} else if (com.equals("B")) {
				if (!stackL.empty()) {
					stackL.pop();
				}
			} else if (com.contains("P")) {
				char c = com.charAt(2);
				stackL.push(c);
			}
		}

		while (!stackL.empty()) {
			stackR.push(stackL.pop());
		}

		while (!stackR.empty()) {
			bw.write(stackR.pop());
		}
		bw.flush();
	}
}
