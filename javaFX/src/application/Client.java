package application;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class Client {
    private String nom;
    private String adresse;
    private String types; 
    private int num;
    private List<HistoriqueInteraction> historiqueInteractions; 
    private String demandes; // Liste des demandes du client
    private String preferences; // Liste des préférences du client
    private static Map<String, Client> clients = new HashMap<>();
    
    // Constructeur
    public Client(String nom, String adresse, String types, String demandes, String preferences) {
        this.nom = nom;
        this.adresse = adresse;
        this.types = types;
       
        this.historiqueInteractions = new ArrayList<>();
        this.demandes = demandes;
        this.preferences = preferences;
    }
    
   //  constructeur prenant deux arguments de type String
    public Client(String nom, String adresse) {
        this.nom = nom;
        this.adresse = adresse;
        this.historiqueInteractions = new ArrayList<>();
        this.demandes = demandes;
        this.preferences = preferences;
    }

    // Getters et setters pour le nom et l'adresse et le num

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }
    
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    // Getters et setters pour les types de client

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    // Getters et setters pour l'historique des interactions avec le client

    public List<HistoriqueInteraction> getHistoriqueInteractions() {
        return historiqueInteractions;
    }

    public void setHistoriqueInteractions(List<HistoriqueInteraction> historiqueInteractions) {
        this.historiqueInteractions = historiqueInteractions;
    }

    // Méthode pour ajouter une interaction à l'historique du client

    public void ajouterInteraction(HistoriqueInteraction interaction) {
        historiqueInteractions.add(interaction);
    }

    // Getters et setters pour les demandes du client

    public String getDemandes() {
        return demandes;
    }

    public void setDemandes(String demandes) {
        this.demandes = demandes;
    }
    
 // Getter pour les préférences du client
    public String getPreferences() {
        return preferences;
    }

    // Setter pour les préférences du client
    public void setPreferences(String preferences) {
        this.preferences = preferences;
    }

 // Méthodes pour ajouter et supprimer des demandes
    public void ajouterDemande(String demande) {
        this.demandes = demande;
    }

    public void supprimerDemande(String demande) {
        this.demandes = null; // Supprimer la demande
    }

    // Méthodes pour ajouter et supprimer des préférences
    public void ajouterPreference(String preference) {
        this.preferences = preference;
    }

    public void supprimerPreference(String preference) {
        this.preferences = null; // Supprimer la préférence
    }


    
    
    // Méthodes de gestion des client
    public static void ajouterClient(String nom, String adresse) {
        Client client = new Client(nom, adresse);
        clients.put(nom, client);
    }

    public static void modifierAdresseClient(String nom, String nouvelleAdresse) {
        if (clients.containsKey(nom)) {
            Client client = clients.get(nom);
            client.setAdresse(nouvelleAdresse);
        } else {
            System.out.println("Client non trouvé.");
        }
    }

    public static void modifierTypesClient(String nom, String nouveauxTypes) {
        if (clients.containsKey(nom)) {
            Client client = clients.get(nom);
            client.setTypes(nouveauxTypes);
        } else {
            System.out.println("Client non trouvé.");
        }
    }

    public static void supprimerClient(String nom) {
        if (clients.containsKey(nom)) {
            clients.remove(nom);
        } else {
            System.out.println("Client non trouvé.");
        }
    }


 // Méthode pour ajouter une demande
    public static void ajouterDemandeClient(String nomClient, String demande) {
        if (clients.containsKey(nomClient)) {
            Client client = clients.get(nomClient);
            client.ajouterDemande(demande);
        } else {
            System.out.println("Client non trouvé.");
        }
    }

    // Méthode pour ajouter une préférence
    public static void ajouterPreferenceClient(String nomClient, String preference) {
        if (clients.containsKey(nomClient)) {
            Client client = clients.get(nomClient);
            client.ajouterPreference(preference);
        } else {
            System.out.println("Client non trouvé.");
        }
    }


  
}