package fr.gestion.gestion_table_client.model;

public class Client {
    //Attribut
    private String nom;
    private String prenom;
    private String ville;
    private int id;

    //Constructeur par defaut
    public Client(){}

    //Constructeur avec nom + prenom + ville
    public Client(String nom, String prenom, String ville, int id){
        this.nom = nom;
        this.prenom = prenom;
        this.ville = ville;
        this.id = id;
    }
    public Client(String nom, String prenom, String ville) {
        this.nom = nom;
        this.prenom = prenom;
        this.ville = ville;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return nom + prenom + ville;

    }

}


