package com.station.lab8;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class LogWrapper {
    private final SimpleIntegerProperty number;
    private final SimpleStringProperty text;

    private LogWrapper() {
        this.number = new SimpleIntegerProperty();
        this.text = new SimpleStringProperty();
    }

    LogWrapper(Integer number, String text) {
        this();
        this.number.set(number);
        this.text.set(text);
    }

    void setNumber(Integer number) {
        this.number.set(number);
    }

    void setText(String text) {
        this.text.set(text);
    }

    Integer getNumber() {
        return this.number.get();
    }

    String getText() {
        return this.text.get();
    }
}
