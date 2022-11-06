package com.station.lab8;

public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position() {
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int Distance(Position position){
        return (int) (this.x- position.x)*(this.x- position.x) + (this.y- position.y)*(this.y- position.y);
    }
}
