
package application;

import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.*;
import java.awt.*;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.border.AbstractBorder;
import java.awt.event.*;
import javax.swing.border.*;
import javax.swing.event.*;
import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import javax.swing.table.TableRowSorter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import application.GestionnaireBiensImmobilier;
import application.Main.DashedBorder;
import application.Main.RoundBorder;
import java.util.Map;
import java.util.HashMap;




public class Main extends JFrame {
	
 private JTable table;
 private JPanel contentPane;
 private JTextField textField;
 private JTextField textField_1;
 private JPasswordField passwordField;
 private JPasswordField passwordField_1;
 private String pageName;

 int xx, xy;

 public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				Main frame = new Main();
				frame.setUndecorated(true); 
				frame.setVisible(true); 
			} catch (Exception e) {
				e.printStackTrace(); 
			}
		});
	}
 


 private Map<String, JTextField> textFieldMap = new HashMap<>();
 
//Constructeur de la classe Main
 public Main() {
	// Configuration initiale de la fenêtre
 setBackground(Color.WHITE);
 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 setBounds(100, 100, 900, 550); 
 
 contentPane = new JPanel();
 contentPane.setBackground(Color.WHITE);
 contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
 setContentPane(contentPane);
 contentPane.setLayout(null);
 
//Création d'un panneau latéral à gauche avec un fond gris foncé
 JPanel panel = new JPanel();
 panel.setBackground(Color.DARK_GRAY);
 panel.setBounds(0, 0, 346, 550);
 contentPane.add(panel);
 panel.setLayout(null);

//Label de bienvenue au centre du panneau latéral
 JLabel lblNewLabel = new JLabel("Bienvenue !");
 lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
 lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
 lblNewLabel.setForeground(new Color(240, 248, 255));
 lblNewLabel.setBounds(100, 275, 150, 27);
 panel.add(lblNewLabel);

//Label pour afficher une image
 JLabel label = new JLabel("");
 label.addMouseListener(new MouseAdapter() {
 @Override
 public void mousePressed(MouseEvent e) {
 xx = e.getX();
 xy = e.getY();
 }
 });


 label.setBounds(-38, 0, 420, 275);
 label.setVerticalAlignment(SwingConstants.TOP);
 ImageIcon imageIcon = new ImageIcon("C:\\Users\\HP\\Downloads\\Telegram Desktop\\photo_2024-05-10_22-42-38.jpg");
 int imageWidth = imageIcon.getIconWidth();
 int imageHeight = imageIcon.getIconHeight();

//Redimensionner l'image pour qu'elle s'adapte au labe
 int labelWidth = 350;
 int labelHeight = 275;
 if (imageWidth > labelWidth || imageHeight > labelHeight) {
   double scaleX = (double) labelWidth / imageWidth;
   double scaleY = (double) labelHeight / imageHeight;
   double scale = Math.min(scaleX, scaleY);

   imageWidth = (int) (imageWidth * scale);
   imageHeight = (int) (imageHeight * scale);
 }

	// Créer une version redimensionnée de l'image et la définir dans le label
 Image scaledImage = imageIcon.getImage().getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH);
 ImageIcon scaledIcon = new ImageIcon(scaledImage);
 label.setIcon(scaledIcon);
 label.setBounds(0, 0, imageWidth, imageHeight);
 panel.add(label);



	// Label pour la description et les instructions
 JLabel lblDescription = new JLabel("<html><div style='text-align: center;'>"
 + "<p> &nbsp; MDM notre plateforme de gestion immobilière !</p>"
 + "<p>Connectez-vous pour accéder à vos outils professionnels.</p>"
 + "<p>Besoin d'aide ? Contactez notre service informatique.</p>"
 + "</div></html>");

 lblDescription.setHorizontalAlignment(SwingConstants.LEFT);
 lblDescription.setForeground(new Color(240, 248, 255));
 lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 13));
 lblDescription.setBounds(5, 300, 500, 115);
 panel.add(lblDescription);


 // Création du bouton "Se connecter" avec des coins arrondis
 JButton button = new RoundButton("Se connecter ");
 button.setForeground(Color.WHITE);
 button.setBackground(new Color(64, 224, 208));
 button.setBounds(395, 300, 283, 36);
 contentPane.add(button);
 button.addMouseListener(new MouseAdapter() {
   @Override
     public void mouseClicked(MouseEvent e) {
        showInscriptionPage();
        }
 });

 // Création du champ de texte avec des coins arrondis
 textField = new RoundTextField();
 textField.setBounds(395, 150, 283, 36);
 contentPane.add(textField);
 textField.setColumns(10);

 // Libellé "Nom d'utilisateur"
 JLabel lblUsername = new JLabel("Nom d'utilisateur");
 lblUsername.setBounds(395, 123, 114, 14);
 contentPane.add(lblUsername);


 // Libellé "Mot de passe"
 JLabel lblPassword = new JLabel("Mot de passe");
 lblPassword.setBounds(395, 204, 96, 14);
 contentPane.add(lblPassword);


 // Création du champ de mot de passe avec des coins arrondis
 passwordField = new RoundPasswordField();
 passwordField.setBounds(395, 229, 283, 36);
 contentPane.add(passwordField);


 // Bouton "X" pour fermer la fenêtre
 JLabel lbl_close = new JLabel("X");
 lbl_close.addMouseListener(new MouseAdapter() {
   @Override
 public void mouseClicked(MouseEvent arg0) {
 System.exit(0);
    }
 });

