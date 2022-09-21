package com.Beans;

public class CompteRemunerer extends Compte{


    public CompteRemunerer(int idCompte, String numerosCompte, double solde, int idClient) {
        super(idCompte, numerosCompte, solde, idClient);
    }


    @Override
    public String toString() {
        return "CompteRemunerer{" +
                "idCompte=" + idCompte +
                ", numerosCompte=" + numerosCompte +
                ", solde=" + solde +
               // ", client=" + client +
                '}';
    }

    public void debiter(double montant){
        this.solde -= montant;
    }

    public void retirer(double montant){
        if (montant <= this.solde && this.solde >= 0){
            this.solde -= montant;
        }else {
            System.out.println("Vous n'avez pas asser sur votre compte !");
        }
    }
}
