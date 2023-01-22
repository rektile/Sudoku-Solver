package sudoku.controller;


import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;
import java.util.regex.Pattern;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextFormatter;
import javafx.scene.input.KeyEvent;
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

    }

    @FXML
    void onClickSolve(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert gridSudoku != null : "fx:id=\"gridSudoku\" was not injected: check your FXML file 'SudokuView.fxml'.";
        assert logTextArea != null : "fx:id=\"logTextArea\" was not injected: check your FXML file 'SudokuView.fxml'.";

        for (int i = 0; i < gridSudoku.getChildren().size(); i++) {
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
