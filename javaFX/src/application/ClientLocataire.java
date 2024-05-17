package application;



import java.util.ArrayList;
import java.util.List;

public class ClientLocataire extends Client {
    private double budgetLocation;
    private int dureeLocation;

    public ClientLocataire(String nom, String adresse, String types, String demandes, String preferences, double budgetLocation, int dureeLocation) {
        super(nom, adresse, types, demandes, preferences);
        this.budgetLocation = budgetLocation;
        this.dureeLocation = dureeLocation;
    }

    public double getBudgetLocation() {
        return budgetLocation;
    }

    public void setBudgetLocation(double budgetLocation) {
        this.budgetLocation = budgetLocation;
    }

    public int getDureeLocation() {
        return dureeLocation;
    }

    public void setDureeLocation(int dureeLocation) {
        this.dureeLocation = dureeLocation;
    }

    // Méthode pour rechercher des biens immobiliers à louer
    public List<BienImmobilier> rechercherBiensLouer(List<BienImmobilier> listeBiensDisponibles) {
        List<BienImmobilier> biensTrouves = new ArrayList<>();
        for (BienImmobilier bien : listeBiensDisponibles) {
            if (bien.getPrix() <= budgetLocation) {
                biensTrouves.add(bien);
            }
        }
        return biensTrouves;
    }
 // Méthode pour négocier les termes du bail
    public void negocierBail(BienImmobilier bien, double loyerPropose) {
        if (loyerPropose <= budgetLocation) {
            System.out.println("Négociation en cours...");
            // Étape 1 : Vérification de la conformité du loyer proposé
            if (bien.getPrix() == loyerPropose) {
                System.out.println("Le loyer proposé est identique au prix du bien. Accord trouvé !");
            } else if (bien.getPrix() > loyerPropose) {
                System.out.println("Le loyer proposé est inférieur au prix du bien. C'est une bonne offre !");
            } else {
                System.out.println("Le loyer proposé est supérieur au prix du bien. Négociation nécessaire.");
                // Étape 2 : Discussion sur les termes spécifiques du bail
                System.out.println("Nous devons discuter de la durée du bail, des charges, etc.");
                // Étape 3 : Finalisation des termes
                System.out.println("Une fois les détails réglés, nous pouvons conclure le bail.");
            }
        } else {
            System.out.println("Le loyer proposé dépasse votre budget de location.");
        }
    }
}