package com.example.proyecto;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField txtUsuario;

    @FXML
    private PasswordField txtClave;

    @FXML
    private ComboBox<String> cmbRol;

    @FXML
    public void initialize() {
        cmbRol.getItems().addAll("Administrador", "Cajero");
    }

    @FXML
    private void ingresar(ActionEvent event) throws IOException {
        String usuario = txtUsuario.getText();
        String clave = txtClave.getText();
        String rol = cmbRol.getValue();

        if (usuario.isEmpty() || clave.isEmpty() || rol == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Complete todos los campos");
            alert.show();
            return;
        }

        if (usuario.equals("admin") && clave.equals("123") && rol.equals("Administrador")) {
            abrirVentana(event, "/fxml/Encuesta.fxml", "Encuesta");
        } else if (usuario.equals("cajero") && clave.equals("123") && rol.equals("Cajero")) {
            abrirVentana(event, "/fxml/Cajero.fxml", "Cajero");
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Credenciales incorrectas");
            alert.show();
        }
    }

    private void abrirVentana(ActionEvent event, String ruta, String titulo) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(ruta));
        Stage stage = new Stage();
        stage.setTitle(titulo);
        stage.setScene(new Scene(loader.load(), 500, 400));
        stage.show();

        ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
    }

    @FXML
    private void salir() {
        Platform.exit();
    }
}