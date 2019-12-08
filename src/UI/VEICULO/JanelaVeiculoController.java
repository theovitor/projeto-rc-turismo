/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.VEICULO;

import SERVICOS.VeiculoServico;
import UTIL.AlertaUtil;
import com.jfoenix.controls.JFXTextField;
import dados_entidades.Veiculo;
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

/**
 * FXML Controller class
 *
 * @author Sarah
 */
public class JanelaVeiculoController implements Initializable {

    @FXML
    private JFXTextField tfid;
    @FXML
    private JFXTextField tfmodeloveiculo;
    @FXML
    private JFXTextField tfmarca;
    @FXML
    private JFXTextField tflocalidadeveiculo;
    @FXML
    private JFXTextField tfnpassageiros;
    @FXML
    private JFXTextField tfplaca;
    
    
    
    @FXML
    private TableView<Veiculo> tbveiculo;
    @FXML
    private TableColumn<?, ?> colid;
    @FXML
    private TableColumn<?, ?> colmodelo;
    @FXML
    private TableColumn<?, ?> colplaca;
    @FXML
    private TableColumn<?, ?> colmarca;
    @FXML
    private TableColumn<?, ?> collocalidade;
    @FXML
    private TableColumn<?, ?> colnumpassag;
    @FXML
    private JFXTextField tfBuscarNome;
    
    private VeiculoServico servico = new VeiculoServico();
    
    private Veiculo selecionado;
    
    private ObservableList<Veiculo> dados = FXCollections.observableArrayList();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO 
        
        confTabela();
        listaVeiculos();
    }    

    @FXML
    private void salvar(ActionEvent event) {
        if(tfid.getText().isEmpty()){
            Veiculo v = new Veiculo(tfplaca.getText(), tfmarca.getText(),
                    tfmodeloveiculo.getText(), tflocalidadeveiculo.getText(),
                    Integer.parseInt(tfnpassageiros.getText()));
            
            servico.save_veic(v);
            AlertaUtil.mensagemSucesso("Veiculo Salvo com Sucesso!");
            listaVeiculos();
        }else{
            Optional<ButtonType> btn = 
                AlertaUtil.mensagemDeConfirmacao("Deseja mesmo salvar as alterações?",
                      "EDITAR");
            if(btn.get() == ButtonType.OK){
                selecionado.setModelo(tfmodeloveiculo.getText());
                selecionado.setMarca(tfmarca.getText());
                selecionado.setLocalidade(tflocalidadeveiculo.getText());
                selecionado.setN_passageiros(Integer.parseInt(tfnpassageiros.getText()));
                selecionado.setPlaca(tfplaca.getText());
                servico.editar(selecionado);
                AlertaUtil.mensagemSucesso("Local Atualizado Com Sucesso!"); 
                listaVeiculos(); 
            }
        }
            tfid.setText("");
            tfmodeloveiculo.setText("");
            tfmarca.setText("");
            tflocalidadeveiculo.setText("");
            tfnpassageiros.setText("");
            tfplaca.setText("");
    }

    @FXML
    private void editar(ActionEvent event) {
        selecionado = (Veiculo) tbveiculo.getSelectionModel()
                .getSelectedItem();
        if (selecionado != null) { 
            tfid.setText(String.valueOf(selecionado.getId_veiculo()));
            tfmodeloveiculo.setText(selecionado.getModelo());
            tfmarca.setText(selecionado.getMarca());
            tflocalidadeveiculo.setText(selecionado.getLocalidade());
            tfnpassageiros.setText(String.valueOf(selecionado.getN_passageiros()));
            tfplaca.setText(selecionado.getPlaca());
        }else{
            AlertaUtil.mensagemErro("Selecione Um Veiculo!");
            }
    }

    @FXML
    private void excluir(ActionEvent event) {
        selecionado = (Veiculo) tbveiculo.getSelectionModel()
                .getSelectedItem();
        if(selecionado != null){
            Optional<ButtonType> btn = 
                AlertaUtil.mensagemDeConfirmacao("Deseja mesmo excluir?",
                      "EXCLUIR");
            if(btn.get() == ButtonType.OK){
                servico.excluir(selecionado);
                AlertaUtil.mensagemSucesso("Veiculo Excluído Com Sucesso");
                listaVeiculos();
            }
        }else{
            AlertaUtil.mensagemErro("Selecione um Veiculo!");
        }
    }

    @FXML
    private void buscar(ActionEvent event) {
        dados.clear();
        String nome = tfBuscarNome.getText();
        List<Veiculo> locais = servico.buscar(nome);
        dados = FXCollections.observableArrayList(locais);
        tbveiculo.setItems(dados);
    }
 
    private void listaVeiculos(){
        dados.clear();
        List<Veiculo> locais = servico.listar();
        dados = FXCollections.observableArrayList(locais);
        tbveiculo.setItems(dados);
    }
    
    private void confTabela(){
        colid.setCellValueFactory(
                new PropertyValueFactory("id_veiculo"));
        colmodelo.setCellValueFactory(
                new PropertyValueFactory("modelo"));
        colplaca.setCellValueFactory(
                new PropertyValueFactory("placa"));
        colmarca.setCellValueFactory(
                new PropertyValueFactory("marca"));
        collocalidade.setCellValueFactory(
                new PropertyValueFactory("localidade"));
        colnumpassag.setCellValueFactory(
                new PropertyValueFactory("n_passageiros"));
    }  
}
