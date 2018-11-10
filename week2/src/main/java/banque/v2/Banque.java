package banque.v2;

public class Banque {

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
