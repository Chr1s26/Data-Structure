import java.util.*;

public class BackSpaceStringCompare{
    public static void main(String[] args){

    }

    public static boolean backspaceCompare(String s, String t) {
        return compute(s).equals(compute(t));
    }   

    public static String compute(String s){
        Deque<Character> stack = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '#'){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else{
                stack.push(s.charAt(i));
            }
        }

        return stack.toString();
    }
}