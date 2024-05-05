import java.util.*;

class Solution {
    public long[] solution(long[] numbers) {
        
        ArrayList<Long> list = new ArrayList<>();
		for (long n : numbers) {

			if (n % 2 == 0) {

				list.add(n + 1);

			} else {
				long num = n;
				String s = "";
				int oper = 1;
				while (num > 0) {
					s += (num % 2) * oper + "";
					num /= 2;
				}

				int len = s.length();
				String st = "";
				for (int i = len - 1; i >= 0; i--) {
					st += s.substring(i, i + 1);
				}
				//System.out.println(st);
				boolean flag = false;
				for (int i = len - 1; i >= 0; i--) {
					String cur = st.substring(i, i + 1);

					if (cur.equals("0")) {
						if (i != 0) {
							n += Math.pow(2, len-i-1);
							n -= Math.pow(2, len-i-2);
						} else {
							n += 1;
						}
						flag = true;
						break;
					}
				}
				if (flag) {
					list.add(n);
				} else {
					n += Math.pow(2, len);
					n -= Math.pow(2, len - 1);
					list.add(n);
				}

			}

		}

		long[] answer = new long[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}

		return answer;
    }
}

/*



*/