package com.demo;

import com.Beans.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        boolean quitter = false;
        boolean quitterMenu = false;
        boolean loginValide = false;
        boolean passwordValide = false;

        ArrayList<String> listLogin = new ArrayList<>(Arrays.asList("client","conseiller","directeur"));
        ArrayList<String> listPassword = new ArrayList<>(Arrays.asList("client","conseiller","directeur"));


        // Création d'un client et de ses comptes
        ArrayList<Compte> listCompte = new ArrayList<>();
        Client client = new Client("Havez", "Maxime","4 av de l'horizon","mHavez@gmail.com",40, 1,listCompte);
        Client client2 = new Client("Gaucher", "Alice","4 av de l'horizon","aGaucher@gmail.com",27, 1,listCompte);

        CompteCourant compteCourant = new CompteCourant(0, "01",2000,client.getIdClient());
        CompteCourant compteCourant2 = new CompteCourant(1, "02",2000,client2.getIdClient());
        client.ajouterCompte(compteCourant);
        client2.ajouterCompte(compteCourant2);

        CompteEpargne compteEpargne = new CompteEpargne(1,"02",500,client.getIdClient());
        CompteEpargne compteEpargne2 = new CompteEpargne(2,"03",500,client2.getIdClient());
        client.ajouterCompte(compteEpargne);
        client2.ajouterCompte(compteEpargne2);

        CompteRemunerer compteRemunerer = new CompteRemunerer(2,"03",1000,client.getIdClient());
        CompteRemunerer compteRemunerer2 = new CompteRemunerer(3,"04",1000,client2.getIdClient());
        client.ajouterCompte(compteRemunerer);
        client2.ajouterCompte(compteRemunerer2);

//        Création d'un conseiller
        ArrayList<Compte> listCompteConseil = new ArrayList<>();
        Conseiller conseiller = new Conseiller("Clement","Thibault","4 av de l'horizon","tClement@gmail.com",28,2,listCompteConseil);
        conseiller.getListClient().add(client);
        conseiller.getListClient().add(client2);


