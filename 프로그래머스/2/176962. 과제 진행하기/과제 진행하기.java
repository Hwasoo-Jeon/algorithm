import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        // 입력값 시간 정렬
		Arrays.sort(plans, new Comparator<String[]>() {
			@Override
			public int compare(String[] o1, String[] o2) {

				if (!o1[1].equals(o2[1])) {
					int time1 = Integer.parseInt(o1[1].substring(0, 2));
					int time2 = Integer.parseInt(o2[1].substring(0, 2));
					int min1 = Integer.parseInt(o1[1].substring(3, 5));
					int min2 = Integer.parseInt(o2[1].substring(3, 5));
					if (time1 != time2) {
						if (time1 < time2)
							return -1;
						else
							return 1;
					} else {
						if (min1 < min2)
							return -1;
						else
							return 1;
					}
				}
				return 0;
			}
		});
		
		// 진행중인과제
		Queue<String[]> progressQ = new LinkedList<>();
		// 남은 과제
		Queue<String[]> remainQ = new LinkedList<>();
		// 잠시멈춘 과제
		Stack<String[]> stopStack = new Stack<>();
		// 완료 과제 모음
		ArrayList<String> list = new ArrayList<>();

		//시간 문자열을 숫자로 변환
		for (int i = 0; i < plans.length; i++) {
			String[] cur = plans[i];
			int time = Integer.parseInt(cur[1].substring(0,2));
			int min = Integer.parseInt(cur[1].substring(3,5));
			cur[1] = String.valueOf(time*60+min);
			remainQ.offer(cur);
		}
		
		//첫 과제 시작
		progressQ.offer(remainQ.poll());
		int curTime = Integer.parseInt(progressQ.peek()[1]);

		int nextTime;
		
		
		while (list.size() != plans.length) {
			
			//대기중인 과제 목록이 있다면
			if (!remainQ.isEmpty()) {
				String[] next = (remainQ.peek());
				nextTime = Integer.parseInt(next[1]);
			} else {
				//만일 현재 진행 목록에 들어간것이 있다면?
				if(!progressQ.isEmpty()) {
					list.add(progressQ.poll()[0]);
					continue;
				//없으면 멈춘 스택 반환 진행.
				} else {
					list.add(stopStack.pop()[0]);
					continue;
				}
			}
			
			//현재 시각이 다음 과제 시간이 아니라면
			if (nextTime > curTime) {
				int diff = nextTime - curTime;
				if (!progressQ.isEmpty()) {
					String[] change = progressQ.poll();
					int changeRes = Integer.parseInt(change[2]);
					
					//작업 완료했을 때
					if (changeRes - diff <= 0) {
						list.add(change[0]);
						curTime += changeRes;
						
						for(String[]s : stopStack) {
							s[1] = String.valueOf(curTime);
						}
						if(!stopStack.isEmpty() && nextTime > Integer.parseInt(stopStack.peek()[1])) {
							progressQ.offer(stopStack.pop());
						} else {
							progressQ.offer(remainQ.poll());
							curTime = Integer.parseInt(progressQ.peek()[1]);
						}

					} else { //작업 못끝냇을 때
						change[2] = String.valueOf(changeRes - diff);
						stopStack.add(change);
						for(String[] s : stopStack) {
							s[1] = String.valueOf(nextTime);
						}
						
						if (!remainQ.isEmpty()) {
							progressQ.offer(remainQ.poll());
						} else if (!stopStack.isEmpty()) {
							progressQ.offer(stopStack.pop());
						}
						curTime = nextTime;
					}
				} else {//다른것 작업할 시간
					if (!remainQ.isEmpty()) {
						progressQ.offer(remainQ.poll());
					} else {
						progressQ.offer(stopStack.pop());
					}
					curTime = nextTime;
				}
			}
		}
		String[] answer = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}

		return answer;
    }
}

/*
1. 입력 정렬 
for(String[] s : plans) {
    System.out.println(s[1]);
}

2. 
가장 최근에 멈춘 과제 부터 진행. => Stack?

*/