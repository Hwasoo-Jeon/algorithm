class Solution {
    
    static int dest = 0;
    static int size = 0;
    static int answer = 0;
    
    public int solution(int[] numbers, int target) {
        
        dest = target;
        size = numbers.length;        
        dfs(numbers, -1, 0);
    
        return answer;
    }
    //dfs
    private static void dfs(int[] numbers, int depth, int sum) {
        if(depth == size-1) {
            if(sum == dest) {
                answer++;   
            }
            return;
        }
        int cur_num = numbers[depth+1];
        //+연산
        dfs(numbers, depth+1, sum + cur_num);
        //-연산
        dfs(numbers, depth+1, sum - cur_num);
    }
}