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
import javafx.scene.image.Image;
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
        
        Parent root = FXMLLoader.load(getClass().getResource("/UI/CONDUTOR/janelaCondutor.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage(StageStyle.UTILITY);
        stage.setTitle("Cadastro de Condutores");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    @FXML
    private void cadastrar_localidade(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/UI/LOCALIDADE/janelaLocalidade.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage(StageStyle.UTILITY);
        stage.setTitle("Cadastro de Localidades");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    @FXML
    private void cadastrar_veiculo(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/UI/VEICULO/janelaVeiculo.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage(StageStyle.UTILITY);
        stage.setTitle("Cadastro de Veiculos");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    @FXML
    private void cadastrar_passageiro(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/UI/PASSAGEIRO/janelaPassageiro.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage(StageStyle.UTILITY);
        stage.setTitle("Cadastro de Passageiros");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    @FXML
    private void criar_requisicao(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/UI/REQUISICAO/janelaRequisicao.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage(StageStyle.UTILITY);
        stage.setTitle("Cadastro de Requisição");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    private void sobre(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/UI/SOBRE/janelaSobre.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage(StageStyle.UTILITY);
        stage.setTitle("Informações Sobre o Projeto");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    @FXML
    private void gerenciar(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/UI/GERENCIAR/janelaGerenciar.fxml"));
        Scene scene=new Scene(root);
        Stage stage=new Stage(StageStyle.UTILITY);
        stage.setTitle("Gerenciamento de Requisição");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }
}
