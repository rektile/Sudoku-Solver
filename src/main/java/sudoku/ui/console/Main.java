package sudoku.ui.console;

import sudoku.classes.Sudoku;

public class Main {
    public static void main(String[] args) {

        Sudoku s = new Sudoku();

        s.showBoard();

        if(s.solve()){
            System.out.println("Solved:");
            s.showBoard();
        }else{
            System.out.println("Not solved");
        }



    }
}
