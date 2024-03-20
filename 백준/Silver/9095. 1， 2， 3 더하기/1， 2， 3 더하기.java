import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int i=0; i< tc; i++) {
			int target = Integer.parseInt(br.readLine());
			int[] dpArr = new int[target+1];
			
			if(target <= 3) {
				if(target == 1) {
					System.out.println(1);
				} else if (target == 2) {
					System.out.println(2);
				} else {
					System.out.println(4);
				}
			} else {
				dpArr[1] = 1;
				dpArr[2] = 2;
				dpArr[3] = 4;
				int result = dpF(target, dpArr);
				System.out.println(result);
			}
		}
	}
	
	private static int dpF(int target, int[] dpArr) {
		if(dpArr[target] != 0) {
			return dpArr[target];
		}
		return dpArr[target] = dpF(target-1, dpArr) + dpF(target-2, dpArr) + dpF(target-3, dpArr);
	}
}
