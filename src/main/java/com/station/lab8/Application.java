package com.station.lab8;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.*;

public class Application extends javafx.application.Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1350, 550);
        stage.setTitle("Lab08!");
        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) throws InterruptedException {
        launch();
        PriorityQueue<ICustomer> queue = new PriorityQueue<>();
        queue.add(new Customer(1, CustomerStatus.DISABLED, null));
        queue.add(new Customer(2, CustomerStatus.REGULAR, null));
        queue.add(new Customer(3, CustomerStatus.ELDERLY, null));
        queue.add(new Customer(4, CustomerStatus.DISABLED, null));
        queue.add(new Customer(5, CustomerStatus.WITH_CHILD, null));
        queue.add(new Customer(6, CustomerStatus.REGULAR, null));


        Iterator iterator = queue.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next() + " ");
        }
        System.out.println();
        ICustomer val2 = null;
        while ((val2 = queue.poll()) != null) {
            System.out.println(val2);
        }
        List<ICashRegister> cashes = new ArrayList<>();
        cashes.add(new CashRegister(new PriorityQueue<>(), true, false, new Position(10, 0)));

        // cashes.add(new CashRegister(new PriorityQueue<>(),true,false,new Position(20,5)));
        cashes.get(0).setServiceTime(1500);
        Station st = Station.getInstance();
        st.queueResolver = new QueueResolver();
        st.setCashRegisters(cashes);
        var entrances = new ArrayList<Entrance>();

        entrances.add(new Entrance(new Position(0, 0)));
        entrances.add(new Entrance(new Position(100, 100)));
        st.entrances = entrances;
        IThreadGeneratorPeople generatorPeople = new ThreadGeneratorPeople(new IntervalGenerateStrategy(400));
        Thread generatorThread = new Thread(generatorPeople);

        generatorThread.start();
        //  cashes.forEach(x->new Thread(x).start());


        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                generatorPeople.stopGeneration();
                timer.cancel();
                timer.purge();

            }
        }, 10000);


        Thread.sleep(20000);
        var stCashes = st.getCashRegisters();
        ICustomer val;
        for (var c : stCashes) {
            System.out.println(c.getPosition().getX() + " " + c.getPosition().getY());
            val = null;
            while ((val = c.getQueue().poll()) != null) {
                System.out.println(val.getStatus() + " " + val.getStatus().ordinal() + " " + val.getTicketsCount() + " " + val.getId());
            }
        }
        st.getCashRegisters().forEach(c -> c.makeBreak());

        System.out.println("The min Priority Queue (natural ordering) contents:");


    }
}