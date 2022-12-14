package com.station.lab8;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.net.URL;
import java.util.*;

public class ApplicationController implements Initializable {
    @FXML
    ComboBox<Integer> countOfCashRegisters;
    @FXML
    ComboBox<Integer> countOfEntrances;
    @FXML
    TableView<CustomerWrapper> cashRegister1;
    @FXML
    TableColumn<CustomerWrapper, Integer> cashRegister1Id;
    @FXML
    TableColumn<CustomerWrapper, Integer> cashRegister1Tickets;
    @FXML
    TableColumn<CustomerWrapper, CustomerStatus> cashRegister1Status;
    @FXML
    TableColumn<CustomerWrapper, String> cashRegister1Entrance;
    @FXML
    TableView<CustomerWrapper> cashRegister2;
    @FXML
    TableColumn<CustomerWrapper, Integer> cashRegister2Id;
    @FXML
    TableColumn<CustomerWrapper, Integer> cashRegister2Tickets;
    @FXML
    TableColumn<CustomerWrapper, CustomerStatus> cashRegister2Status;
    @FXML
    TableColumn<CustomerWrapper, String> cashRegister2Entrance;
    @FXML
    TableView<CustomerWrapper> cashRegister3;
    @FXML
    TableColumn<CustomerWrapper, Integer> cashRegister3Id;
    @FXML
    TableColumn<CustomerWrapper, Integer> cashRegister3Tickets;
    @FXML
    TableColumn<CustomerWrapper, CustomerStatus> cashRegister3Status;
    @FXML
    TableColumn<CustomerWrapper, String> cashRegister3Entrance;
    @FXML
    TableView<CustomerWrapper> cashRegister4;
    @FXML
    TableColumn<CustomerWrapper, Integer> cashRegister4Id;
    @FXML
    TableColumn<CustomerWrapper, Integer> cashRegister4Tickets;
    @FXML
    TableColumn<CustomerWrapper, CustomerStatus> cashRegister4Status;
    @FXML
    TableColumn<CustomerWrapper, String> cashRegister4Entrance;
    @FXML
    TableView<CustomerWrapper> cashRegister5;
    @FXML
    TableColumn<CustomerWrapper, Integer> cashRegister5Id;
    @FXML
    TableColumn<CustomerWrapper, Integer> cashRegister5Tickets;
    @FXML
    TableColumn<CustomerWrapper, CustomerStatus> cashRegister5Status;
    @FXML
    TableColumn<CustomerWrapper, String> cashRegister5Entrance;
    @FXML
    TableView<CustomerWrapper> cashRegisterSpare;
    @FXML
    Label labelCashRegister1;
    @FXML
    TableColumn<CustomerWrapper, Integer> cashRegisterSpareId;
    @FXML
    TableColumn<CustomerWrapper, Integer> cashRegisterSpareTickets;
    @FXML
    TableColumn<CustomerWrapper, CustomerStatus> cashRegisterSpareStatus;
    @FXML
    TableColumn<CustomerWrapper, String> cashRegisterSpareEntrance;
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
    TextField ????pacityStation;
    @FXML
    TextField intervalStation;
    @FXML
    TextField maxServiceTime;
    @FXML
    TextField cashRegisterDisconnection;
    @FXML
    TableView<EntranceWrapper> tableEntrances;
    @FXML
    TableView<CashRegisterWrapper> tableCashRegisters;
    @FXML
    TableView<LogWrapper> tableLoggers;
    @FXML
    TableColumn<CashRegisterWrapper, String> cashRegisterPositionX;
    @FXML
    TableColumn<CashRegisterWrapper, String> cashRegisterPositionY;
    @FXML
    TableColumn<CashRegisterWrapper, Boolean> cashRegisterReserved;
    @FXML
    TableColumn<CashRegisterWrapper, Boolean> cashRegisterServiceable;
    @FXML
    TableColumn<EntranceWrapper, String> entrancePositionX;
    @FXML
    TableColumn<EntranceWrapper, String> entrancePositionY;
    @FXML
    TableColumn<LogWrapper, Integer> loggerViewId;
    @FXML
    TableColumn<LogWrapper, String> loggerViewText;
    @FXML
    ComboBox<Integer> countOfDisconnect;

