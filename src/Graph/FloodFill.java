import java.util.*;

public class FloodFill{
    public static void main(String[] args){
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        int sr = 1;
        int sc = 1;
        int color = 2;
        int[][] ans = floodFill(image, sr, sc, color);
        for(int i = 0; i < ans.length; i++){
            for(int j = 0; j < ans[0].length; j++){
                System.out.print(ans[i][j]);
            }
            System.out.println();
        }

        int[][] ans1 = floodFillV1(image, sr, sc, color);
        for(int i = 0; i < ans1.length; i++){
            for(int j = 0; j < ans1[0].length; j++){
                System.out.print(ans1[i][j]);
            }
            System.out.println();
        }
        
    }

    public static int[][] floodFillV1(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] != color){
            dfs(image,sr,sc,color,image[sr][sc]);
        }
        return image;
    }

    //DFS
    public static void dfs(int[][] image, int row, int col, int color, int org){
        if(row < 0 || col < 0 || row > image.length || col > image[0].length || image[row][col] != org){
            return;
        }
        image[row][col] = color;

        dfs(image,row,col+1,color,org);
        dfs(image,row,col-1,color,org);
        dfs(image,row-1,col,color,org);
        dfs(image,row+1,col,color,org);
    }


    //BFS
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean[][] visited = new boolean[image.length][image[0].length];
        Queue<List<Integer>> q = new ArrayDeque<>();
        List<Integer> temp1 = new ArrayList<>();
        int org = image[sr][sc];
        temp1.add(sr);
        temp1.add(sc);
        q.offer(temp1);
        visited[sr][sc] = true;
        image[sr][sc] = color;

        while(!q.isEmpty()){
            List<Integer> temp2 = q.poll();
            int row = temp2.get(0);
            int col = temp2.get(1);
            if(col - 1 > -1 && image[row][col - 1] == org && !visited[row][col - 1]){
                List<Integer> temp3 = new ArrayList<>();
                temp3.add(row);
                temp3.add(col-1);
                q.offer(temp3);
                image[row][col - 1] = color;
                visited[row][col - 1] = true;
            }
            if(col + 1 < image[0].length && image[row][col +1] == org && !visited[row][col + 1]){
                List<Integer> temp4 = new ArrayList<>();
                temp4.add(row);
                temp4.add(col+1);
                q.offer(temp4);
                image[row][col + 1] = color;
                visited[row][col + 1] = true;
            }
            if(row - 1 > -1 && image[row - 1][col] == org && !visited[row - 1][col]){
                List<Integer> temp5 = new ArrayList<>();
                temp5.add(row - 1);
                temp5.add(col);
                q.offer(temp5);
                image[row - 1][col] = color;
                visited[row - 1][col] = true;
            }
            if(row + 1 < image.length && image[row+1][col] == org && !visited[row+1][col]){
                List<Integer> temp6 = new ArrayList<>();
                temp6.add(row + 1);
                temp6.add(col);
                q.offer(temp6);
                image[row + 1][col] = color;
                visited[row + 1][col] = true;
            }
        }
        return image;
    }
}