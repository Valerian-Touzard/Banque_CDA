package com.Beans;

import java.lang.ref.Cleaner;

public class CompteEpargne extends Compte{

    protected double soldeMax;

    public CompteEpargne(int idCompte, String numerosCompte, double solde, int idClient) {
        super(idCompte, numerosCompte, solde, idClient);
        this.soldeMax = 7000;
    }

    @Override
    public String toString() {
        return "CompteEpargne{" +
                "soldeMax=" + soldeMax +
                ", idCompte=" + idCompte +
                ", numerosCompte=" + numerosCompte +
                ", solde=" + solde +
               // ", client=" + client +
                '}';
    }

    public double getSoldeMax() {
        return soldeMax;
    }

    public void setSoldeMax(double soldeMax) {
        this.soldeMax = soldeMax;
    }
}
