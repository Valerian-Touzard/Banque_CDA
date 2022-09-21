package com.Beans;

import java.util.ArrayList;

public class Conseiller extends Client{

    protected ArrayList<Client> listClient = new ArrayList<>();

    public Conseiller(String nom, String prenom, String adresse, String email, int age, int idClient,ArrayList<Compte>listCompte) {
        super(nom, prenom, adresse, email, age, idClient,listCompte);
        this.listClient = listClient;
    }


    public ArrayList<Client> getListClient() {
        return listClient;
    }

    public void setListClient(ArrayList<Client> listClient) {
        this.listClient = listClient;
    }
}