lbl_close.setHorizontalAlignment(SwingConstants.CENTER);
lbl_close.setForeground(new Color(64, 224, 208));
lbl_close.setFont(new Font("Tahoma", Font.PLAIN, 18));
lbl_close.setBounds(850, 0, 37, 27);
contentPane.add(lbl_close);
}




 // Créer un bouton arrondi avec le texte donné
private JButton createRoundButton(String text) {
JButton button = new JButton(text);
button.setForeground(Color.WHITE);
button.setBackground(new Color(64, 224, 208));
button.setOpaque(false);
button.setBorderPainted(false); 
button.setFocusPainted(false); 
button.setFont(new Font("Tahoma", Font.PLAIN, 14));
return button;
}




 // Classe RoundTextField pour créer un champ de texte avec des coins arrondis
public class RoundTextField extends JTextField {
private Shape shape;
public RoundTextField() {
setOpaque(false); 
}
protected void paintComponent(Graphics g) {
 g.setColor(getBackground());
 g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20); 
 super.paintComponent(g);
 }
protected void paintBorder(Graphics g) {
g.setColor(getForeground());
g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20); 
}
 public boolean contains(int x, int y) {
if (shape == null || !shape.getBounds().equals(getBounds())) {
shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 20, 20); 
}
return shape.contains(x, y);
}
 }


// Classe RoundPasswordField pour créer un champ de mot de passe avec des coins arrondis
public class RoundPasswordField extends JPasswordField {
 private Shape shape;
 public RoundPasswordField() {
 setOpaque(false); 
 }
protected void paintComponent(Graphics g) {
 g.setColor(getBackground());
 g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
 super.paintComponent(g);
}

protected void paintBorder(Graphics g) {
g.setColor(getForeground());
g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20); 
}
 public boolean contains(int x, int y) {
if (shape == null || !shape.getBounds().equals(getBounds())) {
shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 20, 20); 
}
return shape.contains(x, y);
 }
}

 // Classe RoundButton pour créer un bouton avec des coins arrondis
public class RoundButton extends JButton {
private Shape shape;
public RoundButton(String label) {
super(label);
setOpaque(false); 
}
protected void paintComponent(Graphics g) {
g.setColor(getBackground());
g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20); 
 super.paintComponent(g);
}
protected void paintBorder(Graphics g) {
g.setColor(getForeground());
g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
}
 public boolean contains(int x, int y) {
if (shape == null || !shape.getBounds().equals(getBounds())) {
shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 20, 20); 
}
return shape.contains(x, y);
}
}


