package application;


public class BienCommercial extends BienImmobilier {
    private double superficieMagasin;
    private String typeEntreprise;

    public BienCommercial(String type, double taille, double prix, String localisation, String description, String agentImmobilier, double superficieMagasin, String typeEntreprise) {
        super(type, taille, prix, localisation, description, agentImmobilier);
        this.superficieMagasin = superficieMagasin;
        this.typeEntreprise = typeEntreprise;
    }

    // Getters et setters 
    public double getSuperficieMagasin() {
        return superficieMagasin;
    }

    public void setSuperficieMagasin(double superficieMagasin) {
        this.superficieMagasin = superficieMagasin;
    }

    public String getTypeEntreprise() {
        return typeEntreprise;
    }

    public void setTypeEntreprise(String typeEntreprise) {
        this.typeEntreprise = typeEntreprise;
    }

    // Méthodes spécifiques
    // C'est une methode qui estime le revenu du bien commercial en fonction de la superficie
    public double calculerRevenuPotentiel() {
        double revenuPotentiel = superficieMagasin * 10000; // 10 000da par mètre carré
        return revenuPotentiel;
    }
}
