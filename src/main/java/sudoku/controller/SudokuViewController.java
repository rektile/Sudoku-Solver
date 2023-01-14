package sudoku.controller;

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

    }

    @FXML
    void initialize() {
        assert gridSudoku != null : "fx:id=\"gridSudoku\" was not injected: check your FXML file 'SudokuView.fxml'.";

    }
}