//Méthode pour afficher la page d'inscription
private void showInscriptionPage() {
contentPane.removeAll();
contentPane.setLayout(new BorderLayout());

// Panel pour le côté gauche
JPanel leftPanel = new JPanel(new BorderLayout());
leftPanel.setPreferredSize(new Dimension((int)(contentPane.getWidth() * 0.25), contentPane.getHeight()));
leftPanel.setBackground(Color.WHITE); 

 // Barre noire horizontale sur le côté gauche
 JPanel blackBar = new JPanel();
 blackBar.setBackground(Color.BLACK);
 blackBar.setPreferredSize(new Dimension(1, leftPanel.getHeight() )); 
 leftPanel.add(blackBar, BorderLayout.EAST); 
 
 // Ajouter le leftPanel à contentPane
 contentPane.add(leftPanel, BorderLayout.EAST);
 
// Logo
ImageIcon logoIcon = new ImageIcon("C:\\Users\\HP\\Downloads\\Telegram Desktop\\photo_2024-05-10_22-42-38.jpg");
Image image = logoIcon.getImage();
int logoWidth = 150; 
 int logoHeight = (int)(((double)logoWidth / image.getWidth(null)) * image.getHeight(null)); 
Image scaledImage = image.getScaledInstance(logoWidth, logoHeight, Image.SCALE_SMOOTH); 
 ImageIcon scaledLogoIcon = new ImageIcon(scaledImage);
JLabel logoLabel = new JLabel(scaledLogoIcon);
leftPanel.add(logoLabel, BorderLayout.NORTH);

 // Boutons pour la gestion
 JPanel gestionPanel = new JPanel();
gestionPanel.setLayout(new GridLayout(5, 1, 0, 10)); 
gestionPanel.setOpaque(false); 

// Ajout d'une marge en haut pour déplacer les boutons vers le bas
 gestionPanel.setBorder(BorderFactory.createEmptyBorder(50, 0, 0, 0));
 
 // Bouton "Gestion des biens immobiliers"
JButton gestionBiensButton = createGestionButton("<html> &nbsp; &nbsp; Gestion des<br>biens immobiliers</html>");
gestionBiensButton.addActionListener(e -> showGestionPage("Biens immobiliers"));
// Redimensionner la police pour s'adapter au texte complet
 Font buttonFont = gestionBiensButton.getFont();
Font newFont = buttonFont.deriveFont(buttonFont.getStyle(), 12); 
gestionBiensButton.setFont(newFont); 
 gestionPanel.add(gestionBiensButton);
 
// Bouton "Gestion des clients"
JButton gestionClientsButton = createGestionButton("Gestion des clients");
gestionClientsButton.addActionListener(e -> showGestionPage("Clients"));
 gestionPanel.add(gestionClientsButton);
 
// Bouton "Gestion des transactions"
JButton gestionTransactionsButton = createGestionButton("Gestion des transactions");
 gestionTransactionsButton.addActionListener(e -> showGestionPage("Transactions"));
gestionPanel.add(gestionTransactionsButton);

 // Bouton "Gestion des contrats"
JButton gestionContratsButton = createGestionButton("Prise des rendez-vous ");
gestionContratsButton.addActionListener(e -> showGestionPage("Rendez-vous"));
 gestionPanel.add(gestionContratsButton);
 
// Bouton "Autre option de gestion"
 JButton autreOptionButton = createGestionButton("Autre option de gestion");
 autreOptionButton.addActionListener(e -> showGestionPage("Autre option"));
 gestionPanel.add(autreOptionButton);
leftPanel.add(gestionPanel, BorderLayout.CENTER);

// Ajout du panel gauche à la contentPane
contentPane.add(leftPanel, BorderLayout.WEST);

// Panel pour le côté droit (initialisé avec un message par défaut)
 JPanel rightPanel = new JPanel();
 rightPanel.setBackground(Color.WHITE); 
 rightPanel.setLayout(new BorderLayout());

 // Créez une ImageIcon à partir de votre image
 ImageIcon imageIcon = new ImageIcon("C:\\Users\\HP\\Downloads\\Telegram Desktop\\photo_2024-05-17_00-47-39.jpg");

 // Créez un JLabel pour afficher l'image
 JLabel imageLabel = new JLabel(imageIcon);

 // Assurez-vous que l'image est centrée dans le JLabel
 imageLabel.setHorizontalAlignment(SwingConstants.CENTER);

 // Ajoutez le JLabel contenant l'image au rightPanel
 rightPanel.add(imageLabel, BorderLayout.CENTER);
 contentPane.add(rightPanel, BorderLayout.CENTER);
 // Redessiner la contentPane
contentPane.revalidate();
 contentPane.repaint();
}




 // Méthode pour créer les boutons de gestion
private JButton createGestionButton(String label) {
JButton button = new JButton(label);
 button.setPreferredSize(new Dimension((int)(contentPane.getWidth() * 0.8), 40)); 
 button.setBackground(Color.WHITE); 
 button.setBorder(new RoundBorder(new Color(64, 224, 208), 15)); 
 return button;
}


 // Méthode pour afficher la page de gestion spécifique dans le côté droit
private void showGestionPage(String pageName) {
// Panel pour le côté droit
JPanel rightPanel = new JPanel();
 rightPanel.setBackground(Color.WHITE); // Fond blanc
 rightPanel.setLayout(new BorderLayout());

//Créer un bouton "X" pour fermer la fenêtre
 JLabel lbl_close = new JLabel("X");
 lbl_close.addMouseListener(new MouseAdapter() {
     @Override
     public void mouseClicked(MouseEvent arg0) {
         System.exit(0);
     }
 });
 lbl_close.setHorizontalAlignment(SwingConstants.CENTER);
 lbl_close.setForeground(new Color(64, 224, 208));
 lbl_close.setFont(new Font("Tahoma", Font.PLAIN, 18));
 lbl_close.setBounds(850, 0, 37, 27);

 // Créer un panneau pour contenir le bouton "X" et le placer à droite
 JPanel closeButtonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
 closeButtonPanel.setBackground(Color.WHITE); // Fond blanc pour s'adapter à votre interface
 closeButtonPanel.add(lbl_close); // Ajouter le bouton "X" au panneau de fermeture

 // Créer un espace vertical flexible pour déplacer le bouton "X" vers le bas
 rightPanel.add(Box.createVerticalGlue());

 // Ajouter le panneau de fermeture au panneau droit
 rightPanel.add(closeButtonPanel);

 
// Déclaration d'une map pour stocker les champs de texte avec leur nom
 Map<String, JTextField> textFieldMap = new HashMap<>();
// Appeler la méthode pour créer un bouton "+ Nouveau" pour la gestion des biens immobiliers
 if (pageName.equals("Biens immobiliers")) {
String[] fieldNames = {"Type", "Taille", "Prix", "Localisation", "Description", "Agent immobilier"};
 JButton nouveauButton = createNouveauButton("+ Nouveau bien immobiliers", fieldNames, pageName);
 rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
 rightPanel.add(nouveauButton, BorderLayout.NORTH);
 JButton supprimerButton = createSupprimerButton("- Supprimer bien immobilier", "Entrez le type du bien immobilier à supprimer :", pageName);
 rightPanel.add(supprimerButton, BorderLayout.NORTH);
 afficherListe(pageName, fieldNames, rightPanel);

 }



 // Appeler la méthode pour créer un bouton "+ Nouveau" pour la gestion des clients
 if (pageName.equals("Clients")) {
String[] fieldNames = {"Nom", "Adresse", "Type", "Préférences", "Demandes"};
JButton nouveauButton = createNouveauButton("+ Nouveau client", fieldNames, pageName);
 rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS)); // Définit la disposition verticale
 rightPanel.add(nouveauButton, BorderLayout.NORTH);
 JButton supprimerButton = createSupprimerButton("- Supprimer client", "Entrez le nom du client à supprimer :", pageName);
 rightPanel.add(supprimerButton, BorderLayout.NORTH);
 afficherListe(pageName, fieldNames, rightPanel);
 }

 // Appeler la méthode pour créer un bouton "+ Nouveau" pour la gestion des transactions
