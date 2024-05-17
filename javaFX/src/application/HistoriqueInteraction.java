package application;



import java.time.LocalDateTime;

	public class HistoriqueInteraction {
		private LocalDateTime date;
	    private String type; // Type d'interaction : achat, location, etc.
	    private String bienImmobilier; // Référence au bien immobilier associé à l'interaction
	   
	    // Constructeur
	    public HistoriqueInteraction(LocalDateTime date, String type, String bienImmobilier) {
	        this.date = date;
	        this.type = type;
	        this.bienImmobilier = bienImmobilier;
	        
	    }

	  public LocalDateTime getDate() {
	    return date;
	  }

	  public void setDate(LocalDateTime date) {
	    this.date = date;
	  }


	  public String getType() {
	    return type;
	  }

	  public void setType(String type) {
	    this.type = type;
	  }

	  public String getBienImmobilier() {
	    return bienImmobilier;
	  }

	  public void setBienImmobilier(String bienImmobilier) {
	    this.bienImmobilier = bienImmobilier;
	  }
	  
}
	    