package com.reservation.app;

import android.os.Parcel;
import android.os.Parcelable;

public class Patient implements Parcelable {
    public int getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(int idPatient) {
        this.idPatient = idPatient;
    }

    public String getNomPatient() {
        return nomPatient;
    }

    public void setNomPatient(String nomPatient) {
        this.nomPatient = nomPatient;
    }

    public String getPrenomPatient() {
        return prenomPatient;
    }

    public void setPrenomPatient(String prenomPatient) {
        this.prenomPatient = prenomPatient;
    }

    public String getEmailPatient() {
        return emailPatient;
    }

    public void setEmailPatient(String emailPatient) {
        this.emailPatient = emailPatient;
    }

    public String getMdpPatient() {
        return mdpPatient;
    }

    public void setMdpPatient(String mdpPatient) {
        this.mdpPatient = mdpPatient;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    private int idPatient;
    private String nomPatient;
    private String prenomPatient;
    private String emailPatient;
    private String mdpPatient;
    private String dateNaissance;


    protected Patient(Parcel in) {
        idPatient = in.readInt();
        nomPatient = in.readString();
        prenomPatient = in.readString();
        emailPatient = in.readString();
        mdpPatient = in.readString();
        dateNaissance = in.readString();
    }
    public Patient(){

    }

    public static final Creator<Patient> CREATOR = new Creator<Patient>() {
        @Override
        public Patient createFromParcel(Parcel in) {
            return new Patient(in);
        }

        @Override
        public Patient[] newArray(int size) {
            return new Patient[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flag) {
        dest.writeInt(idPatient);
        dest.writeString(nomPatient);
        dest.writeString(prenomPatient);
        dest.writeString(emailPatient);
        dest.writeString(mdpPatient);
        dest.writeString(dateNaissance);


    }
}