    ObservableList<Integer> valueOfComboBox = FXCollections.observableArrayList(1, 2, 3, 4, 5);
    ObservableList<Integer> valueOfDisconnect = FXCollections.observableArrayList();
    ObservableList<CustomerWrapper> customersCashRegister1 = FXCollections.observableArrayList();
    ObservableList<CustomerWrapper> customersCashRegister2 = FXCollections.observableArrayList();
    ObservableList<CustomerWrapper> customersCashRegister3 = FXCollections.observableArrayList();
    ObservableList<CustomerWrapper> customersCashRegister4 = FXCollections.observableArrayList();
    ObservableList<CustomerWrapper> customersCashRegister5 = FXCollections.observableArrayList();
    ObservableList<CustomerWrapper> customersCashRegisterSpare = FXCollections.observableArrayList();

    ObservableList<EntranceWrapper> entrances = FXCollections.observableArrayList(
            new EntranceWrapper("0", "0"),
            new EntranceWrapper("1", "2")
    );

    ObservableList<CashRegisterWrapper> cashRegisters = FXCollections.observableArrayList(
            new CashRegisterWrapper("0", "0", true, true),
            new CashRegisterWrapper("1", "1", false, false)
    );

    ObservableList<LogWrapper> valueOfLogger = FXCollections.observableArrayList();
    //
    Station station;
    ThreadGeneratorPeople generatorPeople;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        this.cashRegister1Id.setCellValueFactory(new PropertyValueFactory<CustomerWrapper, Integer>("id"));
        this.cashRegister1Tickets.setCellValueFactory(new PropertyValueFactory<CustomerWrapper, Integer>("ticketsCount"));
        this.cashRegister1Status.setCellValueFactory(new PropertyValueFactory<CustomerWrapper, CustomerStatus>("status"));
        this.cashRegister1Entrance.setCellValueFactory(new PropertyValueFactory<CustomerWrapper, String>("entrance"));
        this.cashRegister1.setItems(this.customersCashRegister1);

        this.cashRegister2Id.setCellValueFactory(new PropertyValueFactory<CustomerWrapper, Integer>("id"));
        this.cashRegister2Tickets.setCellValueFactory(new PropertyValueFactory<CustomerWrapper, Integer>("ticketsCount"));
        this.cashRegister2Status.setCellValueFactory(new PropertyValueFactory<CustomerWrapper, CustomerStatus>("status"));
        this.cashRegister2Entrance.setCellValueFactory(new PropertyValueFactory<CustomerWrapper, String>("entrance"));
        this.cashRegister2.setItems(this.customersCashRegister2);

        this.cashRegister3Id.setCellValueFactory(new PropertyValueFactory<CustomerWrapper, Integer>("id"));
        this.cashRegister3Tickets.setCellValueFactory(new PropertyValueFactory<CustomerWrapper, Integer>("ticketsCount"));
        this.cashRegister3Status.setCellValueFactory(new PropertyValueFactory<CustomerWrapper, CustomerStatus>("status"));
        this.cashRegister3Entrance.setCellValueFactory(new PropertyValueFactory<CustomerWrapper, String>("entrance"));
        this.cashRegister3.setItems(this.customersCashRegister3);

        this.cashRegister4Id.setCellValueFactory(new PropertyValueFactory<CustomerWrapper, Integer>("id"));
        this.cashRegister4Tickets.setCellValueFactory(new PropertyValueFactory<CustomerWrapper, Integer>("ticketsCount"));
        this.cashRegister4Status.setCellValueFactory(new PropertyValueFactory<CustomerWrapper, CustomerStatus>("status"));
        this.cashRegister4Entrance.setCellValueFactory(new PropertyValueFactory<CustomerWrapper, String>("entrance"));
        this.cashRegister4.setItems(this.customersCashRegister4);

