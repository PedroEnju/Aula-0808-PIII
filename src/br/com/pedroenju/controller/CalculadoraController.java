package br.com.pedroenju.controller;

import br.com.pedroenju.model.Calculadora;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Pedro Enju
 */
public class CalculadoraController implements Initializable {

    @FXML
    private Insets x1;
    @FXML
    private Label lblResultado;

    private Double num1;
    private String operation;
    private Calculadora model;
    private boolean start;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.num1 = 0D;
        this.operation = "";
        this.model = new Calculadora();
        this.start = true;
    }

    @FXML
    private void processaOperador(ActionEvent event) {
        String value = ((Button) event.getSource()).getText();

        if (value.equals("X")) {
            if (this.lblResultado.getText().length() > 0) {
                this.lblResultado.setText(this.lblResultado.getText().substring(0, this.lblResultado.getText().length() - 1));
            }
        } else if (!value.equals("=")) {
            if (!this.operation.isEmpty()) {
                return;
            }

            this.operation = value;
            this.num1 = Double.parseDouble(this.lblResultado.getText());
            this.lblResultado.setText("");
        } else {
            if (this.operation.isEmpty() || this.lblResultado.getText().isEmpty()) {
                return;
            }

            Double num2 = Double.parseDouble(this.lblResultado.getText());
            Double result = this.model.calcular(this.num1, this.operation, num2);
            this.lblResultado.setText(result.toString());
            this.operation = "";
            this.start = true;
        }
    }

    @FXML
    private void processaNumero(ActionEvent event) {
        if (start) {
            this.lblResultado.setText("");
            this.start = false;
        }

        String value = ((Button) event.getSource()).getText();
        this.lblResultado.setText(this.lblResultado.getText() + value);
    }

}
