import java.util.*;

public class ValidParantheses{
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '{' || c == '[' || c == '('){
                stack.push(c);
            }else{

                if(stack.isEmpty()) return false;
                
                char temp = stack.pop();
                if(temp == '[' && c != ']' || temp == '{' && c != '}' || temp == '(' && c != ')'){
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}