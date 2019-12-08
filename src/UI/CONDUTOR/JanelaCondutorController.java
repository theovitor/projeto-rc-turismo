/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.CONDUTOR;

import EXCECAO.ValoresInvalidosExceptions;
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
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import UTIL.AlertaUtil;

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
    @FXML
    private JFXTextField tfBuscarNome;
    
    private Condutor selecionado;
    
    private ObservableList<Condutor> dados = FXCollections.observableArrayList();
    
    private CondutorServico servico = new CondutorServico();
    
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
            try{
            Condutor c = new Condutor(tfnomemotorista.getText(), tfsetor.getText(), 
                    Integer.parseInt(tfcnh.getText()));
            servico.save_cond(c);
            AlertaUtil.mensagemSucesso("Condutor Salvo com Sucesso!");
            listaCondutores();
            }catch(ValoresInvalidosExceptions ex){
                AlertaUtil.mensagemErro(ex.getMessage());
            }
        }else{
            Optional<ButtonType> btn = 
                AlertaUtil.mensagemDeConfirmacao("Deseja mesmo salvar as alterações?",
                      "EDITAR");
            if(btn.get() == ButtonType.OK){
                try{
                selecionado.setNome_motorista(tfnomemotorista.getText());
                selecionado.setSetor(tfsetor.getText());
                selecionado.setCNH(Integer.parseInt(tfcnh.getText()));
                servico.editar(selecionado);
                AlertaUtil.mensagemSucesso("Condutor Atualizado Com Sucesso!"); 
                listaCondutores(); 
            }catch(ValoresInvalidosExceptions ex){
                AlertaUtil.mensagemErro(ex.getMessage());
                }
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
            tfid.setText(String.valueOf( selecionado.getId_motorista()));
            tfnomemotorista.setText( selecionado.getNome_motorista());
            tfsetor.setText(selecionado.getSetor());
            tfcnh.setText(String.valueOf(selecionado.getCNH()));
            
        }else{ //não tem ator selecionado na tabela
            AlertaUtil.mensagemErro("Selecione Um Condutor!");
             }
    }

    @FXML
    private void excluir(ActionEvent event) {
        selecionado = tbcondutor.getSelectionModel()
                .getSelectedItem();
        if(selecionado != null){
            Optional<ButtonType> btn = 
                AlertaUtil.mensagemDeConfirmacao("Deseja mesmo excluir?",
                      "EXCLUIR");
            if(btn.get() == ButtonType.OK){
                servico.excluir(selecionado);
                AlertaUtil.mensagemSucesso("Condutor Excluído Com Sucesso");
                listaCondutores();
            }
        }else{
            AlertaUtil.mensagemErro("Selecione um Condutor!");
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
}
