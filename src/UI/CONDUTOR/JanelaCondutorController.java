/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.CONDUTOR;

import SERVICOS.CondutorServico;
import com.jfoenix.controls.JFXTextField;
import dados_entidades.Condutor;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Sarah
 */
public class JanelaCondutorController implements Initializable {

    @FXML
    private JFXTextField tfid;
    @FXML
    private JFXTextField tfnomemotorista;
    
    private CondutorServico servico = new CondutorServico();
    
    @FXML
    private JFXTextField tfsetor;
    @FXML
    private JFXTextField tfcnh;
    @FXML
    private TableView<Condutor> tbcondutor;
    @FXML
    private TableColumn colid;
    @FXML
    private TableColumn colnome;
    @FXML
    private TableColumn colsetor;
    @FXML
    private TableColumn colcnh;
    
    private ObservableList<Condutor> dados
        = FXCollections.observableArrayList();
    
    private Condutor selecionado;
    @FXML
    private JFXTextField tfBuscarNome;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        confTabela();
        listaCondutores();
    }    

    @FXML
    private void salvar(ActionEvent event) {
        if(tfid.getText().isEmpty()){
            Condutor c = new Condutor(tfnomemotorista.getText(), tfsetor.getText(), 
                    Integer.parseInt(tfcnh.getText()));
            servico.save_cond(c);
            mensagemSucesso("Condutor Salvo com Sucesso!");
            listaCondutores();
        }else{
            Optional<ButtonType> btn = 
                mensagemDeConfirmacao("Deseja mesmo salvar as alterações?",
                      "EDITAR");
            if(btn.get() == ButtonType.OK){
                selecionado.setNome_motorista(tfnomemotorista.getText());
                selecionado.setSetor(tfsetor.getText());
                selecionado.setCNH(Integer.parseInt(tfcnh.getText()));
                servico.editar(selecionado);
                mensagemSucesso("Condutor Atualizado Com Sucesso!"); 
                listaCondutores(); 
            }
        }
            tfid.setText("");
            tfnomemotorista.setText("");
            tfsetor.setText("");
            tfcnh.setText("");
    }
    

    @FXML
    private void editar(ActionEvent event) {
        selecionado = tbcondutor.getSelectionModel()
                .getSelectedItem();
        if (selecionado != null) { 
            tfid.setText(
                    String.valueOf( selecionado.getId_motorista()));
            tfnomemotorista.setText( selecionado.getNome_motorista());
            tfsetor.setText(selecionado.getSetor());
            tfcnh.setText(String.valueOf(selecionado.getCNH()));
            
        }else{ //não tem ator selecionado na tabela
            mensagemErro("Selecione Um Condutor!");
            }
    }

    @FXML
    private void excluir(ActionEvent event) {
        selecionado = tbcondutor.getSelectionModel()
                .getSelectedItem();
        if(selecionado != null){
            Optional<ButtonType> btn = 
                mensagemDeConfirmacao("Deseja mesmo excluir?",
                      "EXCLUIR");
            if(btn.get() == ButtonType.OK){
                servico.excluir(selecionado);
                mensagemSucesso("Condutor Excluído Com Sucesso");
                listaCondutores();
            }
        }else{
            mensagemErro("Selecione um Condutor!");
        }
    }

    @FXML
    private void buscar(ActionEvent event) {
        dados.clear();
        String nome = tfBuscarNome.getText();
        List<Condutor> condutores = servico.buscar(nome);
        dados = FXCollections.observableArrayList(condutores);
        tbcondutor.setItems(dados);
    }
    
    
    private void confTabela(){
        colid.setCellValueFactory(
                new PropertyValueFactory("id_motorista"));
        colnome.setCellValueFactory(
                new PropertyValueFactory("nome_motorista"));
        colsetor.setCellValueFactory(
                new PropertyValueFactory("setor"));
        colcnh.setCellValueFactory(
                new PropertyValueFactory("CNH"));
    }
    
    private void listaCondutores(){
        dados.clear();
        List<Condutor> condutores = servico.listar();
        dados = FXCollections.observableArrayList(condutores);
        tbcondutor.setItems(dados);

    }
    public void mensagemSucesso(String m) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("SUCESSO!");
        alerta.setHeaderText(null);
        alerta.setContentText(m);
        alerta.showAndWait();
    }
    
    public void mensagemErro(String m) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("ERRO!");
        alerta.setHeaderText(null);
        alerta.setContentText(m);
        alerta.showAndWait();
    }
    
    private Optional<ButtonType> mensagemDeConfirmacao(
            String mensagem, String titulo) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        return alert.showAndWait();
    }
    
}
