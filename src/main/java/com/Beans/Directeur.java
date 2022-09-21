package com.Beans;

import java.util.ArrayList;

public class Directeur extends Conseiller{

    protected ArrayList<Conseiller> listConseiller = new ArrayList<>();

    public Directeur(String nom, String prenom, String adresse, String email, int age, int idClient,ArrayList<Compte> listCompte, ArrayList<Conseiller> listConseiller) {
        super(nom, prenom, adresse, email, age, idClient,listCompte);
        this.listConseiller = listConseiller;
    }

    public ArrayList<Conseiller> getListConseiller() {
        return listConseiller;
    }

    public void setListConseiller(ArrayList<Conseiller> listConseiller) {
        this.listConseiller = listConseiller;
    }
}
