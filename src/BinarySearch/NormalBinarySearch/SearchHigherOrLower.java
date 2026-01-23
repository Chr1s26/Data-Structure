public class SearchHigherOrLower{
    int picked = 3;

    public int guessNumber(int n) {
        int left = 1;
        int right = n;

        while(left <= right){
            int mid = left + (right - left)/2;
            int guess = guess(mid);
            if(guess == -1){
                right = mid - 1;
            }else if(guess == 1){
                left = mid + 1;
            }else if(guess == 0){
                return mid;
            }
        }

        return -1;
    }

    public int guess(int mid){
        if(mid == picked) return 0;
        else if(mid > picked) return -1;
        else return 1;
    }
}