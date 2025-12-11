public class MaxSumOfRectangle{
    public static void main(String[] args) {
        int[][] arr = {{0,-2,-7,0},{9,2,-6,2},{-4,1,-4,1},{-1,8,0,-2}};
        int maxSum = maxSum(arr);
        System.out.print(maxSum);
    }

    public static int maxSum(int[][] arr){
        int maxSum = Integer.MIN_VALUE;
        
        int rows = arr.length;
        int cols = arr[0].length;

        for(int top = 0; top < rows; top++){
            int[] colArr = new int[cols];
            
            for(int bottom = top; bottom < rows; bottom++){
                for(int c = 0; c < cols; c++){
                    colArr[c] += arr[bottom][c];
                }
                int best = Kadane(colArr);
                maxSum = Math.max(maxSum, best);
            }
        }
        return maxSum;
    }

    public static int Kadane(int[] matrix){
        int maxSum = matrix[0];
        int curr = matrix[0];

        for(int i = 1; i < matrix.length; i++){
            curr = Math.max(matrix[i], curr + matrix[i]);
            maxSum = Math.max(curr, maxSum);
        }
        return maxSum;
    }
}
