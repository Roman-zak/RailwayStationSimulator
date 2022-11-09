package com.station.lab8;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.util.ResourceBundle;

public class ApplicationController implements Initializable {
    @FXML ComboBox<Integer> countOfCashRegisters;
    @FXML ComboBox<Integer> countOfEntrances;
    @FXML TextField minServiceTime;
    @FXML TextField maxServiceTime;
    @FXML TextField cashRegisterDisconnection;
    @FXML TableView<EntranceWrapper> tableEntrances;
    @FXML TableColumn<EntranceWrapper, String> entrancePositionX;
    @FXML TableColumn<EntranceWrapper, String> entrancePositionY;

    ObservableList<Integer> valueOfComboBox = FXCollections.observableArrayList(1, 2, 3, 4, 5);
    ObservableList<EntranceWrapper> entrances = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        entrancePositionX.setCellValueFactory(new PropertyValueFactory<>("positionX"));
        entrancePositionY.setCellValueFactory(new PropertyValueFactory<>("positionY"));
        tableEntrances.setItems(entrances);

        countOfCashRegisters.setItems(valueOfComboBox);
        countOfEntrances.setItems(valueOfComboBox);
    }

    public void handleChangeCountOfEntrances(ActionEvent event){
        //need change count of rows in table with cash registers
        EntranceWrapper entrance = new EntranceWrapper("10", "14");
        tableEntrances.getItems().add(entrance);

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("You picked " +  countOfEntrances.getValue());
        alert.showAndWait();
    }

    public void handleChangeCountOfCashRegisters(ActionEvent event){
        //need change count of rows in table with cash registers
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("You picked " +  countOfCashRegisters.getValue());
        alert.showAndWait();
    }

    public void handleStart(ActionEvent event){
        //start of spawn customers
    }

    public void handleDisconnectCashRegister(ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("You want disconnect cash register number  " +  cashRegisterDisconnection.getText());
        alert.showAndWait();
    }
}
