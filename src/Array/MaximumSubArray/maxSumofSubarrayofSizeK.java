public class maxSumofSubarrayofSizeK{
    public static void main(String[] args) {

        int[] arr = {2,1,5,1,3,2};
        int k = 3;
        int sum = 0;
        int max = 0;

        for(int i = 0; i < k; i++){
            sum += arr[i];
        }
        System.out.println(sum);
        max = sum;

        for(int j = k; j < arr.length; j++){
            sum += arr[j];
            sum -= arr[j-k];
            max = Math.max(sum, max);
        }

        System.out.print("Max sum of sub array is "+max);
    }
}