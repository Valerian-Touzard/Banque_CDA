package com.Beans;

import java.lang.ref.Cleaner;

public class CompteEpargne extends Compte{

    protected double soldeMax;

    public CompteEpargne(int idCompte, String numerosCompte, double solde, double soldeMax, int idClient) {
        super(idCompte, numerosCompte, solde, idClient);
        this.soldeMax = soldeMax;
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
