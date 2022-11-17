package com.station.lab8;

public class Entrance {
    private Position position;

    public Entrance() {
    }

    public Entrance(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "X:" + this.position.getX() + " Y:" + this.position.getY();
    }
}
