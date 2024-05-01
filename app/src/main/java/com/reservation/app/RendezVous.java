package com.reservation.app;

import android.os.Parcel;
import android.os.Parcelable;

public class RendezVous implements Parcelable {
    public int getIdRDV() {
        return idRDV;
    }

    public void setIdRDV(int idRDV) {
        this.idRDV = idRDV;
    }

    public String getHeurRDV() {
        return heurRDV;
    }

    public void setHeurRDV(String heurRDV) {
        this.heurRDV = heurRDV;
    }

    public String getDateRDV() {
        return dateRDV;
    }

    public void setDateRDV(String dateRDV) {
        this.dateRDV = dateRDV;
    }

    private int idRDV;
    private String heurRDV;
    private String dateRDV;

    protected RendezVous(Parcel in) {
        idRDV = in.readInt();
        heurRDV = in.readString();
        dateRDV = in.readString();
    }
    public RendezVous(){

    }

    public static final Creator<RendezVous> CREATOR = new Creator<RendezVous>() {
        @Override
        public RendezVous createFromParcel(Parcel in) {
            return new RendezVous(in);
        }

        @Override
        public RendezVous[] newArray(int size) {
            return new RendezVous[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(idRDV);
        dest.writeString(heurRDV);
        dest.writeString(dateRDV);
    }
}
