package com.example.hansity.syyyz;

/**
 * Created by YouWei on 2016/5/31.
 */
public class Seat {
    private int row ;
    private int column;

    Seat() {
        this.row = 1;
        this.column = 1;
    }

    Seat(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public  int getRow() {
        return this.row;
    }

    public int getColumn() {
        return this.column;
    }
}
