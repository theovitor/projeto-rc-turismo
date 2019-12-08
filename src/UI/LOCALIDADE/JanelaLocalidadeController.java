/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.LOCALIDADE;

import SERVICOS.LocalidadeServico;
import UTIL.AlertaUtil;
import com.jfoenix.controls.JFXTextField;
import dados_entidades.Localidade;
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
public class JanelaLocalidadeController implements Initializable {
  
    @FXML
    private JFXTextField tfid;
    @FXML
    private JFXTextField tfnomelocal;
    @FXML
    private JFXTextField tfrua;
    @FXML
    private JFXTextField tfnumero;
    @FXML
    private JFXTextField tfbairro;
    @FXML
    private JFXTextField tfcity;
    @FXML
    private JFXTextField tfcep;
    @FXML
    private JFXTextField tfsetor;
    @FXML
    private TableColumn colid;
    @FXML
    private TableColumn colnomelocal;
    @FXML
    private TableColumn colsetor;
    @FXML
    private TableColumn colrua;
    @FXML
    private TableColumn colnumero;
    @FXML
    private TableColumn colbairro;
    @FXML
    private TableColumn colcity;
    @FXML
    private TableColumn colcep;
    @FXML
    private TableView<Localidade> tbLocalidade;
    @FXML
    private JFXTextField tfBuscarNome;
    
    private ObservableList<Localidade> dados = FXCollections.observableArrayList();
    
    private Localidade selecionado;
   
    private LocalidadeServico servico = new LocalidadeServico();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        confTabela();
        listaLocais();
    }    

    @FXML
    private void salvar(ActionEvent event) {
        if(tfid.getText().isEmpty()){
            Localidade l = new Localidade(tfnomelocal.getText(), tfrua.getText(),
                    Integer.parseInt(tfnumero.getText()), tfbairro.getText(), tfcity.getText(),
                    Integer.parseInt(tfcep.getText()), tfsetor.getText());
            servico.save_local(l);
            AlertaUtil.mensagemSucesso("Local Salvo com Sucesso!");
            listaLocais();
        }else{
            Optional<ButtonType> btn = 
                AlertaUtil.mensagemDeConfirmacao("Deseja mesmo salvar as alterações?",
                      "EDITAR");
            if(btn.get() == ButtonType.OK){
                selecionado.setNome_local(tfnomelocal.getText());
                selecionado.setRua(tfrua.getText());
                selecionado.setNumero(Integer.parseInt(tfnumero.getText()));
                selecionado.setBairro(tfbairro.getText());
                selecionado.setCidade(tfcity.getText());
                selecionado.setCEP(Integer.parseInt(tfcep.getText()));
                selecionado.setSetor(tfsetor.getText());
                servico.editar(selecionado);
                AlertaUtil.mensagemSucesso("Local Atualizado Com Sucesso!"); 
                listaLocais(); 
            }
        }
            tfid.setText("");
            tfnomelocal.setText("");
            tfrua.setText("");
            tfnumero.setText("");
            tfbairro.setText("");
            tfcity.setText("");
            tfcep.setText("");
            tfsetor.setText("");
    }

    @FXML
    private void editar(ActionEvent event) {
        selecionado = tbLocalidade.getSelectionModel()
                .getSelectedItem();
        if (selecionado != null) { 
            tfid.setText(String.valueOf(selecionado.getId_local()));
            tfnomelocal.setText(selecionado.getNome_local());
            tfrua.setText(selecionado.getRua());
            tfnumero.setText(String.valueOf(selecionado.getNumero()));
            tfbairro.setText(selecionado.getBairro());
            tfcity.setText(selecionado.getCidade());
            tfcep.setText(String.valueOf(selecionado.getCEP()));
            tfsetor.setText(selecionado.getSetor());
        }else{
            AlertaUtil.mensagemErro("Selecione Um Local!");
            }
    }

    @FXML
    private void excluir(ActionEvent event) {
        selecionado = (Localidade) tbLocalidade.getSelectionModel()
                .getSelectedItem();
        if(selecionado != null){
            Optional<ButtonType> btn = 
                AlertaUtil.mensagemDeConfirmacao("Deseja mesmo excluir?",
                      "EXCLUIR");
            if(btn.get() == ButtonType.OK){
                servico.excluir(selecionado);
                AlertaUtil.mensagemSucesso("Local Excluído Com Sucesso");
                listaLocais();
            }
        }else{
            AlertaUtil.mensagemErro("Selecione um Local!");
        }
    }
    @FXML
    private void buscar(ActionEvent event) {
        dados.clear();
        String nome = tfBuscarNome.getText();
        List<Localidade> locais = servico.buscar(nome);
        dados = FXCollections.observableArrayList(locais);
        tbLocalidade.setItems(dados);
    }
    
    private void confTabela(){
        colid.setCellValueFactory(
                new PropertyValueFactory("id_local"));
        colnomelocal.setCellValueFactory(
                new PropertyValueFactory("nome_local"));
        colrua.setCellValueFactory(
                new PropertyValueFactory("rua"));
        colnumero.setCellValueFactory(
                new PropertyValueFactory("numero"));
        colbairro.setCellValueFactory(
                new PropertyValueFactory("bairro"));
        colcity.setCellValueFactory(
                new PropertyValueFactory("cidade"));
        colcep.setCellValueFactory(
                new PropertyValueFactory("CEP"));
        colsetor.setCellValueFactory(
                new PropertyValueFactory("setor"));
    }
    
    private void listaLocais(){
        dados.clear();
        List<Localidade> locais = servico.listar();
        dados = FXCollections.observableArrayList(locais);
        tbLocalidade.setItems(dados);
    }
}
