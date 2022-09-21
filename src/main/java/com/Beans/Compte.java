package com.Beans;

public class Compte {
    protected int idCompte;
    protected String numerosCompte;
    protected double solde;

    protected int client;

    public Compte(int idCompte, String numerosCompte, double solde, int client) {
        this.idCompte = idCompte;
        this.numerosCompte = numerosCompte;
        this.solde = solde;
        this.client = client;
    }


    @Override
    public String toString() {
        return "Compte{" +
                "idCompte=" + idCompte +
                ", numerosCompte=" + numerosCompte +
                ", solde=" + solde +
                //", client=" + client +
                '}';
    }

    public void crediterCompte(double montant) {
        this.solde += montant;
    }

    public int getIdCompte() {
        return idCompte;
    }

    public void setIdCompte(int idCompte) {
        this.idCompte = idCompte;
    }

    public String getNumerosCompte() {
        return numerosCompte;
    }

    public void setNumerosCompte(String numerosCompte) {
        this.numerosCompte = numerosCompte;
    }

    public double getSolde() {
        if (this.solde <0){
            System.out.println("Attention vous êtes a dévouvert !");
        }
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public int getIdClient() {
        return client;
    }
}
