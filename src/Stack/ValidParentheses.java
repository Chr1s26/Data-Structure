
import java.util.*;

public class ValidParentheses{
    public static void main(String[] args){
        System.out.println(isValid("{}"));
    }

    public static boolean isValid(String s){
        if(s.length() % 2 != 0) return false;

        int half = s.length() / 2;
        Deque<Character> q = new ArrayDeque();
        for(int i = 0; i < half; i++){
            q.push(s.charAt(i));
        }

        for(int j = half; j < s.length(); j++){
            char temp = q.pop();
            char c = s.charAt(j);
            if(temp != c) {
                return false;
            }
        }
        return true;
    }
}