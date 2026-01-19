public class KoKoEatingBanana{
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        for(int i = 0; i < piles.length; i++){
            right = Math.max(right,piles[i]);
        }

        while(left < right){
            int mid = left + (right - left)/2; 

            if(canEat(mid,piles,h)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }

        return right;
    }

    public boolean canEat(int mid, int[] piles, int h){
        int hours = 0;
        int temp = 0;
        for(int i = 0; i < piles.length; i++){
            hours += (piles[i] + mid - 1) / mid;
        }
        return hours <= h;
    }
}