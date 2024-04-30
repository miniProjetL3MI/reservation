package com.reservation.app;

import android.os.Parcel;
import android.os.Parcelable;

public class AssistanteMedicale implements Parcelable {

    public int getIdAssisstante() {
        return idAssistante;
    }

    public void setIdAssisstante(int idAssisstante) {
        this.idAssistante = idAssisstante;
    }

    public String getNomAssisstante() {
        return nomAssistante;
    }

    public void setNomAssisstante(String nomAssisstante) {
        this.nomAssistante = nomAssisstante;
    }

    public String getPrenomAssisstante() {
        return prenomAssistante;
    }

    public void setPrenomAssisstante(String prenomAssisstante) {
        this.prenomAssistante = prenomAssisstante;
    }

    public String getEmailAssisstante() {
        return emailAssistante;
    }

    public void setEmailAssisstante(String emailAssisstante) {
        this.emailAssistante = emailAssisstante;
    }

    public String getMdpAssisstante() {
        return mdpAssistante;
    }

    public void setMdpAssisstante(String mdpAssisstante) {
        this.mdpAssistante = mdpAssisstante;
    }

    private int idAssistante;
    private String nomAssistante;
    private String prenomAssistante;
    private String emailAssistante;
    private String mdpAssistante;


    protected AssistanteMedicale(Parcel in) {
        idAssistante = in.readInt();
        nomAssistante = in.readString();
        prenomAssistante = in.readString();
        emailAssistante = in.readString();
        mdpAssistante = in.readString();
    }
    public AssistanteMedicale(){

    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(idAssistante);
        dest.writeString(nomAssistante);
        dest.writeString(prenomAssistante);
        dest.writeString(emailAssistante);
        dest.writeString(mdpAssistante);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<AssistanteMedicale> CREATOR = new Creator<AssistanteMedicale>() {
        @Override
        public AssistanteMedicale createFromParcel(Parcel in) {
            return new AssistanteMedicale(in);
        }

        @Override
        public AssistanteMedicale[] newArray(int size) {
            return new AssistanteMedicale[size];
        }
    };
}