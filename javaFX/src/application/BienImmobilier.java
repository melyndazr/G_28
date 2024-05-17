package application;

import java.util.ArrayList;
import java.util.List;

public class BienImmobilier {
	private String type;
    private double taille;
    private double prix;
    private String localisation;
    private String description;
    private String agentImmobilier; // Ajout de l'attribut agent immobilier
    private static List<BienImmobilier> biensImmobiliers = new ArrayList<>(); // Liste de biens immobiliers
    
    // Constructeur
    public BienImmobilier(String type, double taille, double prix, String localisation, String description, String agentImmobilier) {
        this.type = type;
        this.taille = taille;
        this.prix = prix;
        this.localisation = localisation;
        this.description = description;
        this.agentImmobilier = null; // Par défaut, aucun agent n'est assigné
    }

    

	// Getters et setters
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public double getTaille() {
		return taille;
	}
	public void setTaille(double taille) {
		this.taille = taille;
	}

	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String getLocalisation() {
		return localisation;
	}
	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getAgentImmobilier() {
        return agentImmobilier;
    }

    public void setAgentImmobilier(String agentImmobilier) {
        this.agentImmobilier = agentImmobilier;
    }
    
    // Méthodes pour la gestion des biens immobiliers
    // Ajouter un bien immobilier
    public static void ajouterBienImmobilier(BienImmobilier bienImmobilier) {
        biensImmobiliers.add(bienImmobilier);
    }
    
    



    // Modifier un bien immobilier
    public static void modifierBienImmobilier(BienImmobilier bienImmobilier, String type, double taille, double prix, String localisation, String description) {
        bienImmobilier.setType(type);
        bienImmobilier.setTaille(taille);
        bienImmobilier.setPrix(prix);
        bienImmobilier.setLocalisation(localisation);
        bienImmobilier.setDescription(description);
    }
    
    // Supprimer un bien immobilier
    public static void supprimerBienImmobilier(BienImmobilier bienImmobilier) {
        biensImmobiliers.remove(bienImmobilier);
    }
    
    // Rechercher des biens immobiliers en fonction des critères spécifiques
    public static List<BienImmobilier> rechercherBiensImmobilier(double prixMax, double tailleMin, double tailleMax, String type, String localisation) {
        List<BienImmobilier> biensTrouves = new ArrayList<>();
        for (BienImmobilier bien : biensImmobiliers) {
            // Vérifier si le bien correspond aux critères spécifiés
            if ((type == null || type.isEmpty() || bien.getType().equals(type)) &&
                (localisation == null || localisation.isEmpty() || bien.getLocalisation().equals(localisation)) &&
                (prixMax == 0 || bien.getPrix() <= prixMax) && (tailleMax == 0 || bien.getTaille() <= tailleMax) &&
                (tailleMin == 0 || bien.getTaille() >= tailleMin))
            {
                biensTrouves.add(bien);
            }
        }
        return biensTrouves;
    }
    
    // Affecter un bien à un agent immobilier
    public static void affecterBienAAgentImmobilier(int indexBien, String agentImmobilier) {
        BienImmobilier bien = biensImmobiliers.get(indexBien);
        bien.setAgentImmobilier(agentImmobilier);
    }
    
    
    
    
 
}



