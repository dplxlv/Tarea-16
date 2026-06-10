package com.example.proyecto;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class EncuestaController {

    @FXML
    private ComboBox<String> p1;

    @FXML
    private ComboBox<String> p2;

    @FXML
    private ComboBox<String> p3;

    @FXML
    private ComboBox<String> p4;

    @FXML
    private Label lblResultado;

    @FXML
    public void initialize() {
        p1.getItems().addAll("Zoro", "Luffy", "Sanji");
        p2.getItems().addAll("Nami", "Zoro", "Usopp");
        p3.getItems().addAll("Sanji", "Franky", "Brook");
        p4.getItems().addAll("Ser rey pirata", "Ser almirante", "Ser doctor");
    }

    @FXML
    private void calcular() {
        int correctas = 0;

        if ("Luffy".equals(p1.getValue())) {
            correctas++;
        }

        if ("Zoro".equals(p2.getValue())) {
            correctas++;
        }

        if ("Sanji".equals(p3.getValue())) {
            correctas++;
        }

        if ("Ser rey pirata".equals(p4.getValue())) {
            correctas++;
        }

        int incorrectas = 4 - correctas;
        int puntaje = correctas * 5;

        lblResultado.setText(
                "Puntaje: " + puntaje + "/20\n" +
                        "Correctas: " + correctas + "\n" +
                        "Incorrectas: " + incorrectas
        );
    }
}