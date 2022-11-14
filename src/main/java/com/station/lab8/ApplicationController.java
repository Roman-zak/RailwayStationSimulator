package com.station.lab8;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import javax.security.auth.callback.Callback;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ApplicationController implements Initializable {
    @FXML ComboBox<Integer> countOfCashRegisters;
    @FXML ComboBox<Integer> countOfEntrances;
    @FXML TableView<CashRegisterWrapper> cashRegister1;
    @FXML TableView<CashRegisterWrapper> cashRegister2;
    @FXML TableView<CashRegisterWrapper> cashRegister3;
    @FXML TableView<CashRegisterWrapper> cashRegister4;
    @FXML TableView<CashRegisterWrapper> cashRegister5;
    @FXML TableView<CashRegisterWrapper> cashRegisterSpare;
    @FXML Label labelCashRegister1;
    @FXML Label labelCashRegister2;
    @FXML Label labelCashRegister3;
    @FXML Label labelCashRegister4;
    @FXML Label labelCashRegister5;
    @FXML Label labelCashRegisterSpare;
    @FXML TextField minServiceTime;
    @FXML TextField maxServiceTime;
    @FXML TextField cashRegisterDisconnection;
    @FXML TableView<EntranceWrapper> tableEntrances;
    @FXML TableView<CashRegisterWrapper> tableCashRegisters;
    @FXML TableColumn<CashRegisterWrapper, String> cashRegisterPositionX;
    @FXML TableColumn<CashRegisterWrapper, String> cashRegisterPositionY;
    @FXML TableColumn<CashRegisterWrapper, Boolean> cashRegisterReserved;
    @FXML TableColumn<CashRegisterWrapper, Boolean> cashRegisterServiceable;
    @FXML TableColumn<EntranceWrapper, String> entrancePositionX;
    @FXML TableColumn<EntranceWrapper, String> entrancePositionY;

    ObservableList<Integer> valueOfComboBox = FXCollections.observableArrayList(1, 2, 3, 4, 5);
    ObservableList<EntranceWrapper> entrances = FXCollections.observableArrayList(
            new EntranceWrapper("0","0"),
            new EntranceWrapper("1","2")
    );

    ObservableList<CashRegisterWrapper> cashRegisters = FXCollections.observableArrayList(
            new CashRegisterWrapper("0", "0", true, true),
            new CashRegisterWrapper("1", "1", false, false)
    );

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        entrancePositionX.setCellValueFactory(new PropertyValueFactory<EntranceWrapper, String>("posX"));
        entrancePositionY.setCellValueFactory(new PropertyValueFactory<EntranceWrapper, String>("posY"));
        tableEntrances.setItems(entrances);

        cashRegisterPositionX.setEditable(true);
        cashRegisterPositionX.setCellFactory(TextFieldTableCell.forTableColumn());
        cashRegisterPositionX.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<CashRegisterWrapper, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<CashRegisterWrapper, String> t) {
                        ((CashRegisterWrapper) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setPosX(t.getNewValue());
                    }
                }
        );

        cashRegisterPositionY.setEditable(true);
        cashRegisterPositionY.setCellFactory(TextFieldTableCell.forTableColumn());
        cashRegisterPositionY.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<CashRegisterWrapper, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<CashRegisterWrapper, String> t) {
                        ((CashRegisterWrapper) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setPosY(t.getNewValue());
                    }
                }
        );

        cashRegisterReserved.setCellValueFactory(c -> new SimpleBooleanProperty(c.getValue().getIsReserved()));
        cashRegisterReserved.setCellFactory(tc -> new CheckBoxTableCell<>());
        cashRegisterReserved.setEditable(true);
        cashRegisterReserved.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<CashRegisterWrapper, Boolean>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<CashRegisterWrapper, Boolean> t) {
                        ((CashRegisterWrapper) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setIsReserved(t.getNewValue());
                    }
                }
        );

        cashRegisterServiceable.setCellValueFactory(c -> new SimpleBooleanProperty(c.getValue().getIsServiceable()));
        cashRegisterServiceable.setCellFactory(tc -> new CheckBoxTableCell<>());
        cashRegisterServiceable.setEditable(true);
        cashRegisterServiceable.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<CashRegisterWrapper, Boolean>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<CashRegisterWrapper, Boolean> t) {
                        ((CashRegisterWrapper) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setIsServiceable(t.getNewValue());
                    }
                }
        );

        cashRegisterPositionX.setCellValueFactory(new PropertyValueFactory<CashRegisterWrapper, String>("posX"));
        cashRegisterPositionY.setCellValueFactory(new PropertyValueFactory<CashRegisterWrapper, String>("posY"));
        cashRegisterReserved.setCellValueFactory(new PropertyValueFactory<CashRegisterWrapper, Boolean>("isReserved"));
        cashRegisterServiceable.setCellValueFactory(new PropertyValueFactory<CashRegisterWrapper, Boolean>("isServiceable"));



        tableCashRegisters.setItems(cashRegisters);

        countOfCashRegisters.setItems(valueOfComboBox);
        countOfEntrances.setItems(valueOfComboBox);
    }



    public void handleChangeCountOfEntrances(ActionEvent event){
        //need change count of rows in table with cash registers
        EntranceWrapper entrance = new EntranceWrapper("10", "14");

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("You picked " +  countOfEntrances.getValue());
        alert.showAndWait();
    }

    public void handleChangeCountOfCashRegisters(ActionEvent event){
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

        if(count < 5) {
            this.cashRegister5.setVisible(false);
            this.labelCashRegister5.setVisible(false);
        }
        if(count < 4) {
            this.cashRegister4.setVisible(false);
            this.labelCashRegister4.setVisible(false);
        }
        if(count < 3) {
            this.cashRegister3.setVisible(false);
            this.labelCashRegister3.setVisible(false);
        }
        if(count < 2) {
            this.cashRegister2.setVisible(false);
            this.labelCashRegister2.setVisible(false);
        }
//        this.cashRegisterSpare.setVisible(false);
//        this.labelCashRegisterSpare.setVisible(false);
    }

    public void handleStart(ActionEvent event){
        //start of spawn customers
    }

    public void handleDisconnectCashRegister(ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("You want disconnect cash register number  " +  cashRegisterDisconnection.getText());
        alert.showAndWait();
    }

    public void handleEntrencePositionX(ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("You want disconnect cash register number  " +  cashRegisterDisconnection.getText());
        alert.showAndWait();
    }

}
