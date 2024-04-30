package com.reservation.app;

import android.os.Parcel;
import android.os.Parcelable;

public class Admin implements Parcelable {

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getNomAdmin() {
        return nomAdmin;
    }

    public void setNomAdmin(String nomAdmin) {
        this.nomAdmin = nomAdmin;
    }

    public String getPrenomAdmin() {
        return prenomAdmin;
    }

    public void setPrenomAdmin(String prenomAdmin) {
        this.prenomAdmin = prenomAdmin;
    }

    public String getEmailAdmin() {
        return emailAdmin;
    }

    public void setEmailAdmin(String emailAdmin) {
        this.emailAdmin = emailAdmin;
    }

    public String getMdpAdmin() {
        return mdpAdmin;
    }

    public void setMdpAdmin(String mdpAdmin) {
        this.mdpAdmin = mdpAdmin;
    }

    private int idAdmin;
    private String nomAdmin;
    private String prenomAdmin;
    private String emailAdmin;
    private String mdpAdmin;

    protected Admin(Parcel in) {
        idAdmin = in.readInt();
        nomAdmin = in.readString();
        prenomAdmin = in.readString();
        emailAdmin = in.readString();
        mdpAdmin = in.readString();
    }
    public Admin(){

    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(idAdmin);
        dest.writeString(nomAdmin);
        dest.writeString(prenomAdmin);
        dest.writeString(emailAdmin);
        dest.writeString(mdpAdmin);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Admin> CREATOR = new Creator<Admin>() {
        @Override
        public Admin createFromParcel(Parcel in) {
            return new Admin(in);
        }

        @Override
        public Admin[] newArray(int size) {
            return new Admin[size];
        }
    };
}