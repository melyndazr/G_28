package application;

//Classe représentant une transaction de vente immobilière
public class TransactionVente extends TransactionImmobiliere {
 private ContratVente contratVente; // Contrat de vente associé à la transaction de vente

 // Constructeur
 public TransactionVente(String type, double fraisTransaction, String notes, String statut, ContratVente contratVente) {
     super(type, fraisTransaction, notes, statut);
     this.contratVente = contratVente;
 }

 // Getter et setter pour l'attribut contratVente
 public ContratVente getContratVente() {
     return contratVente;
 }

 public void setContratVente(ContratVente contratVente) {
     this.contratVente = contratVente;
 }
}