package com.example.phonenumber;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class CEPanel {
    Contact contact;
    @FXML
    Stage stage;
    @FXML
    TextField textField_name , textField_Phonenumber;
/*توی این کد بخش پاک کردن مخاطب و ویرایش را اضافه کردم*/
    public void initialize(){

        contact = Database.editContact;
        textField_name.setText(contact.getName());
        textField_Phonenumber.setText(contact.getPhonenumber());
    }
    public void cancel(){
        stage.close();
    }
    public void delete() throws IOException {
        Database.delete(contact);
    }
    public void edit() {
        if (textField_name.getText().equals("")) {
            showmessage("textField_name is empty", "ERROR");


        } else if (textField_Phonenumber.getText().equals("")) {
            showmessage("textField_Phonenumber is empty", "ERROR");
        } else if (Database.EContact(new Contact(textField_name.getText(), textField_Phonenumber.getText()))) {
            showmessage("Contact is exist", "Error");


        } else if (!chekphonenumber(textField_Phonenumber.getText())) {
            showmessage("phone number invalid","ERROR");
        } else {
            Contact contact = new Contact(textField_name.getText(), textField_Phonenumber.getText());
            Database.edit(this.contact, contact);
            Database.contacts.add(contact);
            showmessage("Edit is succesfulle", "Info");
            try {
                Database.write();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stage.close();

        }
    }
    public void showmessage(String text, String type) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        if (type.equals("info"))
            alert.setAlertType(Alert.AlertType.INFORMATION);
        alert.setContentText(text);
        alert.getDialogPane().setPrefSize(300, 100);
        alert.setHeaderText(null);
        alert.showAndWait();
    }


    public static boolean chekphonenumber(String s) {
        int n = s.length();
        if (n < 11) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }

        }
        return true;
    }
    }


