package application;


import java.time.LocalDate;

//Classe de base représentant une transaction immobilière
public class TransactionImmobiliere {
 protected String type; // Type de transaction : vente, location, etc.
 protected double fraisTransaction; // Frais associés à la transaction
 protected String notes; // Notes supplémentaires sur la transaction
 protected String statut; // Statut de la transaction : en cours, terminée, annulée, etc.
 private String contrat; // Contrat associé à la transaction
 private boolean paiementEffectue; // Indique si le paiement a été effectué
 private LocalDate dateEcheance; // Date d'échéance de la transaction

 // Constructeur
 public TransactionImmobiliere(String type, double fraisTransaction, String notes, String statut) {
     this.type = type;
     this.fraisTransaction = fraisTransaction;
     this.notes = notes;
     this.statut = statut;
 }

 // Méthode pour générer un contrat de location
 public void genererContratLocation() {
     this.contrat = "Contrat de location"; // Exemple de contenu du contrat
 }

 // Méthode pour générer un contrat de vente
 public void genererContratVente() {
     this.contrat = "Contrat de vente"; // Exemple de contenu du contrat
 }

 // Méthode pour enregistrer un paiement
 public void enregistrerPaiement(double montant, LocalDate date) {
     this.paiementEffectue = true;
     // Afficher un message pour indiquer que le paiement a été enregistré avec succès
     System.out.println("Paiement enregistré pour la transaction : " + this + ", montant : " + montant + ", date : " + date);
 }

 // Getters et setters pour les attributs
 public String getType() {
     return type;
 }

 public void setType(String type) {
     this.type = type;
 }

 public double getFraisTransaction() {
     return fraisTransaction;
 }

 public void setFraisTransaction(double fraisTransaction) {
     this.fraisTransaction = fraisTransaction;
 }

 public String getNotes() {
     return notes;
 }

 public void setNotes(String notes) {
     this.notes = notes;
 }

 public String getStatut() {
     return statut;
 }

 public void setStatut(String statut) {
     this.statut = statut;
 }

 public String getContrat() {
     return contrat;
 }

 public void setContrat(String contrat) {
     this.contrat = contrat;
 }

 public boolean isPaiementEffectue() {
     return paiementEffectue;
 }

 public void setPaiementEffectue(boolean paiementEffectue) {
     this.paiementEffectue = paiementEffectue;
 }

 public LocalDate getDateEcheance() {
     return dateEcheance;
 }

 public void setDateEcheance(LocalDate dateEcheance) {
     this.dateEcheance = dateEcheance;
 }
}