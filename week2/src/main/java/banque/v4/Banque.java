package banque.v4;

import io.vavr.control.Option;

import java.util.ArrayList;
import java.util.List;

import static io.vavr.control.Option.none;
import static io.vavr.control.Option.some;

public class Banque {
    private final List<Client> clients = new ArrayList<Client>();

    public Client ajouterCliente(String nom, String ville) {
        return ajouterClient(new Client(nom, ville, false));
    }

    public Client ajouterClient(String nom, String ville) {
        return ajouterClient(new Client(nom, ville, true));
    }

    private Client ajouterClient(Client client) {
        clients.add(client);
        return client;
    }

    public void afficherClients() {
        for (Client client : clients) {
            client.afficherClient();
        }
    }

    public void bouclerComptes() {
        for (Client client : clients) {
            client.bouclerComptes();
        }
    }

    public Option<Client> chercherClient(String nom, String ville) {
        for (Client client : clients) {
            if (client.getNom().equals(nom) && client.getVille().equals(ville)) {
                return some(client);
            }
        }
        return none();
    }
}
