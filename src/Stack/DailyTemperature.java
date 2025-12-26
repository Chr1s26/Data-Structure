import java.util.*;

public class DailyTemperature{
    public static void main(String[] args){

    }
    
    public static int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        int count = 0;
        Deque<Integer>  stack = new ArrayDeque<>();
        for(int i = 0; i < temperatures.length; i++){
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                int temp = stack.pop();
                ans[temp] = i - temp;
            }
            stack.push(i);
        }
        return ans;
    }

}