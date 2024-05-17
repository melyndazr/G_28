package application;

import java.time.LocalDateTime;

//Classe représentant un rendez-vous pour une visite de bien immobilier
public class RendezVous {
 private LocalDateTime dateHeure;
 private BienImmobilier bienImmobilier;
 private Client client;
 private ClientVendeur clientVendeur; 

 // Constructeur
 public RendezVous(LocalDateTime dateHeure, BienImmobilier bienImmobilier, Client client, ClientVendeur clientVendeur) {
     this.dateHeure = dateHeure;
     this.bienImmobilier = bienImmobilier;
     this.client = client;
     this.clientVendeur = clientVendeur;
 }

 // Getters et setters
 public LocalDateTime getDateHeure() {
     return dateHeure;
 }

 public void setDateHeure(LocalDateTime dateHeure) {
     this.dateHeure = dateHeure;
 }

 public BienImmobilier getBienImmobilier() {
     return bienImmobilier;
 }

 public void setBienImmobilier(BienImmobilier bienImmobilier) {
     this.bienImmobilier = bienImmobilier;
 }

 public Client getClient() {
     return client;
 }

 public void setClient(Client client) {
     this.client = client;
 }

 public ClientVendeur getClientVendeur() {
     return clientVendeur;
 }

 public void setClientVendeur(ClientVendeur clientVendeur) {
     this.clientVendeur = clientVendeur;
 }
}