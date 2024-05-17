package application;

import java.time.LocalDate;

public class Contrat {
    private String typee;
    private String bienImmobiliers;
    private String clients;
    private String montant;
    private String dates;
    private String paiementEffectue;
    private String dateEcheance;
    private String clientVendeur;
    private String numeroContrat; 
    
    
 // Constructeur
    public Contrat(String typee, String bienImmobiliers, String clients, String montant, String dates,
                   String paiementEffectue, String dateEcheance, String clientVendeur, String numeroContrat) {
        this.typee = typee;
        this.bienImmobiliers = bienImmobiliers;
        this.clients = clients;
        this.montant = montant;
        this.dates = dates;
        this.paiementEffectue = paiementEffectue;
        this.dateEcheance = dateEcheance;
        this.clientVendeur = clientVendeur;
        this.numeroContrat = numeroContrat;
    }
    
    //getters et setters

    
    public String getTypee() {
        return typee;
    }

    public void setTypee(String typee) {
        this.typee = typee;
    }

    public String getBienImmobiliers() {
        return bienImmobiliers;
    }

    public void setBienImmobiliers(String bienImmobiliers) {
        this.bienImmobiliers = bienImmobiliers;
    }

    public String getClients() {
        return clients;
    }

    public void setClients(String clients) {
        this.clients = clients;
    }

    public String getMontant() {
        return montant;
    }

    public void setMontant(String montant) {
        this.montant = montant;
    }

    public String getDates() {
        return dates;
    }

    public void setDates(String dates) {
        this.dates = dates;
    }

    public String isPaiementEffectue() {
        return paiementEffectue;
    }

    public void setPaiementEffectue(String paiementEffectue) {
        this.paiementEffectue = paiementEffectue;
    }

    public String getDateEcheance() {
        return dateEcheance;
    }

    public void setDateEcheance(String dateEcheance) {
        this.dateEcheance = dateEcheance;
    }

    public String getClientVendeur() {
        return clientVendeur;
    }

    public void setClientVendeur(String clientVendeur) {
        this.clientVendeur = clientVendeur;
    }

    public String getNumeroContrat() {
        return numeroContrat;
    }

    public void setNumeroContrat(String numeroContrat) {
        this.numeroContrat = numeroContrat;
    }
}
