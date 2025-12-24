public class NumberOfIslands{
    public static void main(String[] args){
        char[][] grid = new char[][]{{'1','1','1','1','0'},
                                    {'1','1','0','1','0'},
                                    {'1','1','0','0','0'},
                                    {'0','0','0','0','0'}};
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    dfs(i,j,visited,grid);
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    public static void dfs(int row, int col, boolean[][] visited, char[][] grid){
        visited[row][col] = true;
        if(col + 1 < grid[0].length && !visited[row][col+1] && grid[row][col+1] == '1'){
            dfs(row,col+1,visited,grid);
        }
        if(col - 1 > -1 && !visited[row][col-1] && grid[row][col-1] == '1'){
            dfs(row,col-1,visited,grid);
        }
        if(row + 1 < grid.length && !visited[row+1][col] && grid[row+1][col] == '1'){
            dfs(row+1,col,visited,grid);
        }
        if(row - 1 > -1 && !visited[row-1][col] && grid[row-1][col] == '1'){
            dfs(row-1,col,visited,grid);
        }
    }
}