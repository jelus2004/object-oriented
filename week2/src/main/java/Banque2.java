class Client {
    private String nom;
    private String ville;
    private Compte3 cptePrive;
    private Compte3 cpteEpargne;
    private double soldePrive;
    private double soldeEpargne;

    public Client(String nom, String ville, double soldePrive, double tauxPrive, double soldeEpargne, double tauxEpargne) {
        this.nom = nom;
        this.ville = ville;
        this.soldePrive = soldePrive;
        this.soldeEpargne = soldeEpargne;
        cptePrive = new Compte3(tauxPrive, soldePrive);
        cpteEpargne = new Compte3(tauxEpargne, soldeEpargne);
    }

    public void afficherClient() {
        afficher(nom, ville, soldePrive, soldeEpargne);
    }

    public void afficher(String nom, String ville, double soldePrive, double soldeEpargne) {
        System.out.println("    Client " + nom + " de " + ville);
        System.out.println("        Compte3 prive:     " + soldePrive + " francs");
        System.out.println("        Compte3 d'epargne: " + soldeEpargne + " francs");
    }

    public void bouclerCompte() {
        cptePrive.bouclerCompte();
        cpteEpargne.bouclerCompte();
        soldePrive = cptePrive.getSolde();
        soldeEpargne = cpteEpargne.getSolde();
    }
}

class Compte {
    private double taux;
    private double solde;

    public Compte(double taux, double solde){
        this.taux = taux;
        this.solde = solde;
    }

    public double getSolde() {
        return solde;
    }

    public void bouclerCompte() {
        double interets = taux * solde;
        solde = solde + interets;
    }
}

class Banque2 {

    public static void main(String[] args) {
        double tauxPrive = 0.01;
        double tauxEpargne = 0.02;

        Client client1 = new Client("Pedro", "Genève", 1000.0, tauxPrive, 2000.0, tauxEpargne);
        Client client2 = new Client("Alexandra", "Lausanne", 3000.0, tauxPrive, 4000.0, tauxEpargne);

        System.out.println("Donnees avant le bouclement des comptes:");

        client1.afficherClient();
        client2.afficherClient();

        System.out.println("Donnees apres le bouclement des comptes:");

        client1.bouclerCompte();
        client2.bouclerCompte();

        client1.afficherClient();
        client2.afficherClient();

    }
}
