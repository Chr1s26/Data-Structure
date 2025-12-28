public class CountZero{
    public static void main(String[] args){
        System.out.print(countZeros(90009));
    }

    public static int countZeros(int n) {
        if(n == 0) return 0;
        int count = 0;
        int remainder = n % 10;
        if(remainder == 0){
            count++;
        }
        count += countZeros(n / 10);
        return count;
    }
}