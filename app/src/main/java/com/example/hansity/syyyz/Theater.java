package com.example.hansity.syyyz;

/**
 * Created by Hansity on 2016/5/28.
 */


public class Theater {
    private int theaterId;
    private String theaterName;
    private String theaterLocation;
    private int price;

    Theater(int theaterid , String theatername, String theaterlocation, int price) {
        this.theaterId = theaterid;
        this.theaterName = theatername;
        this.theaterLocation = theaterlocation;
        this.price  = price;
    }

    public Theater(String theaterName, String theaterLocation, int price) {
        this.theaterName = theaterName;
        this.theaterLocation = theaterLocation;
        this.price = price;
    }

    Theater() {}

    int getTheaterId() {
        return theaterId;
    }

    void setTheaterId(int theaterid) {
        theaterId = theaterid;
    }

    String getTheaterName() {
        return theaterName;
    }

    void setTheaterName(String theatername) {
        theaterName = theatername;
    }

    String getTheaterLocation() {
        return theaterLocation;
    }

    void setTheaterLocation(String theaterlocation) {
        theaterLocation = theaterlocation;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
