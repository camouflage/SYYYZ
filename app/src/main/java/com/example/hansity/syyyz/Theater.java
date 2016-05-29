package com.example.hansity.syyyz;

/**
 * Created by Hansity on 2016/5/28.
 */


public class Theater {
    private int theaterId;
    private String theaterName;
    private String theaterLocation;

    Theater(int theaterid , String theatername, String theaterlocation) {
        theaterId = theaterid;
        theaterName = theatername;
        theaterLocation = theaterlocation;
    }

    public Theater(String theaterName, String theaterLocation) {
        this.theaterName = theaterName;
        this.theaterLocation = theaterLocation;
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
}
