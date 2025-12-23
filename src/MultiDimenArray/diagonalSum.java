public class diagonalSum{
    public static void main(String[] args){
        System.out.print(sum(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
    }

    public static int sum(int[][] mat){
        if(mat.length == 1 && mat[0].length == 1) return mat[0][0];
        int j = mat.length - 1;
        int sum = 0;
        for(int i = 0; i < mat.length; i++){
            sum += mat[i][i];
            if(i != j) sum += mat[i][j];
            j--;
        }
        return sum;
    }
}