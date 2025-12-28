public class CheckPalindrome{
    public static void main(String[] args){
        System.out.println(isPalindrome("race a car"));
    }

    public static boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^a-z0-9]","");
        if(s.length() == 1 || s.isEmpty()) return true;
        int left = 0;
        int right = s.length()-1;
        return check(s,left,right);
    }

    public static boolean check(String s,int left,int right){
        if(left >= right) return true;
        if(s.charAt(left) != s.charAt(right)) return false;
        return check(s,left + 1,right - 1);
    }
}