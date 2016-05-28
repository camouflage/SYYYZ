package com.example.hansity.syyyz;

/**
 * Created by Hansity on 2016/5/28.
 */


import

public class Theater {
    private int theaterId;
    private String theaterName;
    private String theaterLocation;

    Theater(int theaterid , String theatername, String theaterlocation) {
        theaterId = theaterid;
        theaterName = theatername;
        theaterLocation = theaterlocation;
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
