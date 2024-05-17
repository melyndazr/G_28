package application;


import java.sql.*;

public class BDD {
    // Les informations de connexion à la base de données Oracle
    static final String DB_URL = "jdbc:oracle:thin:@//localhost:1521/xe"; // Remplacez localhost et 1521 par votre URL de base de données
    static final String USER = "system";
    static final String PASS = "mimi";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            // Etape 1 : Enregistrement du pilote JDBC
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Etape 2 : Ouverture de la connexion
            System.out.println("Connexion à la base de données...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Etape 3 : Création de la déclaration
            System.out.println("Création de la déclaration...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM BienImmobilier"; // Remplacez votre_table par le nom de votre table
            ResultSet rs = stmt.executeQuery(sql);
/*
            // Etape 4 : Traitement des données résultantes
            while (rs.next()) {
                // Récupération des données par nom de colonne
                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                // Affichage des valeurs
                System.out.println("ID: " + id + ", Nom: " + nom);
            }
           */ 
            
         // Etape 4 : Traitement des données résultantes
            while (rs.next()) {
                // Récupération des données par nom de colonne
                int id = rs.getInt("id");
                String type = rs.getString("type");
                double taille = rs.getDouble("taille");
                double prix = rs.getDouble("prix");
                String localisation = rs.getString("localisation");
                String description = rs.getString("description");
                String agentImmobilier = rs.getString("agentImmobilier"); // Si vous avez une colonne agentImmobilier
                
                // Affichage des valeurs
                System.out.println("ID: " + id + ", Type: " + type + ", Taille: " + taille + ", Prix: " + prix + ", Localisation: " + localisation + ", Description: " + description + ", Agent Immobilier: " + agentImmobilier);
            }


            // Etape 5 : Fermeture des ressources
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            // Gestion des erreurs pour JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Gestion des erreurs pour Class.forName
            e.printStackTrace();
        } finally {
            // Bloc de finalement, utilisé pour fermer les ressources
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            } // Rien à faire
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("Fin du programme.");
    }
}