package banque.v2;

public class Client {
    private String nom;
    private String ville;
    private Compte cptePrive;
    private Compte cpteEpargne;
    private double soldePrive;
    private double soldeEpargne;

    public Client(String nom, String ville, double soldePrive, double tauxPrive, double soldeEpargne, double tauxEpargne) {
        this.nom = nom;
        this.ville = ville;
        this.soldePrive = soldePrive;
        this.soldeEpargne = soldeEpargne;
        cptePrive = new Compte(tauxPrive, soldePrive);
        cpteEpargne = new Compte(tauxEpargne, soldeEpargne);
    }

    public void afficherClient() {
        afficher(nom, ville, soldePrive, soldeEpargne);
    }

    public void afficher(String nom, String ville, double soldePrive, double soldeEpargne) {
        System.out.println("    Client " + nom + " de " + ville);
        System.out.println("        Compte prive:     " + soldePrive + " francs");
        System.out.println("        Compte d'epargne: " + soldeEpargne + " francs");
    }

    public void bouclerCompte() {
        cptePrive.bouclerCompte();
        cpteEpargne.bouclerCompte();
        soldePrive = cptePrive.getSolde();
        soldeEpargne = cpteEpargne.getSolde();
    }
}