if (pageName.equals("Transactions")) {
String[] fieldNames = {"Type", "Bien immobilier", "Client", "Montant", "Date", "Paiement effectué", "Date d'échéance", "Client vendeur", "Numéro de contrat"};
JButton nouveauButton = createNouveauButton("+ Nouvelle transactions ", fieldNames, pageName);
rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS)); // Définit la disposition verticale
rightPanel.add(nouveauButton, BorderLayout.NORTH);
JButton supprimerButton = createSupprimerButton("- Supprimer transaction", "Entrez le numéro de contrat de la transaction à supprimer :", pageName);
rightPanel.add(supprimerButton, BorderLayout.NORTH);
afficherListe(pageName, fieldNames, rightPanel);
 }

//Appeler la méthode pour créer un bouton "+ Nouveau" pour la gestion des transactions
if (pageName.equals("Rendez-vous")) {
    String[] fieldNames = {"Date-Heure","Client", "Bien immobilier", "Client proprietaire "};
    JButton nouveauButton = createNouveauButton("+ Nouveau rendez-vous", fieldNames, pageName);
    rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS)); // Définit la disposition verticale

   rightPanel.add(nouveauButton, BorderLayout.NORTH);
   JButton supprimerButton = createSupprimerButton("-Supprimer rendez-vous", "Entrez la date-heure du rendez-vous à supprimer :", pageName);
   rightPanel.add(supprimerButton, BorderLayout.NORTH);
   afficherListe(pageName, fieldNames, rightPanel);
}

if (pageName.equals("Autre option")) {            

    // Suppose que vous avez déjà une liste d'employés
    List<Employee> employees = new ArrayList<>();
    employees.add(new Employee("LETTAT MELISSA","Gestionnaire de biens immobiliers", 900000));
    employees.add(new Employee("ZERROUKI MELYNDA", "Responsable des relations client", 900000));
    employees.add(new Employee("CHAOUCHE DINA", "Spécialiste en marketing immobilier", 900000));
    employees.add(new Employee("BENCHIKHE AYA", "Assistant administratif", 800000  ));
    employees.add(new Employee("BENZAOUCH HAMAMA", "Agent de location ", 500000));
    employees.add(new Employee("CHERKI SARAH", " Spécialiste en finance immobilière ", 500000));
    employees.add(new Employee("ZEDIRI WIDAD", "Agent immobilier", 700000));
   
    // Ajoutez d'autres employés si nécessaire

    // Appel de la fonction pour créer le bouton "Afficher la liste des employés"
    JButton afficherListeEmployesButton = createAfficherListeEmployesButton("Afficher la liste des employés", "Veuillez sélectionner un employé à supprimer :", employees);

    // Ajoutez le bouton "Afficher la liste des employés" à votre conteneur graphique, par exemple, un JPanel
    rightPanel.add(afficherListeEmployesButton, BorderLayout.WEST);


    // Créez le bouton "Imprimer"
    JButton imprimerButton = new JButton("Imprimer le contrat");
    imprimerButton.setPreferredSize(new Dimension(200, 100)); // Définir une taille personnalisée pour le bouton
    imprimerButton.setFont(new Font("Arial", Font.BOLD, 14)); // Définir la police et la taille du texte
    imprimerButton.setBackground(Color.WHITE); // Fond blanc
    imprimerButton.setBorder(new RoundBorder(new Color(64, 224, 208), 15)); // Contour arrondi en bleu (peut être ajusté selon vos préférences)

 // Ajoutez un gestionnaire d'événements au bouton "Imprimer"
    imprimerButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Demander à l'utilisateur d'entrer le numéro du contrat
            String numeroContrat = JOptionPane.showInputDialog(null, "Entrez le numéro du contrat à imprimer :");

            // Vérifier si l'utilisateur a annulé ou a laissé le champ vide
            if (numeroContrat != null && !numeroContrat.isEmpty()) {
              JOptionPane.showMessageDialog(null, "Le contrat  " + numeroContrat + " est en cours d'impression...", "Impression en cours", JOptionPane.INFORMATION_MESSAGE);

                // Afficher un message indiquant que le contrat a été imprimé
                JOptionPane.showMessageDialog(null, "Le contrat  " + numeroContrat + " a été imprimé.", "Contrat imprimé", JOptionPane.INFORMATION_MESSAGE);
            } else {
                // Afficher un message si aucun numéro de contrat n'a été saisi
                JOptionPane.showMessageDialog(null, "Aucun numéro de contrat saisi.", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
    });


    
    // Ajoutez les boutons à un JPanel
    JPanel buttonPanel = new JPanel();
    buttonPanel.add(imprimerButton); // Ajoutez le bouton "Imprimer" au JPanel
    buttonPanel.add(afficherListeEmployesButton);

    // Ajoutez le JPanel contenant le bouton "Imprimer" à votre conteneur graphique, par exemple, un JPanel
    rightPanel.add(buttonPanel, BorderLayout.WEST);
}

 // Remplacer le contenu du côté droit



 contentPane.remove(1); // Supprimer le panel droit existant
