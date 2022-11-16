package com.station.lab8;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class LogWrapper {
    private final SimpleIntegerProperty id;
    private final SimpleStringProperty text;


    LogWrapper() {
        this.id = new SimpleIntegerProperty();

        this.text = new SimpleStringProperty();
    }

    LogWrapper(Integer number, String text) {
        this();
        this.id.set(number);
        this.text.set(text);
    }

    public void setId(Integer id) {
        this.id.set(id);
    }

    public void setText(String text) {
        this.text.set(text);
    }

    public Integer getId() {
        return this.id.get();
    }

    public String getText() {
        return this.text.get();
    }
}
