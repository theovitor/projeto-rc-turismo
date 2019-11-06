/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MAIN;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author IFNMG
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void cadastrar_condutor(ActionEvent event)throws IOException {
        
                Parent root = FXMLLoader.load(getClass().getResource("/UICONDUTOR/janela_condutor.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage(StageStyle.UTILITY);
        stage.setTitle("Cadastro de condutores");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
        
    }

    @FXML
    private void cadastrar_localidade(ActionEvent event) {
    }

    @FXML
    private void cadastrar_veiculo(ActionEvent event) {
    }

    @FXML
    private void cadastrar_passageiro(ActionEvent event) {
    }

    @FXML
    private void criar_requisicao(ActionEvent event) {
    }

    @FXML
    private void sobre(ActionEvent event) {
    }
    
}
