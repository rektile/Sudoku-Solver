package sudoku.controller;


import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.GridPane;
import sudoku.classes.Sudoku;

public class SudokuViewController {

    private static final Sudoku sudokuManager = new Sudoku();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private GridPane gridSudoku;

    @FXML
    private TextArea logTextArea;

    @FXML
    void onClickClear(ActionEvent event) {
        clearBoard();
    }

    @FXML
    void onClickSolve(ActionEvent event) {

        guiToBoard();
        if(sudokuManager.solve()){
            boardToGui();
            logText("Board solved!");
        }else {
            logText("Couldn't solve the sudoku.");
        }



    }

    @FXML
    void initialize() {
        assert gridSudoku != null : "fx:id=\"gridSudoku\" was not injected: check your FXML file 'SudokuView.fxml'.";
        assert logTextArea != null : "fx:id=\"logTextArea\" was not injected: check your FXML file 'SudokuView.fxml'.";

        initTextFormatters();

    }

    private void clearBoard(){
        for(int i = 0; i < gridSudoku.getChildren().size() - 1; i++) {
            TextArea area = (TextArea) gridSudoku.getChildren().get(i);
            area.setText("");
        }
        logText("Cleared board.");
    }

    private void boardToGui(){
        int[][] board = sudokuManager.getBoard();

        for(int row = 0; row < 9; row++) {
            for(int col = 0; col < 9; col++) {
                int number = board[row][col];
                int index = row * 9 + col;
                TextArea area = (TextArea) gridSudoku.getChildren().get(index);
                area.setText(Integer.toString(number));
            }
        }
    }

    private void guiToBoard(){
        int[][] board = new int[9][9];


        for(int i = 0; i < gridSudoku.getChildren().size() - 1; i++){
            TextArea area = (TextArea) gridSudoku.getChildren().get(i);
            int number;

            try{
                number = Integer.parseInt(area.getText());
            }catch (NumberFormatException e){
                number = 0;
            }

            int row = i / 9;
            int col = i % 9;
            board[row][col] = number;
        }

        sudokuManager.setBoard(board);
    }

    private void logText(String text){
        logTextArea.setText(text);
    }

    private void initTextFormatters(){
        for (int i = 0; i < gridSudoku.getChildren().size() - 1; i++) {
            Node node = gridSudoku.getChildren().get(i);
            if (node instanceof TextArea) {
                TextArea textArea = (TextArea) node;
                TextFormatter filter = getNumberOnlyFormatter();
                textArea.setTextFormatter(filter);
            }
        }
    }

    private TextFormatter getNumberOnlyFormatter(){
        UnaryOperator<TextFormatter.Change> filter = change -> {
            String newChar = change.getText();
            String fullString = change.getControlNewText();

            if(fullString.length() <= 1 && newChar.matches("[0-9]")){
                return change;
            }else if(newChar.equals("")){
                return change;
            }else {
                return null;
            }

        };

        return new TextFormatter<>(filter);
    }

}