contentPane.add(rightPanel, BorderLayout.CENTER); // Ajouter le nouveau panel droit
 // Redessiner la contentPane
contentPane.revalidate();
 contentPane.repaint();



 }
 


private JButton createAfficherListeEmployesButton(String label, String dialogMessage, List<Employee> employees) {
    JButton afficherListeEmployesButton = new JButton(label);
    afficherListeEmployesButton.setPreferredSize(new Dimension(200, 100)); // Taille par défaut
    afficherListeEmployesButton.setBackground(Color.WHITE); // Fond blanc
    afficherListeEmployesButton.setBorder(new RoundBorder(new Color(64, 224, 208), 15)); // Contour arrondi en bleu (peut être ajusté selon vos préférences)

    // Ajout d'un écouteur d'événements au bouton
    afficherListeEmployesButton.addActionListener(e -> {
        // Création d'un tableau de données pour afficher la liste des employés
        Object[][] data = new Object[employees.size()][3]; // Supposons que chaque employé a un nom, un poste et un salaire

        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            data[i][0] = employee.getNom();
            data[i][1] = employee.getPoste();
            data[i][2] = employee.getSalaire();
        }

        // Création des titres de colonnes
        String[] columnNames = {"Nom", "Prénom", "Salaire"};

        // Création d'un modèle de tableau avec les données et les titres de colonnes
        DefaultTableModel model = new DefaultTableModel(data, columnNames);

        // Création de la JTable avec le modèle de tableau
        JTable table = new JTable(model);

        // Affichage de la JTable dans une JOptionPane avec un JScrollPane pour la rendre scrollable
        JOptionPane.showMessageDialog(contentPane, new JScrollPane(table), "Liste des employés", JOptionPane.PLAIN_MESSAGE);
    });

    return afficherListeEmployesButton;
}





private JButton createSupprimerButton(String label, String dialogMessage, String pageName) {
    JButton supprimerButton = new JButton(label);
    supprimerButton.setPreferredSize(new Dimension(100, 30)); // Taille par défaut
    supprimerButton.setBackground(Color.WHITE); // Fond blanc
    supprimerButton.setBorder(new RoundBorder(new Color(255, 99, 71), 15)); // Contour arrondi en rouge (peut être ajusté selon vos préférences)

    // Ajout d'un écouteur d'événements au bouton
    supprimerButton.addActionListener(e -> {
        String userInput = JOptionPane.showInputDialog(contentPane, dialogMessage, "Supprimer", JOptionPane.PLAIN_MESSAGE);
        if (userInput != null) {
        	switch (pageName) {
        case "Biens immobiliers":
            GestionnaireBiensImmobilier.supprimerBienImmobilierParType(userInput);
            // Ici, vous pouvez actualiser votre interface utilisateur pour refléter la suppression de l'élément
            JOptionPane.showMessageDialog(contentPane, "Bien immobilier supprimé avec succès.", "Suppression réussie", JOptionPane.INFORMATION_MESSAGE);
            break;
            
        case "Clients":
        	GestionnaireBiensImmobilier.supprimerClientParNom(userInput);
        	JOptionPane.showMessageDialog(contentPane, "Client supprimé avec succès.", "Suppression réussie", JOptionPane.INFORMATION_MESSAGE);
        	break;
        	
        case "Transactions":
        	GestionnaireBiensImmobilier.supprimerTransactionParNumeroContrat(userInput);
        	JOptionPane.showMessageDialog(contentPane, "Transaction supprimé avec succès.", "Suppression réussie", JOptionPane.INFORMATION_MESSAGE);
        	break;
        	
        	} 
        }
    });
    return supprimerButton;
}




