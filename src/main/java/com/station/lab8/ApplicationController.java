package com.station.lab8;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.ResourceBundle;

public class ApplicationController implements Initializable {
    @FXML ComboBox<Integer> countOfCashRegisters;
    @FXML ComboBox<Integer> countOfEntrances;

    ObservableList<Integer> valueOfComboBox = FXCollections.observableArrayList(1, 2, 3, 4, 5);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        countOfCashRegisters.setItems(valueOfComboBox);
        countOfEntrances.setItems(valueOfComboBox);

    }
}
