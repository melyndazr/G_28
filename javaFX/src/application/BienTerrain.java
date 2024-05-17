package application;





public class BienTerrain extends BienImmobilier {
    private double superficieTerrain;
    private String caracteristiquesTopographiques;

    public BienTerrain(String type, double taille, double prix, String localisation, String description, String agentImmobilier, double superficieTerrain, String caracteristiquesTopographiques) {
        super(type, taille, prix, localisation, description, agentImmobilier);
        this.superficieTerrain = superficieTerrain;
        this.caracteristiquesTopographiques = caracteristiquesTopographiques;
    }

    // Getters et setters 
    public double getSuperficieTerrain() {
        return superficieTerrain;
    }

    public void setSuperficieTerrain(double superficieTerrain) {
        this.superficieTerrain = superficieTerrain;
    }

    public String getCaracteristiquesTopographiques() {
        return caracteristiquesTopographiques;
    }

    public void setCaracteristiquesTopographiques(String caracteristiquesTopographiques) {
        this.caracteristiquesTopographiques = caracteristiquesTopographiques;
    }

    // Méthodes spécifiques
    // C'est une methode ou on s'assure que le terrain a les permis nécessaires pour tout développement prévu sur le terrain
    // tels que les permis de construction, les permis environnementaux
    // que le terrain a accès à l'eau, à l'assainissement, à l'électricité et à d'autres services publics nécessaires pour le développement
    public boolean verifierReglementationLocale() {
        boolean permisConstruction = verifierPermisConstruction();
        boolean permisEnvironnementaux = verifierPermisEnvironnementaux();
        boolean accesServicesPublics = verifierAccesServicesPublics();

        // Vérifie si tous les permis sont valides et si l'accès aux services publics est assuré
        return permisConstruction && permisEnvironnementaux && accesServicesPublics;
    }

    private boolean verifierPermisConstruction() {
        return true; //Supposons que les permis de construction sont valides
    }

    private boolean verifierPermisEnvironnementaux() {
        return true; //Supposons que les permis environnementaux sont valides
    }

    private boolean verifierAccesServicesPublics() {
        return true; //Supposons que l'accès aux services publics est assuré
    }

}