private void afficherListe(String pageName, String[] fieldNames, JPanel rightPanel) {
        // Créer le modèle de tableau avec les champs spécifiés
        DefaultTableModel model = new DefaultTableModel();
        for (String fieldName : fieldNames) {
            model.addColumn(fieldName);
        }

        // Créer le tableau avec le modèle spécifié
        JTable table = new JTable(model);

        // Définir le rendu personnalisé pour les cellules du tableau avec une couleur de fond blanche
        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                ((JComponent) cellComponent).setBackground(Color.WHITE); // Définir la couleur de fond des cellules
                return cellComponent;
            }
        });

        // Créer le TableRowSorter pour filtrer les lignes du tableau
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        table.setRowSorter(sorter);

        // Créer le JScrollPane pour le tableau
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(200, 200)); // Ajustez les dimensions selon vos besoins

        // Créer le JPanel avec BorderLayout
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBackground(Color.WHITE); // Fond blanc

        // Créer un JPanel pour contenir la barre de recherche et le bouton
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));

        // Créer une icône de loupe
        ImageIcon loupeIcon = new ImageIcon("loupe.png");
        JLabel loupeLabel = new JLabel(loupeIcon);

        // Créer un JTextField pour la barre de recherche
        JTextField searchField = new JTextField();
        searchField.setPreferredSize(new Dimension(200, 30));
        searchField.setFont(new Font("Arial", Font.PLAIN, 16));
        searchField.setText("Recherche");
        searchField.setForeground(Color.GRAY);
        searchField.setToolTipText("Rechercher...");
        //searchField.setBorder(new RoundBorder(new Color(64, 224, 208), 15)); // Contour arrondi en vert turquoise


        // Ajouter un FocusListener pour le champ de recherche
        searchField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (searchField.getText().equals("Recherche")) {
                    searchField.setText("");
                    searchField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (searchField.getText().isEmpty()) {
                    searchField.setForeground(Color.GRAY);
                    searchField.setText("Recherche");
                }
            }
        });

        // Ajouter un gestionnaire d'événements pour la recherche
        searchField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String text = searchField.getText();
                if (text.trim().length() == 0) {
                    sorter.setRowFilter(null);
                } else {
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }
        });
        // Ajouter le symbole de loupe et le champ de recherche au JPanel
        topPanel.add(loupeLabel);
        topPanel.add(Box.createRigidArea(new Dimension(5, 0))); // Ajouter un espace entre l'icône et le champ de recherche
        topPanel.add(searchField);


// Créer un JButton pour afficher "LISTE"
        JButton buttonListe = new JButton("LISTE");
        buttonListe.setPreferredSize(new Dimension(100, 30)); // Définir une taille personnalisée pour le bouton
        buttonListe.setFont(new Font("Arial", Font.BOLD, 16)); // Définir la police et la taille du texte
        buttonListe.setHorizontalAlignment(SwingConstants.CENTER); // Centrer le texte horizontalement
        buttonListe.setBackground(Color.WHITE); // Définir l'arrière-plan en blanc
        buttonListe.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Ajouter une marge autour du bouton
        buttonListe.setBorder(new RoundBorder(new Color(64, 224, 208), 15)); // Contour arrondi en vert turquoise

        // Ajouter un gestionnaire d'événements au bouton "LISTE"
        buttonListe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GestionnaireBiensImmobilier gestionnaire = new GestionnaireBiensImmobilier();
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.setRowCount(0); // Clear existing rows
                if ("Biens immobiliers".equals(pageName)) {
                    List<BienImmobilier> biens = gestionnaire.recupererTousBiensImmobilier();
                    gestionnaire.afficherListeBiens(biens, model);
                } else if ("Clients".equals(pageName)) {
                    List<Client> clients = gestionnaire.recupererTousClients();
                    gestionnaire.afficherListeClients(clients, model);
                } else if ("Transactions".equals(pageName)) {
                    List<Contrat> contrats = gestionnaire.recupererTousContrats();
                    gestionnaire.afficherListeContrats(contrats, model);
                }
            }
        });

        // Ajouter le bouton "LISTE" au panneau supérieur
        topPanel.add(buttonListe);

        // Ajouter le panneau supérieur (recherche + bouton) au panneau inférieur
        bottomPanel.add(topPanel, BorderLayout.NORTH);

        // Ajouter le JScrollPane en bas
        bottomPanel.add(scrollPane, BorderLayout.CENTER);

        // Ajouter le JPanel au panneau droit
        rightPanel.add(bottomPanel, BorderLayout.CENTER);
    }




 private JButton createNouveauButton(String label, String[] fieldNames, String pageName) {
 JButton nouveauButton = new JButton(label);
nouveauButton.setPreferredSize(new Dimension(100, 30)); // Taille par défaut
nouveauButton.setBackground(Color.WHITE); // Fond blanc
 nouveauButton.setBorder(new RoundBorder(new Color(64, 224, 208), 15)); // Contour arrondi en vert turquoise
 
 nouveauButton.addActionListener(e -> {
// Panel pour le contenu de la page "+ Nouveau"
JPanel nouveauPanelContent = new JPanel();
nouveauPanelContent.setLayout(new BorderLayout()); // Utilisation d'un BorderLayout
 nouveauPanelContent.setBackground(Color.WHITE); // Fond blanc
 nouveauPanelContent.setBorder(BorderFactory.createCompoundBorder(
BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Information", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Arial", Font.PLAIN, 18), Color.BLACK), // Cadre noir avec titre "Information"
 BorderFactory.createEmptyBorder(5, 5, 5, 5))); // Marge réduite autour du contenu

 // Bouton "Choisir Photo"
 if (pageName.equals("Biens immobiliers")) {
     JButton choisirPhotoButton = new JButton("Choisir Photo");
     choisirPhotoButton.setPreferredSize(new Dimension(200, 200)); // Définit la taille du bouton
     choisirPhotoButton.setBackground(Color.WHITE); // Fond blanc
     choisirPhotoButton.setBorder(new CompoundBorder(new DashedBorder(Color.BLACK, 1, 5), new EmptyBorder(5, 5, 5, 5))); // Bordure en pointillés avec des traits discontinus et couleur noire

     choisirPhotoButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
             // Ouvrir une boîte de dialogue de sélection de fichier pour choisir une photo
             JFileChooser fileChooser = new JFileChooser();
             int returnValue = fileChooser.showOpenDialog(null);
             if (returnValue == JFileChooser.APPROVE_OPTION) {
                 // L'utilisateur a choisi un fichier
                 // Vous pouvez maintenant utiliser le fichier sélectionné, par exemple :
                 String imagePath = fileChooser.getSelectedFile().getPath();
                 // Faites quelque chose avec le chemin de l'image sélectionnée
             }
         }
     });

     JPanel photoPanel = new JPanel();
     photoPanel.setBackground(Color.WHITE); // Fond blanc pour le panneau
     photoPanel.add(choisirPhotoButton);

     nouveauPanelContent.add(photoPanel, BorderLayout.WEST); // Ajouter le panneau contenant le bouton "Choisir Photo" à gauche
 }


 // Panel pour les champs de saisie
 JPanel fieldsPanel = new JPanel();
 fieldsPanel.setLayout(new GridLayout(fieldNames.length, 1, 10, 5)); // Nombre de lignes dynamique
 fieldsPanel.setBackground(Color.WHITE); // Fond blanc

 // Champs de saisie avec des contours arrondis et des labels
