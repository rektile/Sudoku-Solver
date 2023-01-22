package sudoku.controller;

import javafx.scene.control.TextArea;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;

public class SudokuViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private GridPane gridSudoku;

    @FXML
    void OnFieldTyped(KeyEvent event) {
        String input = event.getCharacter();
        System.out.println(event);
        TextArea textArea = (TextArea) event.getTarget();
        String curValue = textArea.getText();
        System.out.println(curValue);
        if (input.matches("[0-9]")) {
            textArea.setText(input);
        }else{
            textArea.setText(curValue);
        }
    }

    @FXML
    void initialize() {
        assert gridSudoku != null : "fx:id=\"gridSudoku\" was not injected: check your FXML file 'SudokuView.fxml'.";

    }
}