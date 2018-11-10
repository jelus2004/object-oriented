package banque.v4;

enum TypeDeCompte {
    prive("privé", 0.01),
    epargne("d'épargne", 0.02),
    fraudeFiscale("secret", 5.0);

    private final String nom;
    private final double taux;

    TypeDeCompte(String nom, double taux) {
        this.nom = nom;
        this.taux = taux;
    }

    public double getTaux() {
        return taux;
    }

    public String getNom() {
        return nom;
    }
}