for (String fieldName : fieldNames) {
JLabel fieldLabel = new JLabel(fieldName);
 fieldLabel.setBorder(BorderFactory.createEmptyBorder(0, 100, 0, 0)); // Ajouter une marge à gauche pour rapprocher du rectangle
nouveauPanelContent.add(fieldLabel);
 JTextField textField1 = new JTextField(fieldName);
textField1.setForeground(Color.GRAY);
textField1.addFocusListener(new FocusAdapter() {
 @Override
public void focusGained(FocusEvent e) {
 if (textField1.getText().equals(fieldName)) {
 textField1.setText("");
 textField1.setForeground(Color.BLACK);

 }
}
@Override
 public void focusLost(FocusEvent e) {
 if (textField1.getText().isEmpty()) {
 textField1.setText(fieldName);
textField1.setForeground(Color.GRAY);
 }
 }
 });

 textField1.setBorder(new RoundBorder(new Color(64, 224, 208), 15));
 nouveauPanelContent.add(textField1);
 // Ajouter le label et le champ de saisie dans le panneau des champs
 fieldsPanel.add(fieldLabel);
 fieldsPanel.add(textField1);
 // Ajouter le champ de texte à la Map

 textFieldMap.put(fieldName, textField1);
 }

nouveauPanelContent.add(fieldsPanel, BorderLayout.CENTER); // Ajouter le panneau des champs à droite






 // Créer un panneau pour les boutons "Enregistrer" et "Annuler"
 JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
 buttonPanel.setBackground(Color.WHITE); // Fond blanc
 JButton saveButton = new JButton("Enregistrer");
 saveButton.setBackground(Color.WHITE);
 saveButton.setBorder(new RoundBorder(new Color(64, 224, 208), 10)); // Contour arrondi en vert turquoise
 buttonPanel.add(saveButton);
 saveButton.addMouseListener(new MouseAdapter() {
 @Override
 public void mouseClicked(MouseEvent e) {
 switch (pageName) {
 
 case "Biens immobiliers": // Première page (Bien immobilier)
 // Récupérer les données saisies par l'utilisateur
 String type = textFieldMap.get("Type").getText();
 double taille = Double.parseDouble(textFieldMap.get("Taille").getText());
 double prix = Double.parseDouble(textFieldMap.get("Prix").getText());
 String localisation = textFieldMap.get("Localisation").getText();
 String description = textFieldMap.get("Description").getText();
 String agentImmobilier = textFieldMap.get("Agent immobilier").getText();
 // Créer un objet BienImmobilier avec les données récupérées
 BienImmobilier bienImmobilier = new BienImmobilier(type, taille, prix, localisation, description, agentImmobilier);
 // Ajouter le bien immobilier à la base de données
 GestionnaireBiensImmobilier.ajouterBienImmobilier(bienImmobilier);
 // Afficher la page d'inscription
 showInscriptionPage();
 break;
 
 case "Clients": // Deuxième page (Client)
 // Récupérer les données saisies par l'utilisateur
 String nom = textFieldMap.get("Nom").getText();
 String adresse = textFieldMap.get("Adresse").getText();
 String types = textFieldMap.get("Type").getText();
 String preferences = textFieldMap.get("Préférences").getText();
 String demandes = textFieldMap.get("Demandes").getText();
 // Créer un objet Client avec les données récupérées
 Client client = new Client(nom, adresse, types, preferences, demandes);
 // Ajouter le client à la base de données
 GestionnaireBiensImmobilier.ajouterClient(client);
 break;
 
 case "Transactions":
 // Récupérer les données saisies par l'utilisateur
 String typee = textFieldMap.get("Type").getText();
 String bienImmobiliers = textFieldMap.get("Bien immobilier").getText();
 String clients = textFieldMap.get("Client").getText();
 String montant = textFieldMap.get("Montant").getText();
 String dates = textFieldMap.get("Date").getText();
 String paiementEffectue = textFieldMap.get("Paiement effectué").getText();
 String dateEcheance = textFieldMap.get("Date d'échéance").getText();
 String clientVendeur = textFieldMap.get("Client vendeur").getText();
 String numeroContrat = textFieldMap.get("Numéro de contrat").getText();
 // Créer un objet Contrat avec les données récupérées
 Contrat contrat = new Contrat(typee, bienImmobiliers, clients, montant, dates, paiementEffectue, dateEcheance, clientVendeur, numeroContrat);
 // Ajouter le contrat à la base de données
 GestionnaireBiensImmobilier.ajouterContrat(contrat);
 break;
 

 default:
 // Gérer d'autres cas si nécessaire
 break;
 }
 // Afficher une nouvelle page ou effectuer d'autres actions si nécessaire
 }
 });


