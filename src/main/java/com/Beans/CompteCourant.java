package com.Beans;

public class CompteCourant extends Compte{

    public CompteCourant(int idCompte, String numerosCompte, double solde, int idClient) {
        super(idCompte, numerosCompte, solde, idClient);
    }

    @Override
    public String toString() {
        return "CompteCourant{" +
                "idCompte=" + idCompte +
                ", numerosCompte='" + numerosCompte + '\'' +
                ", solde=" + solde +
                ", client=" + client +
                '}';
    }

    public void debiter(double montant){
        this.solde-= montant;
    }
    public void retirer(double montant){
        if (montant <= this.solde && this.solde >= 0){
            this.solde = this.solde - montant;
        }else {
            System.out.println("Vous n'avez pas asser sur votre compte !");
        }
    }
}
