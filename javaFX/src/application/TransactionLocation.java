package application;

//Classe représentant une transaction de location immobilière
public class TransactionLocation extends TransactionImmobiliere {
 private ContratLocation contratLocation; // Contrat de location associé à la transaction de location

 // Constructeur
 public TransactionLocation(String type, double fraisTransaction, String notes, String statut, ContratLocation contratLocation) {
     super(type, fraisTransaction, notes, statut);
     this.contratLocation = contratLocation;
 }

 // Getter et setter pour l'attribut contratLocation
 public ContratLocation getContratLocation() {
     return contratLocation;
 }

 public void setContratLocation(ContratLocation contratLocation) {
     this.contratLocation = contratLocation;
 }
}