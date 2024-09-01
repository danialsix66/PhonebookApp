package com.example.phonenumber;


import javafx.beans.Observable;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;

public class CMainpanel {
    @FXML
    TextField search;
    @FXML
    TableView<Contact> tableView;
    @FXML
    TableColumn Column_phonenumber, Column_name;
    public void initalize() throws IOException {
        Database.read();
        showTablecontact();
    }
    //new class to show table contact
    public void showTablecontact(){

        Column_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        Column_name.setStyle("-fx-Alignment: CENTER");
        Column_phonenumber.setCellValueFactory(new PropertyValueFactory<>("phonenumber"));
        Column_name.setStyle("-fx-Alignment: CENTER");
        tableView.setEditable(false);
        ObservableList<Contact> observableList = FXCollections.observableArrayList(Database.getContacts(search.getText()));
        tableView.setItems(observableList);
    }
    public void add() throws IOException {
        //call fiel adnnpanel to show graphic
        //برو توی کلاس نوی ریسوررس و اد پنل رو لود کن
        Stage stage = FXMLLoader.load(getClass().getResource("Addpanel.fxml"));
        stage.setTitle("Add Contact");
        stage.show();
        new Thread(() -> {
            while (stage.isShowing()){

            }
            showTablecontact();
        }).start();
    }

    public void search() {

        showTablecontact();
    }



    public void selectcontact(MouseEvent mouseEvent) throws IOException {
        if (mouseEvent.getClickCount()==1 && !tableView.getSelectionModel().isEmpty()){
            Database.editContact = tableView.getSelectionModel().getSelectedItem();
            Stage stage = FXMLLoader.load(getClass().getResource("Deletepanel.fxml"));
            stage.setTitle("Edit Contact");
            stage.show();
        }
    }
}

