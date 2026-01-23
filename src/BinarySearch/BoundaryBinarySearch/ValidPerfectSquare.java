public class ValidPerfectSquare{
    public boolean isPerfectSquare(int num) {
        if(num == 1) return true;
        int left = 1;
        int right = num / 2;
        long sq = 0;

        while(left <= right){
            int mid = left + (right - left)/2;
            sq = (long) mid * mid;
            if(sq == num){
                return true;
            }else if(sq > num){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }

        return false;
    }
}