public class MaxSumOfSubSequence{
    public static void main(String[] args) {
        int[] arr = {-2,-3,4,-1,-2,1,5,-3};
        System.out.println(maxSumv1(arr, 0, arr.length));
        System.out.println(maxSumv2(arr, 0, arr.length));
        System.out.print(maxSumv3(arr, 0, arr.length));
    }


    public static int maxSumv3(int[] arr, int start, int end){

        long startTime = System.nanoTime();

        int current = arr[0];
        int maxSum = arr[0];

        for(int i = 1; i < arr.length; i++){
            current = Math.max(arr[i], current + arr[i]);
            maxSum = Math.max(current, maxSum);
        }
    
        long endTime = System.nanoTime();

        System.out.println("Time: " + (endTime - startTime) + " ns");
    
        return maxSum;
    }

    public static int maxSumv2(int[] arr, int start, int end){

        long startTime = System.nanoTime();

        int sum = 0;
        int maxSum = arr[start];
        int n = arr.length;

        if (n == 0) return 0;
        if (n == 1) return arr[0];


        int[] prefix = new int[n];
        prefix[0] = arr[0];

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        
        for(int i = 0; i < end; i++){
            for(int j = i; j < end; j++){
                if(i == 0) sum = prefix[j];
                else sum = prefix[j] - prefix[i-1];
                maxSum = Math.max(sum, maxSum);
            }
        }

        long endTime = System.nanoTime();

        System.out.println("Time: " + (endTime - startTime) + " ns");
    
        return maxSum;

    }


    public static int maxSumv1(int[] arr, int start, int end){

        long startTime = System.nanoTime();
        
        if(arr.length == 1) return arr[0];

        int sum = 0;
        int maxSum = arr[start];
        
        for(int i = 0; i < end-1; i++){
            sum = arr[i];
            for(int j = i+1; j < end; j++){
                sum += arr[j];
                maxSum = Math.max(sum, maxSum);
            }
        }

        long endTime = System.nanoTime();

        System.out.println("Time: " + (endTime - startTime) + " ns");
        return maxSum;
    }
}

