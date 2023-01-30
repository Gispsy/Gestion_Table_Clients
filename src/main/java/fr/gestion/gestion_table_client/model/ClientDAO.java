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
            Connection con = DriverManager.getConnection(url, "root", "tiger");

            Statement stm = con.createStatement();
            ResultSet resultat = stm.executeQuery("SELECT cli_nom, cli_prenom FROM client");

            while (resultat.next()){
                Client cli = new Client(resultat.getString("cli_nom"),resultat.getString("cli_prenom"));

                result.add(cli);

            }
            con.close();
            stm.close();

        } catch (Exception e) {
            e.getMessage();
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Mauvaise Connexion");
            alert.showAndWait();


        }

        return result;
    }

    public void insert(Client cli){
        try{
            String url = "jdbc:mysql://localhost:3307/hotel";
            Connection con = DriverManager.getConnection(url, "root", "tiger");

            PreparedStatement stm = con.prepareStatement("INSERT INTO client (cli_nom, cli_prenom, cli_ville)VALUES (?,?,?)");

            stm.setString(1, cli.getNom());
            stm.setString(2, cli.getPrenom());
            stm.setString(3, cli.getVille());


        }catch (Exception e){
            e.getMessage();
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Mauvaise Connexion");
            alert.showAndWait();

        }

    }
}
