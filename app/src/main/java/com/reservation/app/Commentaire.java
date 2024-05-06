package com.reservation.app;

public class Commentaire {
    private int imageResource;
    private String nomCommentateur;
    private String contenuCommentaire;
    private float note;

    public Commentaire(int imageResource, String nomCommentateur, String contenuCommentaire, float note) {
        this.imageResource = imageResource;
        this.nomCommentateur = nomCommentateur;
        this.contenuCommentaire = contenuCommentaire;
        this.note = note;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getNomCommentateur() {
        return nomCommentateur;
    }

    public String getContenuCommentaire() {
        return contenuCommentaire;
    }

    public float getNote() {
        return note;
    }
}
