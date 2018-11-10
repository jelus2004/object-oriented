package banque.v4;

public class Compte {
    private TypeDeCompte typeDeCompte;
    private double solde;

    public Compte(TypeDeCompte typeDeCompte, double solde) {
        this.typeDeCompte = typeDeCompte;
        this.solde = solde;
    }

    public void bouclerCompte() {
        double interets = typeDeCompte.getTaux() * solde;
        solde = solde + interets;
    }

    public void afficherCompte() {
        System.out.printf("        Compte %-10s %s francs\n", typeDeCompte.getNom() + ":", solde);
    }
}
