/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.PASSAGEIRO;

import SERVICOS.PassageiroServico;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import dados_entidades.Passageiro;
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
public class JanelaPassageiroController implements Initializable {

    private PassageiroServico servico = new PassageiroServico();
    
    @FXML
    private JFXTextField tfid;
    @FXML
    private JFXTextField tfnomepassageiro;
    @FXML
    private JFXTextField tfsetor;
    @FXML
    private JFXTextField tfrua;
    @FXML
    private JFXTextField tfnumero;
    @FXML
    private JFXTextField tfcep;
    @FXML
    private JFXTextField tfcity;
    @FXML
    private JFXTextField tfemail;
    @FXML
    private JFXTextField tfcpf;
    @FXML
    private JFXTextField tfcomplemento;
    @FXML
    private JFXTextField tfbairro;
    @FXML
    private JFXTextField tfnomeGer;
    @FXML
    private JFXTextField tfemailGer;
    @FXML
    private TableColumn<?, ?> colid;
    @FXML
    private TableColumn<?, ?> colnome;
    @FXML
    private TableColumn<?, ?> colcpf;
    @FXML
    private TableColumn<?, ?> colmail;
    @FXML
    private TableColumn<?, ?> colsetor;
    @FXML
    private TableColumn<?, ?> colrua;
    @FXML
    private TableColumn<?, ?> colnumero;
    @FXML
    private TableColumn<?, ?> colbairro;
    @FXML
    private TableColumn<?, ?> colcidade;
    @FXML
    private TableColumn<?, ?> colcep;
    @FXML
    private TableColumn<?, ?> colcomp;
    @FXML
    private TableColumn<?, ?> colNger;
    @FXML
    private TableColumn<?, ?> colEger;
    @FXML
    private TableView<Passageiro> tbPassageiro;
    @FXML
    private JFXComboBox<?> cbDirige;
    
    private ObservableList<Passageiro> dados = FXCollections.observableArrayList();
    
    private Passageiro selecionado;
    @FXML
    private JFXTextField tfBuscarNome;
    
    
//    RadioButton radio = (RadioButton) dirige.getSelectedToggle(); 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        confTabela();
        listaPassageiros();
    }    

    @FXML
    private void salvar(ActionEvent event) {    
        if(tfid.getText().isEmpty()){
           // boolean dirige = (radioS.isSelected() ? true : false);
            
           Passageiro p = new Passageiro(tfnomepassageiro.getText(),tfsetor.getText(), tfcpf.getText(), tfrua.getText(), 
                   Integer.parseInt(tfnumero.getText()),tfcomplemento.getText(),tfbairro.getText(),
                   tfcity.getText(), 
                   Integer.parseInt(tfcep.getText()), tfemail.getText(),tfnomeGer.getText(),tfemailGer.getText());
            servico.save_passag(p);
            mensagemSucesso("Passageiro Salvo!");
            listaPassageiros();
        }else{
            Optional<ButtonType> btn = mensagemDeConfirmacao("Dejesa Alterar?", "Editar");
            if(btn.get()==ButtonType.OK){
                selecionado.setNome(tfnomepassageiro.getText());
                selecionado.setBairro(tfbairro.getText());
                selecionado.setCEP(Integer.parseInt(tfcep.getText()));
                selecionado.setCPF(tfcpf.getText());
                selecionado.setCidade(tfcity.getText());
                selecionado.setComplemento(tfcomplemento.getText());
                selecionado.setEmail(tfemail.getText());
                selecionado.setEmail_gerente(tfemailGer.getText());
                selecionado.setGerente(tfnomeGer.getText());
                selecionado.setNumero(Integer.parseInt(tfnumero.getText()));
                selecionado.setRua(tfrua.getText());
                selecionado.setSetor(tfsetor.getText());
    
                servico.editar(selecionado);
                mensagemSucesso("Passageiro Salvo!"); 
                listaPassageiros();
            }
        }
        tfnomepassageiro.setText("");
        tfbairro.setText("");
        tfcep.setText("");
        tfcpf.setText("");
        tfcity.setText("");
        tfcomplemento.setText("");
        tfemail.setText("");
        tfemailGer.setText("");
        tfnomeGer.setText("");    
        tfnumero.setText("");
        tfrua.setText("");        
        tfsetor.setText("");    
    }

    @FXML
    private void editar(ActionEvent event) {
        selecionado = (Passageiro) tbPassageiro.getSelectionModel()
                .getSelectedItem();
        if (selecionado != null) { 
            tfnomepassageiro.setText(selecionado.getNome());
            tfbairro.setText(selecionado.getBairro());
            tfcep.setText(String.valueOf(selecionado.getCEP()));
            tfcpf.setText(selecionado.getCPF());
            tfcity.setText(selecionado.getCidade());
            tfcomplemento.setText(selecionado.getComplemento());
            tfemail.setText(selecionado.getEmail());
            tfemailGer.setText(selecionado.getEmail_gerente());
            tfnomeGer.setText(selecionado.getGerente());    
            tfnumero.setText(String.valueOf(selecionado.getNumero()));
            tfrua.setText(selecionado.getRua());        
            tfsetor.setText(selecionado.getSetor());
        }else{ //não tem ator selecionado na tabela
            mensagemErro("Selecione um passageiro!");
        }
    }

    @FXML
    private void excluir(ActionEvent event) {
        
        selecionado = (Passageiro) tbPassageiro.getSelectionModel()
                .getSelectedItem();
        if(selecionado != null){
            Optional<ButtonType> btn = 
                mensagemDeConfirmacao("Deseja mesmo excluir?",
                      "EXCLUIR");
            if(btn.get() == ButtonType.OK){
                servico.excluir(selecionado);
                mensagemSucesso("Passageiro Excluído Com Sucesso");
                listaPassageiros();
            }
        }else{
            mensagemErro("Selecione um Passageiro!");
        }
    }
    

    @FXML
    private void buscar(ActionEvent event) {
        dados.clear();
        String nome = tfBuscarNome.getText();
        List<Passageiro> locais = servico.buscar(nome);
        dados = FXCollections.observableArrayList(locais);
        tbPassageiro.setItems(dados);
    }
    
    
    private void confTabela(){
        colid.setCellValueFactory(
                new PropertyValueFactory("id_passageiro"));
        colEger.setCellValueFactory(
                new PropertyValueFactory("email_gerente"));       
        colNger.setCellValueFactory(
                new PropertyValueFactory("gerente"));
        colbairro.setCellValueFactory(
                new PropertyValueFactory("bairro"));
        colcep.setCellValueFactory(
                new PropertyValueFactory("CEP"));       
        colcidade.setCellValueFactory(
                new PropertyValueFactory("cidade"));      
        colcomp.setCellValueFactory(
                new PropertyValueFactory("complemento"));      
        colcpf.setCellValueFactory(
                new PropertyValueFactory("CPF"));      
        colmail.setCellValueFactory(
                new PropertyValueFactory("email"));  
        colnome.setCellValueFactory(
                new PropertyValueFactory("nome"));       
        colnumero.setCellValueFactory(
                new PropertyValueFactory("numero"));      
        colrua.setCellValueFactory(
                new PropertyValueFactory("rua"));      
        colsetor.setCellValueFactory(
                new PropertyValueFactory("setor"));
    }
        
    private void listaPassageiros(){
        dados.clear();
        List<Passageiro> passageiros = servico.listar();
        dados = FXCollections.observableArrayList(passageiros);
        tbPassageiro.setItems(dados);
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
