package com.reservation.app;

public class RendezVousAm {
    private int imageResource;
    private String name;
    private String date;
    private String time;

    public RendezVousAm(int imageResource, String name, String date, String time) {
        this.imageResource = imageResource;
        this.name = name;
        this.date = date;
        this.time = time;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }
}

