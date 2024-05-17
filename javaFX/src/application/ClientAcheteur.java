package application;



import java.util.ArrayList;
import java.util.List;

public class ClientAcheteur extends Client {
    private double budget;
    private String quartierPreference; // Remplace l'attribut "quartier" par "localisation"

    public ClientAcheteur(String nom, String adresse, String types, String demandes, String preferences, double budget, String quartierPreference) {
        super(nom, adresse, types, demandes, preferences);
        this.budget = budget;
        this.quartierPreference = quartierPreference;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public String getQuartierPreference() {
        return quartierPreference;
    }

    public void setQuartierPreference(String quartierPreference) {
        this.quartierPreference = quartierPreference;
    }

    public List<BienImmobilier> rechercherBiensAcheter(List<BienImmobilier> listeBiensDisponibles) {
        List<BienImmobilier> biensTrouves = new ArrayList<>();
        for (BienImmobilier bien : listeBiensDisponibles) {
            if (bien.getPrix() <= budget && bien.getLocalisation().equals(quartierPreference)) {
                biensTrouves.add(bien);
            }
        }
        return biensTrouves;
    }

    public void evaluerOffre(BienImmobilier bien, double offre) {
        if (offre <= budget) {
            System.out.println("L'offre est dans le budget.");
            if (bien.getLocalisation().equals(quartierPreference)) {
                System.out.println("La localisation correspond à vos préférences.");
            } else {
                System.out.println("La localisation ne correspond pas à vos préférences.");
            }
        } else {
            System.out.println("L'offre dépasse votre budget.");
        }
    }
}
