/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MAIN.condutor;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author IFNMG
 */
public class Janela_condutorController implements Initializable {

    @FXML
    private JFXTextField tfid;
    @FXML
    private JFXTextField tfnomemotorista;
    @FXML
    private JFXTextField tfsetor;
    @FXML
    private JFXTextField tfcnh;
    @FXML
    private TableView<?> tbcondutor;
    @FXML
    private TableColumn<?, ?> colid;
    @FXML
    private TableColumn<?, ?> colnome;
    @FXML
    private TableColumn<?, ?> colsetor;
    @FXML
    private TableColumn<?, ?> colcnh;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void salvar(ActionEvent event) {
    }

    @FXML
    private void editar(ActionEvent event) {
    }

    @FXML
    private void excluir(ActionEvent event) {
    }

    @FXML
    private void buscar(ActionEvent event) {
    }
    
}