        this.cashRegister5Id.setCellValueFactory(new PropertyValueFactory<CustomerWrapper, Integer>("id"));
        this.cashRegister5Tickets.setCellValueFactory(new PropertyValueFactory<CustomerWrapper, Integer>("ticketsCount"));
        this.cashRegister5Status.setCellValueFactory(new PropertyValueFactory<CustomerWrapper, CustomerStatus>("status"));
        this.cashRegister5Entrance.setCellValueFactory(new PropertyValueFactory<CustomerWrapper, String>("entrance"));
        this.cashRegister5.setItems(this.customersCashRegister5);

        this.cashRegisterSpareId.setCellValueFactory(new PropertyValueFactory<CustomerWrapper, Integer>("id"));
        this.cashRegisterSpareTickets.setCellValueFactory(new PropertyValueFactory<CustomerWrapper, Integer>("ticketsCount"));
        this.cashRegisterSpareStatus.setCellValueFactory(new PropertyValueFactory<CustomerWrapper, CustomerStatus>("status"));
        this.cashRegisterSpareEntrance.setCellValueFactory(new PropertyValueFactory<CustomerWrapper, String>("entrance"));
        this.cashRegisterSpare.setItems(this.customersCashRegisterSpare);

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
        loggerViewId.setCellValueFactory(new PropertyValueFactory<LogWrapper, Integer>("id"));
        loggerViewText.setCellValueFactory(new PropertyValueFactory<LogWrapper, String>("text"));

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
                        System.out.println("pos");
                        ((CashRegisterWrapper) t.getTableView().getItems().get(

                                t.getTablePosition().getRow())
                        ).setPosY(t.getNewValue());
                    }
                }
        );

        cashRegisterReserved.setCellFactory(tc -> new CheckBoxTableCell<>());
        cashRegisterReserved.setCellValueFactory(c -> new SimpleBooleanProperty(c.getValue().getIsReserved()));

        cashRegisterReserved.setEditable(true);
        cashRegisterReserved.setOnEditStart(  new EventHandler<TableColumn.CellEditEvent<CashRegisterWrapper, Boolean>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<CashRegisterWrapper, Boolean> t) {
                System.out.println("reserved");
                ((CashRegisterWrapper) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                ).setIsReserved(t.getNewValue());
            }
        });

        cashRegisterReserved.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<CashRegisterWrapper, Boolean>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<CashRegisterWrapper, Boolean> t) {
                        System.out.println("reserved");
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
                        System.out.println("setIsServiceable");
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
        countOfDisconnect.setItems(valueOfDisconnect);
        tableLoggers.setItems(valueOfLogger);
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

        int count = countOfCashRegisters.getValue();

        int curCount = cashRegisters.size();
        if (count > curCount) {
            for (int i = curCount; i < count; ++i) {
                cashRegisters.add(new CashRegisterWrapper(String.format("%d", i), String.format("%d", i), false, true));
            }
        } else {
            while (curCount > count) {
                cashRegisters.remove(count);
                curCount--;
            }
        }

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
    List<ObservableList<CustomerWrapper>> customersCashRegisters;
    Timer timer ;
    public void handleStart(ActionEvent event) {


        int countCash = countOfCashRegisters.getValue();
        int countEntrance = countOfEntrances.getValue();
        List<ICashRegister> cashes = new ArrayList<ICashRegister>(countCash);

       customersCashRegisters = new ArrayList<>();
        customersCashRegisters.add(this.customersCashRegister1);
        customersCashRegisters.add(this.customersCashRegister2);
        customersCashRegisters.add(this.customersCashRegister3);
        customersCashRegisters.add(this.customersCashRegister4);
        customersCashRegisters.add(this.customersCashRegister5);
        customersCashRegisters.add(this.customersCashRegisterSpare);

        //get real data from table
        //for now
        for (int i = 0; i < countCash; ++i) {
            cashes.add(new CashRegister(new Position(Integer.parseInt(cashRegisters.get(i).positionX),
                    Integer.parseInt(cashRegisters.get(i).positionY))));

        }


        var entran = new ArrayList<Entrance>(countEntrance);
        //get real data from table
        //for now
        for (int i = 0; i < countEntrance; ++i) {
            entran.add(new Entrance(new Position(Integer.parseInt(entrances.get(i).positionX),
                    Integer.parseInt(entrances.get(i).positionY))));
        }

        //add rservedCashes

        cashes.add(new CashRegister(new Position(5,5),false,true));
        // should be get from ui
        var capacity = Integer.parseInt(this.????pacityStation.getText());
        station = new Station(entran, cashes, new QueueResolver(), capacity);
        int servingTimeMin = 0;
        int servingTimeMax = 0;
        if(!this.minServiceTime.getText().equals("")) {
            servingTimeMin = Integer.parseInt(this.minServiceTime.getText());
            servingTimeMax = Integer.parseInt(this.maxServiceTime.getText());
            cashes.get(0).setServiceTime(new Random().nextInt(servingTimeMin, servingTimeMax));
        }
        //get from min and max
        if(this.intervalStation.getText().equals("")){
        //check if it is corrcet because i dont remember
            var generationStrategy = new RandomGenerateStrategy(servingTimeMin,servingTimeMax);
            generatorPeople = new ThreadGeneratorPeople(generationStrategy, station, 70);
        }
        // ?????????????????????? ????????????????   ?? ???????? ??????????????????, ???????? ???????? ?????????????? ???? ?????????????????? ?????????????????? ?? ??????????????????,
        // ???????? ???????????????????????? ????  int servingTimeMin =300;
        //        int servingTimeMax =500; ???????????? new IntervalGenerateStrategy(???? ?????????????????? ?? ????????????);

        //need add component for choosing strategy and input the interval;



        else {
            var generationStrategy = new IntervalGenerateStrategy(Integer.parseInt(this.intervalStation.getText()));
            generatorPeople = new ThreadGeneratorPeople(generationStrategy, station, 70);
        }
        ArrayList<ILogger> loggers = new ArrayList<>();

        loggers.add(new TableLogger(valueOfLogger));
        loggers.add(new ConsoleLogger());
        CashRegister.setLoggers(loggers);
        new Thread(generatorPeople).start();
        station.startWork();
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                updateTable();
            }
        },0,200);

    }

    //function for stop working
    public void handleStop(ActionEvent event) {
        station.endWork();
        generatorPeople.stopGeneration();
        timer.cancel();timer.purge();
    }

    public void handleDisconnectCashRegister(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("You want disconnect cash register number  " + countOfDisconnect.getValue());
        alert.showAndWait();
        //???????????????????? ??????????????????
        System.out.println(countOfDisconnect.getValue().intValue());
        station.useReservedCashRegister(station.getCashRegisters().get(countOfDisconnect.getValue().intValue()-1));


    }
    void updateTable(){
        System.out.println("start");
        var cashes = station.getCashRegisters();

        int cashesCount = cashes.size();
        for( int i=0;i<cashesCount-1;++i){
            if(cashes.get(i).isServiceable()){
                customersCashRegisters.get(i).clear();
                List<ICustomer> newCustomers = new ArrayList<>(cashes.get(i).getQueue());

                int finalI = i;
                newCustomers.forEach(c -> {
                    CustomerWrapper cWrapper = new CustomerWrapper(c.getId(), c.getTicketsCount(), c.getStatus(), c.getEntrance().toString());
                    customersCashRegisters.get(finalI).add(cWrapper);

                });
            }
        }
        if(cashes.get(cashesCount-1).isServiceable()&&cashes.get(cashesCount-1).isReserved()){
            customersCashRegisters.get(customersCashRegisters.size()-1).clear();
            List<ICustomer> newCustomers = new ArrayList<>(cashes.get(cashesCount-1).getQueue());

            newCustomers.forEach(c -> {
                CustomerWrapper cWrapper = new CustomerWrapper(c.getId(), c.getTicketsCount(), c.getStatus(), c.getEntrance().toString());
                customersCashRegisters.get(customersCashRegisters.size()-1).add(cWrapper);

            });
        }


        cashRegister1.refresh();

        cashRegister2.refresh();
        cashRegister3.refresh();
        cashRegister4.refresh();
        cashRegister5.refresh();
        cashRegisterSpare.refresh();
        System.out.println("end");

    }
    void timerTask(){

    }


    //???????????? ????????????, ???????? ???????? ???????????????????? ???????? ????????, ?? ???????????????????????? ???????? ?? ??????????????.
}
