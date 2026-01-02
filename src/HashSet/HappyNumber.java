import java.util.*;

public class HappyNumber{
    public static void main(String[] args){
        System.out.print(isHappy(19));
    }

    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();

        while(!set.contains(n)){
            set.add(n);
            n = get(n);
            if(n == 1) return true;
        }

        return false;
    }

    public static int get(int n){
        int sum = 0;
        int x = 0;
        while(n != 0){
            x = n % 10;
            sum += x * x;
            n = n / 10;
        }
        return sum;
    }
}