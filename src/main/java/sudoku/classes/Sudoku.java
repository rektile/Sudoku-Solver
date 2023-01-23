package sudoku.classes;

public class Sudoku {
    private final int size = 9;
    //private Integer[][] board = new Integer[9][9];
    private int[][] board = {
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

    public int[][] getBoard(){
        return this.board;
    }

    public void setBoard(int[][] newBoard){
        this.board = newBoard;
    }

    private boolean checkValid(int row, int col, int num){

        for(int i = 0;i<this.size;i++){
            if(this.board[row][i] == num && i != col){
                return false;
            }
        }

        for(int i = 0;i<this.size;i++) {
            if(this.board[i][col] == num && i != row){
                return false;
            }
        }

        int startBoxX = Math.floorDiv(row,3) * 3;
        int startBoxy = Math.floorDiv(col,3) * 3;

        for(int i = startBoxX;i<startBoxX + 3;i++){
            for(int j = startBoxy;j<startBoxy + 3;j++){
                if(this.board[i][j] == num && (row != i && col != j)){
                    return false;
                }
            }
        }

        return true;
    }

    public int[] findNextEmpty(){
        for(int i = 0;i<this.size;i++) {
            for(int j = 0;j<this.size;j++) {
                if(this.board[i][j] == 0){
                    return new int[]{i, j};
                }
            }
        }

        return null;
    }

    public boolean solve(){
        int[] nextEmpty = this.findNextEmpty();
        if(nextEmpty == null){
            return true;
        }

        int row = nextEmpty[0];
        int col = nextEmpty[1];

        for(int i = 1;i<10;i++){
            if(this.checkValid(row,col,i)){
                this.board[row][col] = i;

                if(solve()){
                    return true;
                }

                this.board[row][col] = 0;
            }
        }

        return false;
    }

    public void showBoard(){
        for(int i = 0;i<this.size;i++){
            String line = "";
            if(i % 3 == 0 && i != 0){
                System.out.println("----------------------------------");
            }

            for(int j = 0;j<this.size;j++){

                if(j % 3 == 0 && j != 0){
                    line += " | ";
                }


                line += String.format(" %d ",this.board[i][j]);
            }

            System.out.println(line);
        }
    }

}
