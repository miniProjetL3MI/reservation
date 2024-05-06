package com.reservation.app;
import android.os.Parcel;
import android.os.Parcelable;
public class Medecin implements Parcelable{
    public Medecin() {
        // Constructeur par défaut
    }

    public int getIdMedecin() {
        return idMedecin;
    }

    public void setIdMedecin(int idMedecin) {
        this.idMedecin = idMedecin;
    }

    public String getNomMedecin() {
        return nomMedecin;
    }

    public void setNomMedecin(String nomMedecin) {
        this.nomMedecin = nomMedecin;
    }

    public String getPrenomMedecin() {
        return prenomMedecin;
    }

    public void setPrenomMedecin(String prenomMedecin) {
        this.prenomMedecin = prenomMedecin;
    }

    public String getEmailMedecin() {
        return emailMedecin;
    }

    public void setEmailMedecin(String emailMedecin) {
        this.emailMedecin = emailMedecin;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public String getHeurOuverture() {
        return heurOuverture;
    }

    public void setHeurOuverture(String heurOuverture) {
        this.heurOuverture = heurOuverture;
    }

    public String getHeurFermeture() {
        return heurFermeture;
    }

    public void setHeurFermeture(String heurFermeture) {
        this.heurFermeture = heurFermeture;
    }

    public String getJourTravail() {
        return jourTravail;
    }

    public void setJourTravail(String jourTravail) {
        this.jourTravail = jourTravail;
    }

    private int idMedecin;
    private String nomMedecin;
    private String prenomMedecin;
    private String emailMedecin;
    private String numTel;
    private String specialite;
    private String heurOuverture;
    private String heurFermeture;
    private String jourTravail;

    public Medecin(Parcel in){
        idMedecin=in.readInt();
        nomMedecin=in.readString();
        prenomMedecin=in.readString();
        emailMedecin=in.readString();
        numTel=in.readString();
        specialite=in.readString();
        heurOuverture=in.readString();
        heurFermeture=in.readString();
        jourTravail=in.readString();

    }
    public Medecin(String abbiJohnson, String mail){

    }


    public static final Creator<Medecin> CREATOR = new Creator<Medecin>() {
        @Override
        public Medecin createFromParcel(Parcel in) {
            return new Medecin(in);
        }

        @Override
        public Medecin[] newArray(int size) {
            return new Medecin[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(idMedecin);
        dest.writeString(nomMedecin);
        dest.writeString(prenomMedecin);
        dest.writeString(emailMedecin);
        dest.writeString(numTel);
        dest.writeString(specialite);
        dest.writeString(heurOuverture);
        dest.writeString(heurFermeture);
        dest.writeString(jourTravail);


    }

}
