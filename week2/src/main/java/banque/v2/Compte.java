package banque.v2;

public class Compte {
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
