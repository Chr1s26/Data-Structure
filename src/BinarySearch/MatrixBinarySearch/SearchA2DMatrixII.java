public class SearchA2DMatrixII{

    public static void main(String[] args){
        System.out.print(searchMatrix(new int[][]{{-5}}, -10));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length - 1;

        while(row < matrix.length && col >= 0){
            if(matrix[row][col] == target){
                return true;
            }else if(matrix[row][col] > target){
                col--;
            }else{
                row++;
            }
        }

        return false;
    }
}