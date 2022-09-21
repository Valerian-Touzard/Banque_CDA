package com.demo;

import com.Beans.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){


        System.out.println("//----Création d'un client---//");
        ArrayList<Compte> listCompte = new ArrayList<>();
        Client maxime = new Client("Havez", "Maxime","4 av de l'horizon","mHavez@gmail.com",40, 1,listCompte);
        System.out.println(maxime.toString());
        System.out.println("");


        System.out.println("//----Création d'un compte courant/épargne/remunerer");
        CompteCourant compteCourantMaxime = new CompteCourant(0, "01",2000,maxime.getIdClient());
        maxime.ajouterCompte(compteCourantMaxime);

        CompteEpargne compteEpargneMaxime = new CompteEpargne(1,"02",500,700,maxime.getIdClient());
        maxime.ajouterCompte(compteEpargneMaxime);

        CompteRemunerer compteRemunererMaxime = new CompteRemunerer(2,"03",1000,maxime.getIdClient());
        maxime.ajouterCompte(compteRemunererMaxime);

        System.out.println(compteCourantMaxime.toString());
        System.out.println(compteEpargneMaxime.toString());
        System.out.println(compteRemunererMaxime.toString());
        System.out.println("liste des compte de "+maxime.getPrenom()+": "+maxime.getListCompte());
        System.out.println("");

        System.out.println("/----Créditer/debiter/retirer----/");
        System.out.println("/----Créditer----/");
        System.out.println("solde compte courant avant crédit: "+compteCourantMaxime.getSolde());
        compteCourantMaxime.crediterCompte(500);
        System.out.println("solde compte courant après crédit: "+compteCourantMaxime.getSolde());
        System.out.println("/----Fin créditer----/");
        System.out.println("");

        System.out.println("/----Debiter----/");
        System.out.println("solde compte courant avant débit: "+compteCourantMaxime.getSolde());
        compteCourantMaxime.debiter(500);
        System.out.println("solde compte courant après débit: "+compteCourantMaxime.getSolde());
        System.out.println("/----Fin débiter----/");
        System.out.println("");

        System.out.println("/----retirer autorisé----/");
        System.out.println("solde compte courant avant le retrait: "+compteCourantMaxime.getSolde());
        compteCourantMaxime.retirer(2000);
        System.out.println("solde compte courant après le retrait: "+compteCourantMaxime.getSolde());
        System.out.println("/----Fin retirer autorisé----/");
        System.out.println("");

        System.out.println("/----retirer pas autorisé----/");
        System.out.println("solde compte courant avant le retrait: "+compteCourantMaxime.getSolde());
        compteCourantMaxime.retirer(2000);
        System.out.println("solde compte courant après le retrait: "+compteCourantMaxime.getSolde());
        System.out.println("/----Fin retirer autorisé----/");
        System.out.println("");


        System.out.println("/----Découvert----/");
        compteCourantMaxime.debiter(1000);
        System.out.println("solde compte courant: "+compteCourantMaxime.getSolde());
        System.out.println("/----Fin Découvert----/");
        System.out.println("");
    }
}
