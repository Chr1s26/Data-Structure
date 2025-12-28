public class AddDigits{
    public static void main(String[] args){

    }

    public static int addDigits(int num) {
        if(num < 10) return num;

        int ans = (num % 10) + addDigits(num / 10);

        if(ans >= 10) ans = addDigits(ans);

        return ans;
    }
}