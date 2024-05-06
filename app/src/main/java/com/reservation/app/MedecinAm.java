package com.reservation.app;

public class MedecinAm {
    private String nom;
    private String email;

    public MedecinAm(String nom, String email) {
        this.nom = nom;
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public String getEmail() {
        return email;
    }
}
