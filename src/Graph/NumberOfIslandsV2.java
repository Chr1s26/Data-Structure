public class NumberOfIslandsV2{
    public static void main(String[] args){
        char[][] grid = new char[][]{{'1','1','1','1','0'},
                                    {'1','1','0','1','0'},
                                    {'1','1','0','0','0'},
                                    {'0','0','0','0','0'}};
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    dfs(i,j,grid);
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    public static void dfs(int row, int col, char[][] grid){
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == '0') return;
        grid[row][col] = '0';
        dfs(row,col + 1,grid);
        dfs(row,col - 1,grid);
        dfs(row + 1,col,grid);
        dfs(row - 1,col,grid);
    }
}