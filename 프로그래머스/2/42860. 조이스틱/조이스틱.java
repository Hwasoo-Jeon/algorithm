class Solution {
    public int solution(String name) {
        int size = name.length();
        int[] arr = new int[size*2];
        int answer = 0;
        
        // 각 위치의 조이스틱 움직임으로 만들 수 있는 횟수 저장
        for(int i=0; i<size; i++) {
            int input = Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i)+1);
            arr[i] = input;
            answer += input;
        }
        
        //좌에서 우, 우에서 좌(만약 한쪽으로 가는것이 빠르면 Math.min으로 체크)
        int move = size - 1;
        int start = 0;
        while(start < size) {
            
            //A의 연속 지점 체크 (A가 뭉쳐있으면 돌아가거나 반대로 가면 되기 떄문)
            int idx = start+1;
            while(idx < size && name.charAt(idx) == 'A') {
                idx++;
            }
            // 우 -> 좌 -> 좌
            move = Math.min(start*2 + size - idx, move);
            // 좌 -> 우 -> 좌
            move = Math.min((size-idx)*2+ start, move);
            start++;
        }
        
        answer+=move;
        return answer;
    }
}

/*
// 투포인터 실패
int left = 0;
int right = 0;
int windowSum = 0;
int minWidth = Integer.MAX_VALUE;

while (left < size*2) {
    if (windowSum == temp) {
        minWidth = Math.min(minWidth, right - left -1);
    }

    if(right <size*2-1 && windowSum < temp) {
        windowSum += arr[right++];
    } else {
        windowSum -= arr[left++];
    }
}

return temp+minWidth;
========        
//우
int right = 0;
for(int r=0; r<size; r++) {
    right += arr[r];
    if(right == temp) {
        answer = Math.min(right+r, answer);
        break;
    }
}
//좌
int left = 0;
int cnt = 0;
for(int l=size; l >0; l--) {
    if(l == size && arr[0] != 0) {
        left += arr[0]; 
    } else if (left == 0) {

    }
    else left += arr[l];

    if(left == temp) {
        answer = Math.min(left+cnt, answer);
        break;
    }
    cnt++;
}  
*/