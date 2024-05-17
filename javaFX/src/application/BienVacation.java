package application;


public class BienVacation extends BienImmobilier {
    private int capaciteAccueil;
    private String equipements;

    public BienVacation(String type, double taille, double prix, String localisation, String description, String agentImmobilier, int capaciteAccueil, String equipements) {
        super(type, taille, prix, localisation, description, agentImmobilier);
        this.capaciteAccueil = capaciteAccueil;
        this.equipements = equipements;
    }

    // Getters et setters 
    public int getCapaciteAccueil() {
        return capaciteAccueil;
    }

    public void setCapaciteAccueil(int capaciteAccueil) {
        this.capaciteAccueil = capaciteAccueil;
    }

    public String getEquipements() {
        return equipements;
    }

    public void setEquipements(String equipements) {
        this.equipements = equipements;
    }

    // Méthodes spécifiques
    public void reserverPourVacances(String dateDebut, String dateFin) {
        // Logique de réservation pour des périodes de vacances spécifiques
    }

    public double calculerTarifLocation() {
        // Logique de calcul du tarif de location
        return getPrix() * 0.1; // Exemple de calcul du tarif de location
    }
    
    public double calculerTarifLocation(String saison, int dureeLocation, boolean estBienEquipe) {
        // Coefficients pour ajuster le prix en fonction des critères
        double coefficientSaison = 1.0;
        double coefficientDuree = 1.0;
        double coefficientEquipement = 1.0;

        // Ajustement du coefficient en fonction de la saison
        if (saison.equalsIgnoreCase("été")) {
            coefficientSaison = 1.2; // En été le prix est augmenté de 20%
        }

        // Ajustement du coefficient en fonction de la durée de location
        coefficientDuree = 1.0 + (dureeLocation - 1) * 0.05; // on fait une augmentation linéaire de 5% pour chaque semaine de location supplémentaire

        // Ajustement du coefficient en fonction des équipements
        if (estBienEquipe) {
            coefficientEquipement = 1.2; // Si le bien est bien équipé le prix est augmenté de 20%
        }

        // Calcul du tarif de location en multipliant le prix initial par les coefficients
        double tarifLocation = getPrix() * coefficientSaison * coefficientDuree * coefficientEquipement;

        return tarifLocation;
    }
}