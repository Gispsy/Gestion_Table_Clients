package fr.gestion.gestion_table_client.model;

public class Client {
    //Attribut
    private String nom;
    private String prenom;
    private String ville;

    //Constructeur par defaut

    public Client(){}
    public Client(String nom, String prenom, String ville){
        this.nom = nom;
        this.prenom = prenom;
        this.ville = ville;
    }

    //Constructeur avec nom et prenom
    public Client(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    //Attribut prenom
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    //Attribut nom
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
}
