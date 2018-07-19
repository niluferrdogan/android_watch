package com.example.bsobe.android_watch;

/**
 * Created by Nilufer on 17.07.2018.
 */

public class Currencies {
    private String source;
    private String sourceRate;
    public Destinations[] destinations;

    public Currencies(Destinations[] destinations) {
        this.destinations=destinations;
        source=null;
        sourceRate=null;
    }

    public void setDestinations(Destinations[] destinations) {
        this.destinations = destinations;
    }

    public Currencies() {


    }

    public Destinations[] getDestinations() {
        return destinations;
    }

    public String getSource() {
        return source;
    }

    public String getSourceRate() {
        return sourceRate;
    }

    public void set(Currencies currencies) {
        this.source=currencies.getSource();
        this.sourceRate=currencies.getSourceRate();
        this.destinations=currencies.getDestinations();
    }
}
