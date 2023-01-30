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

import java.awt.*;

public class Controller{

    public Button Btn_Ajout;
    public Button Btn_Modif;
    public Button Btn_Supp;
    public TableView<Client> TableauClient;
    public TableColumn<Client,String> col_Nom;
    public TableColumn<Client,String> col_Prenom;
    final ObservableList<Client> model = FXCollections.observableArrayList();
    
    //Field Ajout
    public AnchorPane Field_1;
    public TextField TextField_Nom;
    public TextField TextField_Prenom;
    public TextField TextField_Ville;
    public Button BtnA_Ajouter;
    public Button BtnA_Annuler;

    public void initialize(){
        ClientDAO table = new ClientDAO();

        col_Nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        col_Prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));

        model.addAll(table.list());


        TableauClient.setItems(model);


    }

    //Ajout des clients
    public void OnClickAjout(ActionEvent actionEvent) {
        Field_1.setVisible(true);

    }
    public void BtnA_AjouterClick(ActionEvent actionEvent) {
        ClientDAO cliDAO = new ClientDAO();
        cliDAO.insert(new Client());

        String n = TextField_Nom.getText();
        String p = TextField_Prenom.getText();
        String v = TextField_Ville.getText();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.showAndWait();
        cliDAO.insert(new Client(n,p,v));

    }
    public void BtnA_AnnulerClick(ActionEvent actionEvent){
        Field_1.setVisible(false);
        TextField_Nom.clear();
        TextField_Prenom.clear();
        TextField_Ville.clear();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Confirmation d'annulation");
        alert.showAndWait();

    }


    //Modif des clients
    public void OnClickModif(ActionEvent actionEvent) {
    }

    //Suppression des clients
    public void OnClickSupp(ActionEvent actionEvent) {
    }
}