// bouton annuler 
 JButton cancelButton = new JButton("Annuler");
cancelButton.setBackground(new Color(255, 153, 153)); // Fond rouge clair
cancelButton.setBorder(new RoundBorder(Color.BLACK, 10)); // Contour arrondi en noir
buttonPanel.add(cancelButton);

// Créer un nouveau panneau pour contenir le contenu et les boutons
 JPanel nouveauPanel = new JPanel(new BorderLayout());
nouveauPanel.setBackground(Color.WHITE); // Fond blanc
nouveauPanel.add(nouveauPanelContent, BorderLayout.NORTH);
 nouveauPanel.add(buttonPanel, BorderLayout.CENTER); // Ajouter les boutons sous les champs
 // Remplacer le contenu du côté droit avec le nouveau panneau
 contentPane.remove(1); // Supprimer le panel droit existant
 contentPane.add(nouveauPanel, BorderLayout.CENTER); // Ajouter le nouveau panel droit
 // Redessiner la contentPane
 contentPane.revalidate();
 contentPane.repaint();
 });
 return nouveauButton;
 }


 // Classe pour définir un contour arrondi pour les boutons
 class RoundBorder implements Border {
 private Color color;
 private int radius;
 public RoundBorder(Color color, int radius) {
 this.color = color;
 this.radius = radius;
 }
 public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
 Graphics2D graphics = (Graphics2D) g;
 graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
 graphics.setColor(color);
 graphics.draw(new RoundRectangle2D.Double(x, y, width - 1, height - 1, radius, radius));
 }
 public Insets getBorderInsets(Component c) {
 return new Insets(this.radius, this.radius, this.radius, this.radius);
 }
 public boolean isBorderOpaque() {
 return true;
 }
}

 
//Crée une bordure en pointillés personnalisée
 public class DashedBorder extends AbstractBorder {
     private Color color;
     private int thickness;
     private int gapSize;

     public DashedBorder(Color color, int thickness, int gapSize) {
         this.color = color;
         this.thickness = thickness;
         this.gapSize = gapSize;
     }

     @Override
     public Insets getBorderInsets(Component c) {
         return new Insets(thickness, thickness, thickness, thickness);
     }

     @Override
     public Insets getBorderInsets(Component c, Insets insets) {
         insets.set(thickness, thickness, thickness, thickness);
         return insets;
     }

     @Override
     public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
         g.setColor(color);
         for (int i = 0; i < width; i += gapSize * 2) {
             g.drawLine(x + i, y, x + i + gapSize, y);
         }
         for (int i = 0; i < height; i += gapSize * 2) {
             g.drawLine(x + width - thickness, y + i, x + width - thickness, y + i + gapSize);
         }
         for (int i = width - thickness; i > 0; i -= gapSize * 2) {
             g.drawLine(x + i, y + height - thickness, x + i - gapSize, y + height - thickness);
         }
         for (int i = height - thickness; i > 0; i -= gapSize * 2) {
             g.drawLine(x, y + i, x, y + i - gapSize);
         }
     }
}
 public class Employee {
	    private String nom;
	    private String Poste;
	    private double salaire;

	    public Employee(String nom, String Poste, double salaire) {
	        this.nom = nom;
	        this.Poste = Poste;
	        this.salaire = salaire;
	    }

	    // Ajoutez des getters et des setters si nécessaire
	    public String getNom() {
	        return nom;
	    }

	    public void setNom(String nom) {
	        this.nom = nom;
	    }

	    public String getPoste() {
	        return Poste;
	    }

	    public void setPoste(String Poste) {
	        this.Poste = Poste;
	    }

	    public double getSalaire() {
	        return salaire;
	    }

	    public void setSalaire(double salaire) {
	        this.salaire = salaire;
	    }
	}



}