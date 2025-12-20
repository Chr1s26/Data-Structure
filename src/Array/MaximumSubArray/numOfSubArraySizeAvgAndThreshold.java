public class numOfSubArraySizeAvgAndThreshold{
    public static void main(String[] args) {
        int[] arr = {2,2,2,2,5,5,5,8};
        int k = 3;
        int threshold = 4;
        //asking number of subarray whose avg is greater than or equal threshold
        System.out.println(numOfSubArray(arr,k,threshold));
        System.out.println(numOfSubArrayI(arr,k,threshold));
    }

    public static int numOfSubArrayI(int[] arr, int k, int threshold){
        int sum = 0;
        int avg = 0;
        int count = 0;

        for(int i = 0; i < k; i++){
            sum += arr[i];
        }
        int max = sum;
        avg = max / k;
        if(avg > threshold) count++;

        for(int j = k; j < arr.length; j++){
            sum += arr[j];
            sum -= arr[j-k];
            avg = sum / k;
            if(avg >= threshold) count++;
        }

        return count;
    }

    public static int numOfSubArray(int[] arr, int k, int threshold){
        int sum = 0;
        int count = 0;
        int avg = 0;

        for(int i = 0; i < k ; i++){
            sum += arr[i];
        }
        avg = sum / k;
        if(avg >= threshold){
            count++;
        }

        for(int j = k; j < arr.length; j++){
            sum += arr[j];
            sum -= arr[j-k];
            avg = sum / k;
            if(avg >= threshold){
                count++;
            }
        }

        return count;
    }
}