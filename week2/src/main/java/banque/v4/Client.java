package banque.v4;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private String nom;
    private String ville;
    private final List<Compte> comptes = new ArrayList<Compte>();
    private boolean masculin;

    public Client(String nom, String ville, boolean masculin) {
        this.nom = nom;
        this.ville = ville;
        this.masculin = masculin;
    }

    public Client ouvrirCompte(TypeDeCompte typeDeCompte, double solde) {
        comptes.add(new Compte(typeDeCompte, solde));
        return this;
    }

    public String getNom() {
        return nom;
    }

    public String getVille() {
        return ville;
    }

    public void afficherClient() {
        if (masculin) {
            System.out.print("  Client ");
        } else {
            System.out.print("  Cliente ");
        }
        System.out.println(nom + " de " + ville);
        for (Compte compte : comptes) {
            compte.afficherCompte();
        }
    }

    public void bouclerComptes() {
        for (Compte compte : comptes) {
            compte.bouclerCompte();
        }
    }
}
