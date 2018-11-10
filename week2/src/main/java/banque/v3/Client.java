package banque.v3;

public class Client {
    private String nom;
    private String ville;
    private Compte cptePrive;
    private Compte cpteEpargne;
    private double soldePrive;
    private double soldeEpargne;
    private boolean masculin;

    public Client(String nom, String ville, double soldePrive, double tauxPrive, double soldeEpargne, double tauxEpargne, boolean masculin) {
        this.nom = nom;
        this.ville = ville;
        this.soldePrive = soldePrive;
        this.soldeEpargne = soldeEpargne;
        this.masculin = masculin;
        cptePrive = new Compte(tauxPrive, soldePrive);
        cpteEpargne = new Compte(tauxEpargne, soldeEpargne);

    }

    public void afficherClient() {
        afficher(nom, ville, soldePrive, soldeEpargne);
    }

    public void afficher(String nom, String ville, double soldePrive, double soldeEpargne) {
        if (masculin) {
            System.out.print("  Client ");
        } else {
            System.out.print("  Cliente ");
        }
        System.out.println(nom + " de " + ville);
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
