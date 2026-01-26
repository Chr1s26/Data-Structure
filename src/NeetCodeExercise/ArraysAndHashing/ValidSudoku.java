import java.util.*;

public class ValidSudoku{
        public boolean isValidSudoku(char[][] board) {
        // time complexity is O(1)
        // space complexity is O(1)
        // because only 3 x 3 subboxes not n
        
        //check every row
        for(int i = 0; i < board.length; i++){
            HashSet<Character> set = new HashSet<>();
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] != '.'){
                    if(!set.add(board[i][j])) return false;
                }
            }
        }

        //check every column
        for(int i = 0; i < board[0].length; i++){
            HashSet<Character> set = new HashSet<>();
            for(int j = 0; j < board.length; j++){
                if(board[j][i] != '.'){
                    if(!set.add(board[j][i])) return false;
                }
            }
        }

        //check each subBoxes
        for(int row = 0; row < 9; row += 3){
            for(int col = 0; col < 9; col += 3){
                HashSet<Character> set = new HashSet<>();
                for(int i = row; i < row + 3; i++){
                    for(int j = col; j < col + 3; j++){
                        if(board[i][j] != '.'){
                            if(!set.add(board[i][j])) return false;
                        }
                    }
                }
            }
        }

        return true;
    }

    public boolean isValidSudokuV2(char[][] board) {
                // time complexity is O(1)
        // space complexity is O(1)
        // because only 3 x 3 subboxes not n

        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.'){
                    int num = board[i][j] - '1';
                    int boxIndex = ((i / 3) * 3) + (j/3);

                    if(row[i][num] || col[j][num] || boxes[boxIndex][num]){
                        return false;
                    }

                    row[i][num] = col[j][num] = boxes[boxIndex][num] = true;
                }
            }
        }

        return true;
    }
}