package com.reservation.app;

import android.os.Parcel;
import android.os.Parcelable;

public class CabinetMedicale implements Parcelable {
    public int getIdCabinet() {
        return idCabinet;
    }

    public void setIdCabinet(int idCabinet) {
        this.idCabinet = idCabinet;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    private int idCabinet;
    private String adresse;

    protected CabinetMedicale(Parcel in) {
        idCabinet = in.readInt();
        adresse = in.readString();
    }
    public CabinetMedicale(){

    }

    public static final Creator<CabinetMedicale> CREATOR = new Creator<CabinetMedicale>() {
        @Override
        public CabinetMedicale createFromParcel(Parcel in) {
            return new CabinetMedicale(in);
        }

        @Override
        public CabinetMedicale[] newArray(int size) {
            return new CabinetMedicale[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flag) {
        dest.writeInt(idCabinet);
        dest.writeString(adresse);
    }
}
