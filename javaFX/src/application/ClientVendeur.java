package application;



import java.util.List;

public class ClientVendeur extends Client {
    private double prixVenteSouhaite;
    private String detailsPropriete;

    public ClientVendeur(String nom, String adresse, String types, String demandes, String preferences, double prixVenteSouhaite, String detailsPropriete) {
        super(nom, adresse, types, demandes, preferences);
        this.prixVenteSouhaite = prixVenteSouhaite;
        this.detailsPropriete = detailsPropriete;
    }

    public double getPrixVenteSouhaite() {
        return prixVenteSouhaite;
    }

    public void setPrixVenteSouhaite(double prixVenteSouhaite) {
        this.prixVenteSouhaite = prixVenteSouhaite;
    }

    public String getDetailsPropriete() {
        return detailsPropriete;
    }

    public void setDetailsPropriete(String detailsPropriete) {
        this.detailsPropriete = detailsPropriete;
    }

 // Méthode pour lister une propriété à vendre
    public void listerProprieteAVendre(List<BienImmobilier> listeBiensAVendre, BienImmobilier proprieteAVendre) {
        listeBiensAVendre.add(proprieteAVendre);
        System.out.println("La propriété a été ajoutée à la liste des biens à vendre.");
    }


    // Méthode pour gérer les offres d'achat sur une propriété
    public void gererOffresAchat(BienImmobilier bien, double offre) {
        if (offre >= prixVenteSouhaite) {
            System.out.println("Offre acceptée ! La propriété est vendue.");
        } else {
            System.out.println("Offre refusée. Le prix de vente souhaité n'a pas été atteint.");
        }
    }

    // Méthode pour retirer une propriété de la liste des biens à vendre
    public void retirerProprieteAVendre(List<BienImmobilier> listeBiensAVendre, BienImmobilier propriete) {
        if (listeBiensAVendre.contains(propriete)) {
            listeBiensAVendre.remove(propriete);
            System.out.println("La propriété a été retirée de la liste des biens à vendre.");
        } else {
            System.out.println("La propriété n'était pas présente dans la liste des biens à vendre.");
        }
    }
}
