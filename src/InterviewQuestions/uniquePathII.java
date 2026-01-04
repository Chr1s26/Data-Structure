public class uniquePathII{
    public static void main(String[] args){

    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if(obstacleGrid[m-1][n-1] == 1) return 0;
        
        int[][] dp = new int[m][n];
        dp[m-1][n-1] = 1;

        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){

                if(i == m-1 && j == n-1) continue;

                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                    continue;
                }

                int right = 0;
                int down = 0;

                if(i + 1 <= m - 1){
                    down = dp[i+1][j];
                }

                if(j + 1 <= n - 1){
                    right = dp[i][j+1];
                }

                dp[i][j] = right + down;
            }
        }

        return dp[0][0];
    }
}