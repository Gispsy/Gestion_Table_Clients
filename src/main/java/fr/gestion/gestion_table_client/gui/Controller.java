package fr.gestion.gestion_table_client.gui;

import fr.gestion.gestion_table_client.model.Client;
import fr.gestion.gestion_table_client.model.ClientDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.sql.SQLException;

public class Controller{

    public Button Btn_Ajout;
    public Button Btn_Modif;
    public Button Btn_Supp;
    public TableView<Client> TableauClient;
    public TableColumn<Client,String> col_Nom;
    public TableColumn<Client,String> col_Prenom;
    final ObservableList<Client> model = FXCollections.observableArrayList();
    
    //Field_1
    public AnchorPane Field_1;
    public TextField TextField_Nom;
    public TextField TextField_Prenom;
    public TextField TextField_Ville;
    public Button BtnA_OK;
    public Button BtnA_Annuler;
    boolean ajout = false;
    boolean modif = false;
    boolean supp = false;

    public void initialize(){
        ClientDAO table = new ClientDAO();

        col_Nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        col_Prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));

        model.addAll(table.list());


        TableauClient.setItems(model);


    }

    //Ajout des clients
    public boolean OnClickAjout(ActionEvent actionEvent) {
        ajout = true;
        Field_1.setVisible(true);

        return ajout;

    }

    //Modif des clients
    public boolean OnClickModif(ActionEvent actionEvent) {
        modif = true;
        Field_1.setVisible(true);
        Client client = TableauClient.getSelectionModel().getSelectedItem();
        System.out.println(TableauClient.getSelectionModel().getSelectedItem());

        TextField_Nom.setText(client.getNom());
        TextField_Prenom.setText(client.getPrenom());
        TextField_Ville.setText(client.getVille());

        return modif;

    }

    //Suppression des clients
    public boolean OnClickSupp(ActionEvent actionEvent) {
        supp = true;
        Field_1.setVisible(true);
        Client client = TableauClient.getSelectionModel().getSelectedItem();
        System.out.println(TableauClient.getSelectionModel().getSelectedItem());

        TextField_Nom.setText(client.getNom());
        TextField_Prenom.setText(client.getPrenom());
        TextField_Ville.setText(client.getVille());

        return supp;

    }

    public void BtnA_OkClick(ActionEvent actionEvent) throws SQLException {
        ClientDAO cliDAO = new ClientDAO();
        if(ajout == true){
            String n = TextField_Nom.getText();
            String p = TextField_Prenom.getText();
            String v = TextField_Ville.getText();

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            cliDAO.insert(new Client(n, p, v));
            alert.showAndWait();

        }else if(modif == true){
            Client client = TableauClient.getSelectionModel().getSelectedItem();
            System.out.println(TableauClient.getSelectionModel().getSelectedItem());


            client.setNom(TextField_Nom.getText());
            client.setPrenom(TextField_Prenom.getText());
            client.setVille(TextField_Ville.getText());


            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            cliDAO.update(client);
            alert.showAndWait();

        } else if(supp == true){
            Client client = TableauClient.getSelectionModel().getSelectedItem();
            System.out.println(TableauClient.getSelectionModel().getSelectedItem());

        }

    }

    //Annule = clear field_1 et cache le field_1
    public void BtnA_AnnulerClick(ActionEvent actionEvent){
        Field_1.setVisible(false);
        TextField_Nom.clear();
        TextField_Prenom.clear();
        TextField_Ville.clear();


    }
}