package com.station.lab8;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.*;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws InterruptedException {
        launch();
        PriorityQueue<ICustomer> queue = new PriorityQueue<>(new Comparator<ICustomer>() {
            public int compare(ICustomer n1, ICustomer n2) {


               return n1.getStatus().compareTo(n2.getStatus());
            }
        });
        queue.add(new Customer(1,CustomerStatus.DISABLED,null));
        queue.add(new Customer(2,CustomerStatus.REGULAR,null));
        queue.add(new Customer(3,CustomerStatus.ELDERLY,null));
        queue.add(new Customer(4,CustomerStatus.DISABLED,null));
        queue.add(new Customer(5,CustomerStatus.WITH_CHILD,null));
        queue.add(new Customer(6,CustomerStatus.REGULAR,null));

        List<ICashRegister> cashes = new ArrayList<>();
        cashes.add(new CashRegister(new PriorityQueue<>(new Comparator<ICustomer>() {
            public int compare(ICustomer n1, ICustomer n2) {
                return n1.getStatus().compareTo(n2.getStatus());
            }
        }),true,false,new Position(10,0)));

        cashes.add(new CashRegister(new PriorityQueue<>(new Comparator<ICustomer>() {
            public int compare(ICustomer n1, ICustomer n2) {
                return n1.getStatus().compareTo(n2.getStatus());
            }
        }),true,false,new Position(20,5)));



        Station st =  Station.getInstance();
        st.queueResolver = new QueueResolver();
        st.setCashRegisters(cashes);
        var entrances = new ArrayList<Entrance>();

        entrances.add(new Entrance(new Position(0,0)) );
        entrances.add(new Entrance(new Position(100,100)));
        st.entrances = entrances;
        IThreadGeneratorPeople generatorPeople = new ThreadGeneratorPeople(new IntervalGenerateStrategy(400));
        Thread generatorThread = new Thread(generatorPeople);
        generatorThread.start();
       // cashes.forEach(x->new Thread(x).start());
        cashes.forEach(x->x.run());
        Timer timer2 = new Timer();
        timer2.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Cashes");
                st.getCashRegisters().forEach(x->System.out.println(x.getQueue().size()));
                System.out.println("end Cashes");

            }
        }, 0,1000);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                generatorPeople.stopGeneration();
                timer.cancel();timer.purge();

            }
        }, 15000);


        Thread.sleep(20000);
        var stCashes=st.getCashRegisters();
        for(var c: stCashes){
            System.out.println(c.getPosition().getX()+" "+c.getPosition().getY());
            ICustomer val = null;
            while( (val = c.getQueue().poll()) != null) {
                System.out.println(val.getStatus()+" "+val.getStatus().ordinal()+" "+val.getTicketsCount());
            }
        }
        st.getCashRegisters().forEach(c->c.makeBreak());
        timer2.cancel();timer2.purge();
        System.out.println("The min Priority Queue (natural ordering) contents:");





    }
}