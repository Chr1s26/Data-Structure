public class MaxSumOfSubSequence{
    public static void main(String[] args) {
        int[] arr = {-2,-3,4,-1,-2,1,5,-3};
        // int[] arr = {-1};
        System.out.print(maxSum(arr, 0, arr.length));
    }


    public static int maxSum(int[] arr, int start, int end){
        int sum = arr[start];
        int maxSum = arr[start];
        int pointer = 0;
        // sum = -2;
        // i = 1, prev = -2, sum = -3, maxsum = -2;
        // i = 2, prev = -3, sum = 1, Maxsum = 1;
        // i = 3, prev = 4, sum = 1-1 = 0, Maxsum = 1;

        for(int i = 1; i < end; i++){
            sum += arr[i];
            if(sum < maxSum){
                sum -= arr[i-pointer];
                pointer++;
            }else{
                maxSum = sum;
            }
        }
        return maxSum;
    }

    // public static int maxSum(int[] arr, int start, int end){

    //     int maxSum = 0;

    //     if(arr.length <= 1 ) return maxSum;

    //     int sum = arr[0];
    //     int prev = 0;
        

    //     for(int i = 1; i < end; i++){
    //         prev = sum;
    //         sum += arr[i];
    //         maxSum = Math.max(prev, sum);
    //         sum = maxSum;
    //     }
    //     return maxSum;

    // }
}

// maxSum = -2
// sum = -2 + -3 = -5
//maxSum = -2
//sum = -2 + 4 = 2
// maxSum = 2
//-1, -2, 1
//sum = 2 + 1 = 3
//maxSum = 3
//sum = 3 + 5 = 8
//maxSum = 8
