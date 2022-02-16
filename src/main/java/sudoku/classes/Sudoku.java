package sudoku.classes;

public class Sudoku {
    private final int size = 9;
    //private Integer[][] board = new Integer[9][9];
    private Integer[][] board = {
            {0,0,0,8,0,0,0,0,9},
            {0,1,9,0,0,5,8,3,0},
            {0,4,3,0,1,0,0,0,7},
            {4,0,0,1,5,0,0,0,3},
            {0,0,2,7,0,4,0,1,0},
            {0,8,0,0,9,0,6,0,0},
            {0,7,0,0,0,6,3,0,0},
            {0,3,0,0,7,0,0,8,0},
            {9,0,4,5,0,0,0,0,1}
    };

    private boolean checkValid(int col, int row, int num){

        for(int i = 0;i<size;i++){
            if(this.board[row][i] == num && i != col){
                return false;
            }
        }

        for(int i = 0;i<size;i++) {
            if(this.board[i][col] == num && i != row){
                return false;
            }
        }

        int startBoxX = Math.floorDiv(row,3) * 3;
        int startBoxy = Math.floorDiv(col,3) * 3;

        for(int i = startBoxX;i<startBoxX + 3;i++){
            for(int j = startBoxy;j<startBoxy;j++){
                if(this.board[i][j] != num && (row != i && col != j)){
                    return false;
                }
            }
        }

        return false;
    }

}
