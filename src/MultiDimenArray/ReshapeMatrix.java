public class ReshapeMatrix{
    public static void main(String[] args){

    }

    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        int n = mat.length;
        int m = mat[0].length;
        if(n * m != r * c) return mat;

        int[][] newArr = new int[r][c];
        int row = 0;
        int col = 0;

        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                newArr[row][col] = mat[i][j];
                col++;
                if(col == c){
                    col = 0;
                    row++;
                }
            }
        }

        return newArr;
    }
}