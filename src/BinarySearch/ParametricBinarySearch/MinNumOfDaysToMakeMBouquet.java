public class MinNumOfDaysToMakeMBouquet{
    public int minDays(int[] bloomDay, int m, int k) {
        if(bloomDay.length < (long) m * k) return -1;

        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        
        for(int i = 0; i < bloomDay.length; i++){
            left = Math.min(bloomDay[i],left);
            right = Math.max(bloomDay[i],right);
        }

        while(left < right){
            int mid = left + (right - left)/2;

            if(canMake(mid,bloomDay,m,k)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }

        return right;
    }

    public boolean canMake(int mid,int[] bloomDay,int m, int k){
        int flowerCount = 0;
        int bouquetCount = 0;
        for(int i = 0; i < bloomDay.length; i++){
            if(bloomDay[i] <= mid){
                flowerCount++;
                if(flowerCount == k){
                    flowerCount = 0;
                    bouquetCount++;
                }
            }else{
                flowerCount = 0;
            }
        }

        return bouquetCount >= m;
    }
}