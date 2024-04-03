import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); //50
		int[] num = new int[n];
		int[] dp = new int[n];
		for(int i=0; i<n; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(num);
		ArrayList<Integer> plus = new ArrayList<>();
		ArrayList<Integer> minus = new ArrayList<>();
		for(int i=0; i<n; i++) {
			if(num[i] <= 0) {
				minus.add(num[i]);
			} else {
				plus.add(num[i]);
			}
		}
		
		
		int answer1 = 0;
		for(int i=0; i<minus.size(); i+=2) {
			int left = i;
			if(left == minus.size()-1) {
				answer1 += minus.get(left);
				break;
			}
			
			int right = i+1;
			int num1 = minus.get(right)*minus.get(left);
			answer1 += num1;
		}
		
		int answer2 = 0;
		for(int i=plus.size()-1; i>=0; i-=2) {
			int right = i;
			if(right == 0) {
				answer2 += plus.get(right);
				break;
			}
			
			int left = i-1;
			int num1 = plus.get(left)*plus.get(right);
			int num2 = plus.get(left)+plus.get(right);
			answer2 += Math.max(num1, num2);
		}
		
		System.out.println(answer1+answer2);
	}
}

/* 실패 코드 : 제한 사항, 두수를 바로바로 묶어서 실패

케이스 
5
-537
81
-435
257
157
답 274025

int answer1 = 0;
int answer2 = 0;

for(int i=n-1; i>=0; i-=2) {
	int right = i;
	if(right == 0) {
		answer1 += num[right];
		break;
	}
	
	int left = i-1;
	int num1 = num[right]*num[left];
	int num2 = num[right]+num[left];
	answer1 += Math.max(num1, num2);
}

for(int i=0; i<n; i+=2) {
	int left = i;
	if(left == n-1) {
		answer2 += num[left];
		break;
	}
	
	int right = i+1;
	int num1 = num[right]*num[left];
	int num2 = num[right]+num[left];
	answer2 += Math.max(num1, num2);
}

System.out.println(Math.max(answer1, answer2));
*/
