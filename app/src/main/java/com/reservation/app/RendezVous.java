package com.reservation.app;

import android.os.Parcel;
import android.os.Parcelable;

public class RendezVous implements Parcelable {
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
    public void writeToParcel(Parcel dest, int flag) {
        dest.writeInt(idRDV);
        dest.writeString(heurRDV);
        dest.writeString(dateRDV);
    }
}
