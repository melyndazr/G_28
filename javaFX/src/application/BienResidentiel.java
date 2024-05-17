package application;




public class BienResidentiel extends BienImmobilier {
    private int nombreChambres;
    private int nombreSallesBains;

    public BienResidentiel(String type, double taille, double prix, String localisation, String description, String agentImmobilier, int nombreChambres, int nombreSallesBains) {
        super(type, taille, prix, localisation, description, agentImmobilier);
        this.nombreChambres = nombreChambres;
        this.nombreSallesBains = nombreSallesBains;
    }

    // Getters et setters
    public int getNombreChambres() {
        return nombreChambres;
    }

    public void setNombreChambres(int nombreChambres) {
        this.nombreChambres = nombreChambres;
    }

    public int getNombreSallesBains() {
        return nombreSallesBains;
    }

    public void setNombreSallesBains(int nombreSallesBains) {
        this.nombreSallesBains = nombreSallesBains;
    }

    // Méthodes spécifiques
    // C'est une methode qui verifie la disponibilité du bien résidentiel
    public boolean verifierDisponibilite() {
        // Vérifier si le bien est actuellement occupé
        if (getAgentImmobilier() != null && !getAgentImmobilier().isEmpty()) {
            System.out.println("Ce bien est actuellement occupé par " + getAgentImmobilier());
            return false;
        } else {
            System.out.println("Ce bien est disponible.");
            return true;
        }
    }
 
}
