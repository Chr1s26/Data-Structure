public class PowerOfTwo{
    public static void main(String[] args){
        System.out.print(isPowerOfTwo(1));
    }
    public static boolean isPowerOfTwo(int n){
        if(n == 1) return true;
        if(n % 2 != 0 || n < 1) return false;
        return isPowerOfTwo(n / 2);
    }
}