//      Menu
        System.out.println("Bienvenue sur l'application Banque");
        System.out.println("Veuiller vous connecter:");
        System.out.print("login : ");
        String login = sc.nextLine();
        System.out.print("password: ");
        String password = sc.nextLine();

        for (int i = 0; i < listLogin.size(); i++) {
            if (login.equals(listLogin.get(i))){
                loginValide = true;
            }
        }
        for (int i = 0; i < listPassword.size(); i++) {
            if (password.equals(listPassword.get(i)) && password.equals(login)){
                passwordValide = true;
            }
        }


        // Boucle du menu
        while (!quitter){
            if (loginValide && passwordValide){
                switch (login){
                    case "client":
                        try{
                            int choixUser = 0;
                            System.out.println("Bienvenue, veuiller choisir une opération:");
                            System.out.println("1 - déposer argent");
                            System.out.println("2 - débiter compte");
                            System.out.println("3 - retirer argent");
                            System.out.println("4 - consulter le solde");
                            System.out.println("5 - Quitter l'appli");
                            System.out.print("choix: ");
                                choixUser = sc.nextInt();
                                if (choixUser == 1){
                                    quitterMenu = false;
                                    while (!quitterMenu){
                                        System.out.println("Dans quelle compte voullez vous déposer de l'argent: ");
                                        System.out.println("1 - compte courant");
                                        System.out.println("2 - compte épargne");
                                        System.out.println("3 - compte remunere");
                                        System.out.println("4 - retour");
                                        System.out.print("choix: ");
                                        try{
                                            int choix = sc.nextInt();
                                            if (choix == 1){
                                                System.out.print("montant: ");
                                                double montant = sc.nextDouble();
                                                compteCourant.crediterCompte(montant);
                                            } else if (choix == 2) {
                                                System.out.print("montant: ");
                                                double montant = sc.nextDouble();
                                                compteEpargne.crediterCompte(montant);
                                            } else if (choix == 3) {
                                                System.out.print("montant: ");
                                                double montant = sc.nextDouble();
                                                compteRemunerer.crediterCompte(montant);
                                            }else {
                                                quitterMenu = true;
                                            }
                                        }catch (Exception e){
                                            System.out.println("veuiller séléctionner un numéros !");
                                        }
                                    }
                                } else if (choixUser == 2) {
                                    quitterMenu = false;
                                    while (!quitterMenu){
                                        System.out.println("Dans quelle compte voullez vous débiter de l'argent: ");
                                        System.out.println("1 - compte courant");
                                        System.out.println("2 - compte remunere");
                                        System.out.println("3 - retour");
                                        System.out.print("choix: ");
                                        try{
                                            int choix = sc.nextInt();
                                            if (choix == 1){
                                                System.out.print("montant: ");
                                                double montant = sc.nextDouble();
                                                compteCourant.debiter(montant);
                                            } else if (choix == 2) {
                                                System.out.print("montant: ");
                                                double montant = sc.nextDouble();
                                                compteCourant.debiter(montant);
                                            }else {
                                                quitterMenu = true;
                                            }
                                        }catch (Exception e){
                                            System.out.println("Veuiller séléctionner un numéros !");
                                        }
                                    }
                                } else if (choixUser == 3) {
                                    quitterMenu = false;
                                    while (!quitterMenu){
                                        System.out.println("Dans quelle compte voullez vous retirer de l'argent: ");
                                        System.out.println("1 - compte courant");
                                        System.out.println("2 - compte epargne");
                                        System.out.println("3 - compte remunere");
                                        System.out.println("4 - retour");
                                        System.out.print("choix: ");
                                        try{
                                            int choix = sc.nextInt();
                                            if (choix == 1){
                                                System.out.print("montant: ");
                                                double montant = sc.nextDouble();
                                                compteCourant.retirer(montant);
                                            } else if (choix == 2) {
                                                System.out.print("montant: ");
                                                double montant = sc.nextDouble();
                                                compteCourant.retirer(montant);
                                            } else if (choix == 3) {
                                                System.out.print("montant: ");
                                                double montant = sc.nextDouble();
                                                compteCourant.retirer(montant);
                                            }else {
                                                quitterMenu = true;
                                            }
                                        }catch (Exception e){
                                            System.out.println("Veuiller séléctionner un numéros !");
                                        }
                                    }
                                } else if (choixUser == 4) {
                                    quitterMenu = false;
                                    while (!quitterMenu){
                                        System.out.println("Quelle compte voullez vous consulter le solde: ");
                                        System.out.println("1 - compte courant");
                                        System.out.println("2 - compte epargne");
                                        System.out.println("3 - compte remunere");
                                        System.out.println("4 - retour");
                                        System.out.print("choix: ");
                                        try{
                                            int choix = sc.nextInt();
                                            if (choix == 1){
                                                System.out.println("Solde du compte courant: "+compteCourant.getSolde()+"€");
                                            } else if (choix == 2) {
                                                System.out.println("Solde du compte épargne: "+compteEpargne.getSolde()+"€");
                                            } else if (choix == 3) {
                                                System.out.println("Solde du compte remunérer: "+compteRemunerer.getSolde()+"€");
                                            }else {
                                                quitterMenu = true;
                                            }
                                        }catch (Exception e){
                                            System.out.println("Veuiller séléctionner un numéros !");
                                        }
                                    }
                                } else {
                                    quitter = true;
                                    break;
                                }
                                break;
                            }catch (Exception e){
                                System.out.println("Veuiller séléctionner un numéros");
                                System.out.print("choix: ");
                                int choixUser = sc.nextInt();
                            }
                        break;
                    case "conseiller":
                        try{
                            int choixUser = 0;
                            System.out.println("Bienvenue, veuiller choisir une opération:");
                            System.out.println("1 - Gérer les clients");
                            System.out.println("2 - Gérer vos comptes");
                            System.out.println("3 - Quitter l'appli");
                            System.out.print("choix: ");
                            choixUser = sc.nextInt();
                            if (choixUser == 1){
                                quitterMenu = false;
                                while (!quitterMenu){
                                    int choix = 0;
                                    System.out.println("Bienvenue, veuiller choisir une opération:");
                                    System.out.println("1 - créer un client");
                                    System.out.println("2 - modifier un client");
                                    System.out.println("3 - supprimer un client");
                                    System.out.println("4 - Afficher tous les clients");
                                    System.out.println("5 - Afficher 1 clients");
                                    System.out.println("6 - retour");
                                    System.out.print("choix: ");
                                    choix = sc.nextInt();
                                    if (choix == 1){
                                        while (!quitterMenu){
                                            try{
                                                System.out.println("donner l'id du client");
                                                int idClient = sc.nextInt();
                                                System.out.println("donner le nom du client");
                                                String nomClient = sc.next();
                                                System.out.println("donner le prenom du client");
                                                String prenomClient = sc.next();
                                                System.out.println("donner l'âge du client");
                                                int ageClient = sc.nextInt();
                                                System.out.println("donner l'adresse du client");
                                                String adresseClient = sc.next();
                                                System.out.println("donner l'email du client");
                                                String emailClient = sc.next();
                                                ArrayList<Compte> listCompteClient = new ArrayList<>();
                                                Client newClient = new Client(nomClient,prenomClient,adresseClient,emailClient,ageClient,idClient, listCompteClient);
                                                conseiller.ajouterClient(newClient);
                                                System.out.println("Ajouter un nouveau client(0: non/1: oui): ");
                                                choix = sc.nextInt();
                                                if (choix == 0){
                                                    quitterMenu = true;
                                                }
                                            }catch (Exception e) {
                                                System.out.println("Choisir un numéros");
                                            }
                                        }
                                    } else if (choix == 2) {
                                        conseiller.afficherTousLesClients();
                                        System.out.println("Choisir un nom de Client dans la liste: ");
                                        String nomClient = sc.next();
                                        if (conseiller.estPresent(nomClient)){
                                            Client clienAModif = new Client();
                                            clienAModif = conseiller.getClientByName(nomClient);
                                            System.out.println("Quelle modification voulez vous aporter:");
                                            System.out.println("1 - ajouter un compte");
                                            System.out.println("2 - supprimer un compte");
                                            System.out.println("3 - retour");
                                            System.out.println("choix: ");
                                            choix = sc.nextInt();
                                            if (choix == 1){
                                                System.out.println("1 - Ajouter un compte courant");
                                                System.out.println("2 - Ajouter un compte epargne");
                                                System.out.println("3 - Ajouter un compte remunere");
                                                System.out.println("4 - Retour");
                                                System.out.print("choix: ");
                                                choix = sc.nextInt();
                                                if (choix == 1){
                                                    System.out.println("id compte: ");
                                                    int idCompte = sc.nextInt();
                                                    System.out.println("numéros compte: ");
                                                    String numCompte = sc.next();
                                                    System.out.println("solde compte: ");
                                                    double soldeCompte = sc.nextDouble();
                                                    CompteCourant newCompteCourant = new CompteCourant(idCompte,numCompte,soldeCompte, clienAModif.getIdClient());
                                                    clienAModif.ajouterCompte(newCompteCourant);
                                                }else if (choix == 2){
                                                    System.out.println("id compte: ");
                                                    int idCompte = sc.nextInt();
                                                    System.out.println("numéros compte: ");
                                                    String numCompte = sc.next();
                                                    System.out.println("solde compte: ");
                                                    double soldeCompte = sc.nextDouble();
                                                    CompteEpargne newCompteEpargne = new CompteEpargne(idCompte,numCompte,soldeCompte, clienAModif.getIdClient());
                                                    clienAModif.ajouterCompte(newCompteEpargne);
                                                } else if (choix == 3) {
                                                    System.out.println("id compte: ");
                                                    int idCompte = sc.nextInt();
                                                    System.out.println("numéros compte: ");
                                                    String numCompte = sc.next();
                                                    System.out.println("solde compte: ");
                                                    double soldeCompte = sc.nextDouble();
                                                    CompteRemunerer newCompteRemunerer = new CompteRemunerer(idCompte,numCompte,soldeCompte, clienAModif.getIdClient());
                                                    clienAModif.ajouterCompte(newCompteRemunerer);
                                                }else {
                                                    quitterMenu = true;
                                                }
                                            } else if (choix == 2) {
                                                System.out.println("Indiquer le numéros de compte à supprimer:");
                                                String numCompteASupp = sc.next();
                                                conseiller.delCompteByNum(clienAModif, numCompteASupp);
                                                System.out.println("le compte a bien été supprimer");
                                            } else {
                                                quitterMenu = true;
                                            }
                                        }else {
                                            System.out.println("le client spécifier n'éxiste pas");
                                        }
                                    }else if (choix == 3){
                                        conseiller.afficherTousLesClients();
                                        System.out.println("Choisir un nom de Client dans la liste: ");
                                        String nomClient = sc.next();
                                        if (conseiller.estPresent(nomClient)){
                                            conseiller.delClientByName(nomClient);
                                        }else {
                                            System.out.println("le client spécifier n'éxiste pas");
                                        }
                                    }else if (choix == 4){
                                        System.out.println("La liste des clients: ");
                                        ArrayList<Client> listeClient = new ArrayList<>();
                                        listeClient.addAll(conseiller.getListClient());
                                        for (Client unClient: listeClient) {
                                            System.out.println(unClient.toString());
                                        }

                                    } else if (choix == 5) {
                                        System.out.println("Donner le nom du client: ");
                                        String nomClient = sc.next();
                                        System.out.println(conseiller.getClientByName(nomClient).toString());
                                    }else {
                                        quitterMenu = true;
                                    }
                                }
                            } else if (choixUser == 2) {
                                try{
                                    choixUser = 0;
                                    System.out.println("Bienvenue, veuiller choisir une opération:");
                                    System.out.println("1 - déposer argent");
                                    System.out.println("2 - débiter compte");
                                    System.out.println("3 - retirer argent");
                                    System.out.println("4 - consulter le solde");
                                    System.out.println("5 - Quitter l'appli");
                                    System.out.print("choix: ");
                                    choixUser = sc.nextInt();
                                    if (choixUser == 1){
                                        quitterMenu = false;
                                        while (!quitterMenu){
                                            System.out.println("Dans quelle compte voullez vous déposer de l'argent: ");
                                            System.out.println("1 - compte courant");
                                            System.out.println("2 - compte épargne");
                                            System.out.println("3 - compte remunere");
                                            System.out.println("4 - retour");
                                            System.out.print("choix: ");
                                            try{
                                                int choix = sc.nextInt();
                                                if (choix == 1){
                                                    System.out.print("montant: ");
                                                    double montant = sc.nextDouble();
                                                    compteCourant.crediterCompte(montant);
                                                } else if (choix == 2) {
                                                    System.out.print("montant: ");
                                                    double montant = sc.nextDouble();
                                                    compteEpargne.crediterCompte(montant);
                                                } else if (choix == 3) {
                                                    System.out.print("montant: ");
                                                    double montant = sc.nextDouble();
                                                    compteRemunerer.crediterCompte(montant);
                                                }else {
                                                    quitterMenu = true;
                                                }
                                            }catch (Exception e){
                                                System.out.println("veuiller séléctionner un numéros !");
                                            }
                                        }
                                    } else if (choixUser == 2) {
                                        quitterMenu = false;
                                        while (!quitterMenu){
                                            System.out.println("Dans quelle compte voullez vous débiter de l'argent: ");
                                            System.out.println("1 - compte courant");
                                            System.out.println("2 - compte remunere");
                                            System.out.println("3 - retour");
                                            System.out.print("choix: ");
                                            try{
                                                int choix = sc.nextInt();
                                                if (choix == 1){
                                                    System.out.print("montant: ");
                                                    double montant = sc.nextDouble();
                                                    compteCourant.debiter(montant);
                                                } else if (choix == 2) {
                                                    System.out.print("montant: ");
                                                    double montant = sc.nextDouble();
                                                    compteCourant.debiter(montant);
                                                }else {
                                                    quitterMenu = true;
                                                }
                                            }catch (Exception e){
                                                System.out.println("Veuiller séléctionner un numéros !");
                                            }
                                        }

                                    } else if (choixUser == 3) {
                                        quitterMenu = false;
                                        while (!quitterMenu){
                                            System.out.println("Dans quelle compte voullez vous retirer de l'argent: ");
                                            System.out.println("1 - compte courant");
                                            System.out.println("2 - compte epargne");
                                            System.out.println("3 - compte remunere");
                                            System.out.println("4 - retour");
                                            System.out.print("choix: ");
                                            try{
                                                int choix = sc.nextInt();
                                                if (choix == 1){
                                                    System.out.print("montant: ");
                                                    double montant = sc.nextDouble();
                                                    compteCourant.retirer(montant);
                                                } else if (choix == 2) {
                                                    System.out.print("montant: ");
                                                    double montant = sc.nextDouble();
                                                    compteCourant.retirer(montant);
                                                } else if (choix == 3) {
                                                    System.out.print("montant: ");
                                                    double montant = sc.nextDouble();
                                                    compteCourant.retirer(montant);
                                                }else {
                                                    quitterMenu = true;
                                                }
                                            }catch (Exception e){
                                                System.out.println("Veuiller séléctionner un numéros !");
                                            }
                                        }
                                    } else if (choixUser == 4) {
                                        quitterMenu = false;
                                        while (!quitterMenu){
                                            System.out.println("Quelle compte voullez vous consulter le solde: ");
                                            System.out.println("1 - compte courant");
                                            System.out.println("2 - compte epargne");
                                            System.out.println("3 - compte remunere");
                                            System.out.println("4 - retour");
                                            System.out.print("choix: ");
                                            try{
                                                int choix = sc.nextInt();
                                                if (choix == 1){
                                                    System.out.println("Solde du compte courant: "+compteCourant.getSolde()+"€");
                                                } else if (choix == 2) {
                                                    System.out.println("Solde du compte épargne: "+compteEpargne.getSolde()+"€");
                                                } else if (choix == 3) {
                                                    System.out.println("Solde du compte remunérer: "+compteRemunerer.getSolde()+"€");
                                                }else {
                                                    quitterMenu = true;
                                                }
                                            }catch (Exception e){
                                                System.out.println("Veuiller séléctionner un numéros !");
                                            }
                                        }
                                    } else {
                                        quitter = true;
                                        break;
                                    }
                                    break;
                                }catch (Exception e){
                                    System.out.println("Veuiller séléctionner un numéros");
                                    System.out.print("choix: ");
                                    choixUser = sc.nextInt();
                                }
                                break;
                            }else {
                                quitter = true;
                            }
                        }catch (Exception e){
                            System.out.println("veuiller rentrer un numéros!");
                        }
                        break;
                    case "directeur":
                        System.out.println("pas implémenter");
                        quitter = true;
                        break;
                }
            }else {
                System.out.println("Erreur dans le login ou le mot de passe");
                System.out.println("se reconnecter ?(0: non/ 1: oui):  ");
                int choix = sc.nextInt();
                if (choix == 0){
                    quitter = true;
                }else {
                    System.out.println("Veuiller vous connecter:");
                    System.out.print("login : ");
                    login = sc.next();
                    System.out.print("password: ");
                    password = sc.next();
                    for (int i = 0; i < listLogin.size(); i++) {
                        if (login.equals(listLogin.get(i))){
                            loginValide = true;
                        }
                    }
                    for (int i = 0; i < listPassword.size(); i++) {
                        if (password.equals(listPassword.get(i)) && password.equals(login)){
                            passwordValide = true;
                        }
                    }
                }
            }
        }
        System.out.println("A bientôt !");
    }
}
