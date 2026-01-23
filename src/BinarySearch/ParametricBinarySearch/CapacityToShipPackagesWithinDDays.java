public class CapacityToShipPackagesWithinDDays{
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;

        for(int i = 0; i < weights.length; i++){
            left = Math.max(weights[i], left);
            right += weights[i]; 
        }

        while(left < right){
            int mid = left + (right - left)/2;

            if(canShip(mid,days,weights)){
               right = mid;
            }else{
                left = mid + 1;
            }
        }
        return right;
    }

    public boolean canShip(int mid, int days, int[] weights){
        int sum = 0; 
        int numOfDays = 1;
        for(int i = 0; i < weights.length; i++){
            if(sum + weights[i] > mid){
                numOfDays++;
                sum = 0;
            }
            sum = sum + weights[i];
        }

        return numOfDays <= days; 
    }
}