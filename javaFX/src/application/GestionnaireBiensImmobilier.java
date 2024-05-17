package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.awt.Container;
import javax.swing.JPanel;
import application.GestionnaireBiensImmobilier;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;



 class GestionnaireBiensImmobilier {

    // Les informations de connexion à la base de données ORACLE
    private static final String URL = "jdbc:oracle:thin:@//localhost:1521/xe";
    private static final String USER = "system";
    private static final String PASSWORD = "mimi";

    // Méthode pour établir une connexion à la base de données
    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

   
    
    public GestionnaireBiensImmobilier() {
        // Initialisez les champs ou effectuez d'autres opérations nécessaires
    }

    
    
 // Méthode pour ajouter un bien immobilier à la base de données
    public static void ajouterBienImmobilier(BienImmobilier bien) {
        String sql = "INSERT INTO BienImmobilier (type, taille, prix, localisation, description, agentImmobilier) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, bien.getType());
            statement.setDouble(2, bien.getTaille());
            statement.setDouble(3, bien.getPrix());
            statement.setString(4, bien.getLocalisation());
            statement.setString(5, bien.getDescription());
            statement.setString(6, bien.getAgentImmobilier());
            
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Méthode pour récupérer tous les biens immobiliers de la base de données
    public static List<BienImmobilier> recupererTousBiensImmobilier() {
        List<BienImmobilier> biens = new ArrayList<>();
        String sql = "SELECT * FROM BienImmobilier";
        try (Connection conn = getConnection();
             PreparedStatement statement = conn.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                
                String type = resultSet.getString("type");
                int taille = resultSet.getInt("taille");
                double prix = resultSet.getDouble("prix");
                String localisation = resultSet.getString("localisation");
                String description = resultSet.getString("description");
                String agentImmobilier = resultSet.getString("agentImmobilier");
                
                // Crée un nouvel objet BienImmobilier avec les données récupérées et l'ajoute à la liste
                biens.add(new BienImmobilier(type, taille, prix, localisation, description, agentImmobilier));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return biens;
    }

 // Méthode pour mettre à jour un bien immobilier dans la base de données
    public static void mettreAJourBienImmobilier(BienImmobilier bien) {
        String sql = "UPDATE BienImmobilier SET type=?, taille=?, prix=?, localisation=?, description=?, agentImmobilier=?";
        try (Connection conn = getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, bien.getType());
            statement.setDouble(2, bien.getTaille());
            statement.setDouble(3, bien.getPrix());
            statement.setString(4, bien.getLocalisation());
            statement.setString(5, bien.getDescription());
            statement.setString(6, bien.getAgentImmobilier());
            
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
 // Méthode pour ajouter un client à la base de données
    public static void ajouterClient(Client client) {
        String sql = "INSERT INTO Client (nom, adresse, types, preferences, demandes) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, client.getNom());
            statement.setString(2, client.getAdresse());
            statement.setString(3, client.getTypes());
            statement.setString(4, client.getPreferences());
            statement.setString(5, client.getDemandes());
            
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Méthode pour récupérer tous les clients de la base de données
    public static List<Client> recupererTousClients() {
        List<Client> clients = new ArrayList<>();
        String sql = "SELECT * FROM Client";
        try (Connection conn = getConnection();
             PreparedStatement statement = conn.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                String nom = resultSet.getString("nom");
                String adresse = resultSet.getString("adresse");
                String types = resultSet.getString("types");
                String preferences = resultSet.getString("preferences");
                String demandes = resultSet.getString("demandes");
            
                // Crée un nouvel objet Client avec les données récupérées et l'ajoute à la liste
                clients.add(new Client(nom, adresse, types, preferences, demandes));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }

    // Méthode pour mettre à jour un client dans la base de données
    public static void mettreAJourClient(Client client) {
        String sql = "UPDATE Client SET adresse=?, types=?, preferences=?, demandes=? WHERE nom=?";
        try (Connection conn = getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, client.getAdresse());
            statement.setString(2, client.getTypes());
            statement.setString(3, client.getPreferences());
            statement.setString(4, client.getDemandes());
            statement.setString(5, client.getNom());
            
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
 // Méthode pour ajouter un contrat à la base de données
    public static void ajouterContrat(Contrat contrat) {
        String sql = "INSERT INTO Contrat (typee, bienImmobiliers, clients, montant, dates, paiementEffectue, dateEcheance, clientVendeur, numeroContrat) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, contrat.getTypee());
            statement.setString(2, contrat.getBienImmobiliers());
            statement.setString(3, contrat.getClients());
            statement.setString(4, contrat.getMontant());
            statement.setString(5, contrat.getDates());
            statement.setString(6, contrat.isPaiementEffectue());
            statement.setString(7, contrat.getDateEcheance());
            statement.setString(8, contrat.getClientVendeur());
            statement.setString(9, contrat.getNumeroContrat());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Méthode pour récupérer tous les contrats de la base de données
    public static List<Contrat> recupererTousContrats() {
        List<Contrat> contrats = new ArrayList<>();
        String sql = "SELECT * FROM Contrat";
        try (Connection conn = getConnection();
             PreparedStatement statement = conn.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                String typee = resultSet.getString("typee");
                String bienImmobiliers = resultSet.getString("bienImmobiliers");
                String clients = resultSet.getString("clients");
                String montant = resultSet.getString("montant");
                String dates = resultSet.getString("dates");
                String paiementEffectue = resultSet.getString("paiementEffectue");
                String dateEcheance = resultSet.getString("dateEcheance");
                String clientVendeur = resultSet.getString("clientVendeur");
                String numeroContrat = resultSet.getString("numeroContrat");

                // Crée un nouvel objet Contrat avec les données récupérées et l'ajoute à la liste
                contrats.add(new Contrat(typee, bienImmobiliers, clients, montant, dates, paiementEffectue, dateEcheance, clientVendeur, numeroContrat));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contrats;
    }

    // Méthode pour mettre à jour un contrat dans la base de données
    public static void mettreAJourContrat(Contrat contrat) {
        String sql = "UPDATE Contrat SET bienImmobiliers=?, clients=?, montant=?, dates=?, paiementEffectue=?, dateEcheance=?, clientVendeur=?, numeroContrat=? WHERE typee=?";
        try (Connection conn = getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
        	statement.setString(1, contrat.getTypee());
            statement.setString(2, contrat.getBienImmobiliers());
            statement.setString(3, contrat.getClients());
            statement.setString(4, contrat.getMontant());
            statement.setString(5, contrat.getDates());
            statement.setString(6, contrat.isPaiementEffectue());
            statement.setString(7, contrat.getDateEcheance());
            statement.setString(8, contrat.getClientVendeur());
            statement.setString(9, contrat.getNumeroContrat());
            

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
 
  
 // Méthode pour afficher la liste des biens immobiliers dans le modèle de tableau
    public void afficherListeBiens(List<BienImmobilier> biens, DefaultTableModel model) {
        // Effacer le modèle existant
        model.setRowCount(0);

        // Remplir le modèle avec les données des biens immobiliers
        for (BienImmobilier bien : biens) {
            model.addRow(new Object[]{bien.getType(), bien.getTaille(), bien.getPrix(), bien.getLocalisation(), bien.getDescription(), bien.getAgentImmobilier()});
        }
    }

    // Méthode pour afficher la liste des clients dans le modèle de tableau
    public static void afficherListeClients(List<Client> clients, DefaultTableModel model) {
        // Effacer le modèle existant
        model.setRowCount(0);

        // Remplir le modèle avec les données des clients
        for (Client client : clients) {
            model.addRow(new Object[]{client.getNom(), client.getAdresse(), client.getTypes(), client.getPreferences(), client.getDemandes()});
        }
    }

    // Méthode pour afficher la liste des contrats dans le modèle de tableau
    public void afficherListeContrats(List<Contrat> contrats, DefaultTableModel model) {
        // Effacer le modèle existant
        model.setRowCount(0);

        // Remplir le modèle avec les données des contrats
        for (Contrat contrat : contrats) {
            model.addRow(new Object[]{contrat.getTypee(), contrat.getBienImmobiliers(), contrat.getClients(), contrat.getMontant(), contrat.getDates(), contrat.isPaiementEffectue(), contrat.getDateEcheance(), contrat.getClientVendeur(), contrat.getNumeroContrat()});
        }
    }
    
   
    public void actualiserListeClients(JTable table) {
        // Récupérer la liste mise à jour des clients depuis la base de données
        List<Client> clients = recupererTousClients();
        
        // Mettre à jour l'affichage de la liste des clients à l'écran
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Effacer toutes les lignes actuelles de la table
        
        // Ajouter les clients à la table
        for (Client client : clients) {
            model.addRow(new Object[]{client.getNom(), client.getAdresse(), client.getTypes(), client.getPreferences(), client.getDemandes()});
        }
    }


    
 
 // Méthode pour supprimer un bien immobilier de la base de données par son type
    public static void supprimerBienImmobilierParType(String type) {
        String sql = "DELETE FROM BienImmobilier WHERE Type=?";
        
        
        try (Connection conn = getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, type);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
 // Méthode pour supprimer un client de la base de données par son nom
    public static void supprimerClientParNom(String nom) {
        String sql = "DELETE FROM Client WHERE Nom=?";
        
        try (Connection conn = getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, nom);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

 // Méthode pour supprimer une transaction de la base de données par son numéro de contrat
    public static void supprimerTransactionParNumeroContrat(String numeroContrat) {
        String sql = "DELETE FROM Contrat WHERE numeroContrat=?";
        
        try (Connection conn = getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, numeroContrat);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }





    
 

}