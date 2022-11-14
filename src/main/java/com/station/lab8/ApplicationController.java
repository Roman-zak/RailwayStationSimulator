package com.station.lab8;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ApplicationController implements Initializable {
    @FXML
    ComboBox<Integer> countOfCashRegisters;
    @FXML
    ComboBox<Integer> countOfDisconnect;
    @FXML
    ComboBox<Integer> countOfEntrances;
    @FXML
    TableView<CashRegisterWrapper> cashRegister1;
    @FXML
    TableView<CashRegisterWrapper> cashRegister2;
    @FXML
    TableView<CashRegisterWrapper> cashRegister3;
    @FXML
    TableView<CashRegisterWrapper> cashRegister4;
    @FXML
    TableView<CashRegisterWrapper> cashRegister5;
    @FXML
    TableView<CashRegisterWrapper> cashRegisterSpare;
    @FXML
    Label labelCashRegister1;
    @FXML
    Label labelCashRegister2;
    @FXML
    Label labelCashRegister3;
    @FXML
    Label labelCashRegister4;
    @FXML
    Label labelCashRegister5;
    @FXML
    Label labelCashRegisterSpare;
    @FXML
    TextField minServiceTime;
    @FXML
    TextField maxServiceTime;
    @FXML
    TableView<EntranceWrapper> tableEntrances;
    @FXML
    TableColumn<EntranceWrapper, String> entrancePositionX;
    @FXML
    TableColumn<EntranceWrapper, String> entrancePositionY;
    ObservableList<Integer> valueOfComboBox = FXCollections.observableArrayList(1, 2, 3, 4, 5);
    ObservableList<Integer> valueOfDisconnect = FXCollections.observableArrayList();
    ObservableList<EntranceWrapper> entrances = FXCollections.observableArrayList(
    );

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        entrancePositionX.setCellValueFactory(new PropertyValueFactory<EntranceWrapper, String>("posX"));
        entrancePositionX.setCellFactory(TextFieldTableCell.forTableColumn());
        entrancePositionX.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<EntranceWrapper, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<EntranceWrapper, String> t) {
                        ((EntranceWrapper) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setPosX(t.getNewValue());
                    }
                }
        );
        entrancePositionY.setCellValueFactory(new PropertyValueFactory<EntranceWrapper, String>("posY"));
        entrancePositionY.setCellFactory(TextFieldTableCell.forTableColumn());
        entrancePositionY.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<EntranceWrapper, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<EntranceWrapper, String> t) {
                        ((EntranceWrapper) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setPosY(t.getNewValue());
                    }
                }
        );
        tableEntrances.setItems(entrances);

        countOfCashRegisters.setItems(valueOfComboBox);
        countOfEntrances.setItems(valueOfComboBox);
        countOfDisconnect.setItems(valueOfDisconnect);
    }

    public void handleChangeCountOfEntrances(ActionEvent event) {
        while (entrances.size() < countOfEntrances.getValue()) {
            entrances.add(new EntranceWrapper("0", "0"));
        }

        while (entrances.size() > countOfEntrances.getValue()) {
            entrances.remove(entrances.size() - 1);
        }


    }

    public void handleChangeCountOfCashRegisters(ActionEvent event) {
        //need change count of rows in table with cash register

        Integer count = countOfCashRegisters.getValue();

        this.cashRegister1.setVisible(true);
        this.cashRegister2.setVisible(true);
        this.cashRegister3.setVisible(true);
        this.cashRegister4.setVisible(true);
        this.cashRegister5.setVisible(true);
        this.labelCashRegister1.setVisible(true);
        this.labelCashRegister2.setVisible(true);
        this.labelCashRegister3.setVisible(true);
        this.labelCashRegister4.setVisible(true);
        this.labelCashRegister5.setVisible(true);

        if (count < 5) {
            this.cashRegister5.setVisible(false);
            this.labelCashRegister5.setVisible(false);
        }
        if (count < 4) {
            this.cashRegister4.setVisible(false);
            this.labelCashRegister4.setVisible(false);
        }
        if (count < 3) {
            this.cashRegister3.setVisible(false);
            this.labelCashRegister3.setVisible(false);
        }
        if (count < 2) {
            this.cashRegister2.setVisible(false);
            this.labelCashRegister2.setVisible(false);
        }

        while (valueOfDisconnect.size() < count) {
            valueOfDisconnect.add(valueOfDisconnect.size() + 1);
        }

        while (valueOfDisconnect.size() > count) {
            valueOfDisconnect.remove(valueOfDisconnect.size() - 1);
        }

        countOfDisconnect.setItems(valueOfDisconnect);

//        this.cashRegisterSpare.setVisible(false);
//        this.labelCashRegisterSpare.setVisible(false);
    }

    public void handleStart(ActionEvent event) {
        //start of spawn customers
    }

    public void handleDisconnectCashRegister(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("You want disconnect cash register number  " + countOfDisconnect.getValue());
        alert.showAndWait();
    }
}
