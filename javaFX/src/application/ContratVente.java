package application;

public class ContratVente extends Contrat {
    private double prixVente;
    private String transfertPropriete;
    private String garantie;
    private String conditionsPaiement;
    private ClientAcheteur ClientAcheteur ;
    
    // Constructeur
    public ContratVente(String typee, String bienImmobiliers, String clients, String montant, String dates,
            String paiementEffectue, String dateEcheance, String clientVendeur, String numeroContrat, double prixVente, String transfertPropriete, String garantie, String conditionsPaiement, ClientAcheteur ClientAcheteur) {
    
    super(typee, bienImmobiliers, clients, montant, dates, paiementEffectue, dateEcheance, clientVendeur, numeroContrat);
    this.prixVente = prixVente;
    this.transfertPropriete = transfertPropriete;
    this.garantie = garantie;
    this.conditionsPaiement = conditionsPaiement;
    this.ClientAcheteur = ClientAcheteur;
    }
    
    //getters et setters
  public double getPrixVente() {
    return prixVente;
  }
  public void setPrixVente(double prixVente) {
    this.prixVente = prixVente;
  }
  public String getTransfertPropriete() {
    return transfertPropriete;
  }
  public void setTransfertPropriete(String transfertPropriete) {
    this.transfertPropriete = transfertPropriete;
  }
  public String getGarantie() {
    return garantie;
  }
  public void setGarantie(String garantie) {
    this.garantie = garantie;
  }
  public String getConditionsPaiement() {
    return conditionsPaiement;
  }
  public void setConditionsPaiement(String conditionsPaiement) {
    this.conditionsPaiement = conditionsPaiement;
  }
  public ClientAcheteur getClientAcheteur() {
    return ClientAcheteur;
  }
  public void setClientAcheteur(ClientAcheteur clientAcheteur) {
    ClientAcheteur = clientAcheteur;
  }

  
    
    
    
}
