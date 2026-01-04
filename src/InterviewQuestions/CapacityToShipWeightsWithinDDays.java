public class CapacityToShipWeightsWithinDDays{
    public static void main(String[] args){

    }

    public int shipWithinDays(int[] weights, int days) {

        int left = 0;
        int right = 0;

        for(int i = 0; i < weights.length; i++){
            left = Math.max(left,weights[i]);
            right += weights[i];
        }


        while(left < right){

            int mid = left + (right-left)/2 ;

            if(canShip(weights,days,mid)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }

        return left;
    }

    public boolean canShip(int[] weights,int days,int maxCapacity){
        int sum = 0;
        int totaldays = 1;
        for(int i = 0; i < weights.length; i++){
            sum += weights[i];
            if(sum > maxCapacity){
                totaldays++;
                sum = 0;
                sum += weights[i];
            }
        }

        return days >= totaldays;
    }
}