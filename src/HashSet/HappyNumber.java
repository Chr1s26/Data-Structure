public class HappyNumber{
    public static void main(String[] args){
        isHappy(19);
    }

    public static boolean isHappy(int n) {

        int quotient = n / 10;
        int sum = 0;
        int remainder = 0;

        if(quotient == 0 && n == 1) return true;
        else if(quotient == 0) return false;

        sum = n;

        while(sum != 1){
            quotient = sum;
            while(quotient != 0){
                remainder = quotient % 10;
                sum += Math.pow(remainder,2);
                quotient = quotient / 10;
            }
        }

        return true;
    }
}