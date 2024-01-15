import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s = br.readLine();
		String[] sArr = s.split(" ");
		int row = Integer.parseInt(sArr[0]);
		int col = Integer.parseInt(sArr[1]);
		String[] dnas = new String[row];
		
		//dna 배열 만들기.
		for(int i = 0 ; i<row; i++ ) {
			dnas[i] = br.readLine();
		}
		
		//각 dna의 자리를 돌며 빈번한 문자 찾기.
		String[] dna = new String[col];
		for(int j=0; j <col; j++) {
			int max = Integer.MIN_VALUE;
			for(int k = 0; k<row; k++) {
				int idx = 0;
				for(int l = 0; l < row; l++) {
					if(dnas[k].charAt(j) == dnas[l].charAt(j)) {
						idx++;	
					}
					
					//빈도수가 최댓값 갱신
					if(idx > max) {
						dna[j] = Character.toString(dnas[k].charAt(j));
						max=idx;
					} else if(idx == max) {
						int alIdx = (dnas[k].charAt(j)) - 96; 
						int alMax = (dna[j].charAt(0)) - 96;
						if(alIdx < alMax) {
							dna[j] = Character.toString(dnas[k].charAt(j));
						} 
					}
				}
			}
		}
		
		String answer = "";
		for(int m=0; m<col; m ++) {
			answer += dna[m];	
		}
		
		int hammingD = 0;
		for(int n = 0 ; n < col; n ++) {
			for(int o = 0 ; o < row;o++ ) {
				if(answer.charAt(n) != dnas[o].charAt(n)) {
					hammingD ++;
				}
			}
		}
		bw.write(answer);
		bw.flush();
		bw.newLine();
		bw.write(hammingD+"");
		bw.flush();
		bw.close(); br.close();
	}
}