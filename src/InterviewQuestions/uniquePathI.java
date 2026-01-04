public class uniquePathI{
    public static void main(String[] args){

    }

    public static int uniquePaths(int m, int n) {
        int[][] temp = new int[m][n];
        temp[m-1][n-1] = 1;

        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){

                if(i == m-1 && j == n-1)continue;

                int down = 0;
                int right = 0;
                
                if(i + 1 <= m - 1){
                    down = temp[i+1][j];
                }
                if(j + 1 <= n - 1){
                    right = temp[i][j+1];
                }

                temp[i][j] = right + down;

            }
        }

        return temp[0][0];
    }
}