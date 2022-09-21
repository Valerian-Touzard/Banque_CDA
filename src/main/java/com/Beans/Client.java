package com.Beans;

import java.util.ArrayList;

public class Client {
//    Attributs
    protected int idClient;
    protected String nom;
    protected String prenom;
    protected String adresse;
    protected String email;
    protected int age;
    protected ArrayList<Compte> listCompte = new ArrayList<>();


    //    Constructeur
    public Client(String nom, String prenom, String adresse, String email, int age, int idClient,ArrayList<Compte> listCompte) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.email = email;
        this.age = age;
        this.idClient = idClient;
        this.listCompte = listCompte;
    }


    @Override
    public String toString() {
        return "Client{" +
                "idClient=" + idClient +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", listCompte=" + listCompte +
                '}';
    }


    public void ajouterCompte(Compte compte){
        this.listCompte.add(compte);
    }


    //  GETTER AND SETTER
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public ArrayList<Compte> getListCompte() {
        return listCompte;
    }
}
