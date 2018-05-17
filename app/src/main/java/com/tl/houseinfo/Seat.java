package com.tl.houseinfo;

/**
 * Created by Administrator on 2018/5/16.
 */

public class Seat {
    private int row;//真实在显示在屏幕坐位的排号
    private int column;//真实在显示在屏幕坐位号
    private int state;

    public Seat() {
    }

    public Seat(int row, int column, int state) {
        this.row = row;
        this.column = column;
        this.state = state;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
