package com.station.lab8;

import javafx.beans.property.SimpleStringProperty;

public class EntranceWrapper {
    private final SimpleStringProperty posX;
    private final SimpleStringProperty posY;
    public String positionX;
    public String positionY;

    public EntranceWrapper(String x, String y) {
        this.positionX = x;
        this.positionY = y;
        this.posX = new SimpleStringProperty(x);
        this.posY = new SimpleStringProperty(y);
    }

    public void setPosX(String x) {
        posX.set(x);
        positionX = x;
    }

    public void setPosY(String y) {
        posX.set(y);
        positionY = y;
    }

    public String getPosX() {
        return posX.get();
    }

    public String getPosY() {
        return posY.get();
    }
}
