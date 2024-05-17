package application;

public class ContratLocation extends Contrat {
    private double loyer;
    private ClientLocataire ClientLocataire ;
    private int dureeBail;
    private String entretienReparations;
    private String garantie;
    
    // Constructeur
    public ContratLocation(String typee, String bienImmobiliers, String clients, String montant, String dates,
            String paiementEffectue, String dateEcheance, String clientVendeur, String numeroContrat, double loyer, ClientLocataire clientLocataire, int dureeBail, String entretienReparations, String garantie) {
    	super(typee, bienImmobiliers, clients, montant, dates, paiementEffectue, dateEcheance, clientVendeur, numeroContrat);
    	this.loyer = loyer;
        this.ClientLocataire = clientLocataire;
        this.dureeBail = dureeBail;
        this.entretienReparations = entretienReparations;
        this.garantie = garantie;
 
}
    
    
    
    //getters et setters
  public double getLoyer() {
    return loyer;
  }
  public void setLoyer(double loyer) {
    this.loyer = loyer;
  }
  public int getDureeBail() {
    return dureeBail;
  }
  public void setDureeBail(int dureeBail) {
    this.dureeBail = dureeBail;
  }
  public String getEntretienReparations() {
    return entretienReparations;
  }
  public void setEntretienReparations(String entretienReparations) {
    this.entretienReparations = entretienReparations;
  }
  public String getGarantie() {
    return garantie;
  }
  public void setGarantie(String garantie) {
    this.garantie = garantie;
  }
  public ClientLocataire getClientLocataire() {
    return ClientLocataire;
  }
  public void setClientLocataire(ClientLocataire clientLocataire) {
    ClientLocataire = clientLocataire;
  }

   
    
}