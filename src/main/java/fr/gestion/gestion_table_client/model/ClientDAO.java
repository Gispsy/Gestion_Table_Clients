package fr.gestion.gestion_table_client.model;

import javafx.scene.control.Alert;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO {
    public ClientDAO(){};

    public List<Client> list(){
        List<Client> result = new ArrayList<Client>();

        try{
            String url = "jdbc:mysql://localhost:3307/hotel";
            Connection con = DriverManager.getConnection(url, "root", "tiger");//Connection a la base de donnée

            Statement stm = con.createStatement();
            ResultSet resultat = stm.executeQuery("SELECT * FROM client");//Requete demander a la base de donnée

            while (resultat.next()){
                Client cli = new Client(resultat.getString("cli_nom"),resultat.getString("cli_prenom"),resultat.getString("cli_ville"),resultat.getInt("cli_id"));//Si la connection est bonne afficher le nom + prenom dans les 2 colonnes

                result.add(cli);

            }
            con.close();
            stm.close();

        } catch (Exception e) {                                 //Message d'erreur si la connectiona la base de donnée est pas bonne
            e.getMessage();
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Mauvaise Connexion");
            alert.showAndWait();


        }

        return result;
    }       //Programme pour afficher la liste de nom/prenom des clients

    public void insert(Client cli){
        try{
            String url = "jdbc:mysql://localhost:3307/hotel";
            Connection con = DriverManager.getConnection(url, "root", "tiger"); //Connection a la base de donnée

            PreparedStatement stm = con.prepareStatement("INSERT INTO client (cli_nom, cli_prenom, cli_ville)VALUES (?,?,?)");//Requete demander a la base de donnée

            stm.setString(1, cli.getNom());
            stm.setString(2, cli.getPrenom());
            stm.setString(3, cli.getVille());

            stm.execute();

            stm.close();
            con.close();
            System.out.println("l'insertion s’est bien effectuée");

        }catch (Exception e){
            e.getMessage();
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Mauvaise Connexion");
            alert.showAndWait();

        }

    }   //Programme pour insert un nouveau client dans la base de donnée

    public void update(Client cli) throws SQLException {
        String url = "jdbc:mysql://localhost:3307/hotel";
        Connection con = DriverManager.getConnection(url, "root", "tiger");

        PreparedStatement stm = con.prepareStatement("UPDATE client SET cli_nom = ?, cli_prenom = ?, cli_ville = ? WHERE cli_id =?");

        stm.setString(1, cli.getNom());
        stm.setString(2, cli.getPrenom());
        stm.setString(3, cli.getVille());
        stm.setInt(4,cli.getId());

        System.out.println(stm.toString());

        stm.execute();

        stm.close();
        con.close();
        System.out.println("La modification s’est bien effectuée");

    }

    public void delete(Client cli) throws SQLException {
        String url = "jdbc:mysql://localhost:3307/hotel";
        Connection con = DriverManager.getConnection(url, "root", "tiger");

        PreparedStatement stm = con.prepareStatement("DELETE reservation\n" +
                                                        "FROM reservation\n" +
                                                        "JOIN client c on reservation.res_cli_id = c.cli_id\n" +
                                                        "WHERE cli_id =?");

        PreparedStatement stm2 = con.prepareStatement("DELETE client\n" +
                                                        "FROM client\n" +
                                                        "JOIN reservation c on client.cli_id = c.res_cli_id\n" +
                                                        "WHERE cli_id =?");

        stm2.setInt(1,cli.getId());

        stm.setInt(1, cli.getId());

        stm2.execute();
        stm.execute();

        stm2.close();
        stm.close();
        con.close();
        System.out.println("La suppression s’est bien effectuée");

    }
}
