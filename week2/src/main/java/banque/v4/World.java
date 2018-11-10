package banque.v4;

import static banque.v4.TypeDeCompte.*;

public class World {
    public static void main(String[] args) {
        final Banque banque = new Banque();
        banque.ajouterClient("Pedro", "Genève")
                .ouvrirCompte(prive, 1000.0)
                .ouvrirCompte(epargne, 2000.0);

        banque.ajouterCliente("Alexandra", "Lausanne")
                .ouvrirCompte(prive, 3000.0)
                .ouvrirCompte(epargne, 4000.0);

        System.out.println("Donnees avant le bouclement des comptes:");

        banque.afficherClients();

        System.out.println("Donnees apres le bouclement des comptes:");

        banque.bouclerComptes();

        banque.afficherClients();
        banque.chercherClient("Pedro", "Genève")
                .onEmpty(() -> System.out.println("Le client n'existe pas"))
                .forEach(client -> client.ouvrirCompte(fraudeFiscale, 1000000.0));

        banque.afficherClients();
    }
}
