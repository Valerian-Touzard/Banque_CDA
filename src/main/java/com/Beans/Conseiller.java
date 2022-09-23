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

    public void ajouterClient(Client newClient) {
        this.listClient.add(newClient);
    }

    public void afficherTousLesClients() {
        for (int i = 0; i < this.listClient.size(); i++) {
            System.out.println("Client n°"+(i+1)+": "+this.listClient.get(i));
        }
    }

    public boolean estPresent(String nomClient) {
        boolean isFind = false;
        for (int i = 0; i < this.listClient.size(); i++) {
            if (listClient.get(i).nom.equals(nomClient)){
                isFind = true;
            }
        }
        return isFind;
    }

    public Client getClientByName(String nomClient) {
        Client client = new Client();
        for (int i = 0; i < this.listClient.size(); i++) {
            if (this.listClient.get(i).nom.equals(nomClient)){
                client = this.listClient.get(i);
            }
        }
        return client;
    }

    public void delCompteByNum(Client clienAModif, String numCompteASupp) {
        for (int i = 0; i < clienAModif.listCompte.size(); i++) {
            if (clienAModif.listCompte.get(i).numerosCompte.equals(numCompteASupp)){
                clienAModif.listCompte.remove(i);
            }
        }
    }

    public void delClientByName(String nomClient) {
        for (int i = 0; i < this.listClient.size(); i++) {
            if (this.listClient.get(i).nom.equals(nomClient)){
                this.listClient.remove(i);
            }
        }
    }
}
