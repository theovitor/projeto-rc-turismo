/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.REQUISICAO;

import SERVICOS.LocalidadeServico;
import SERVICOS.PassageiroServico;
import SERVICOS.RequisicaoServico;
import UTIL.AlertaUtil;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import dados_entidades.Localidade;
import dados_entidades.Passageiro;
import dados_entidades.Requisicao;
import java.net.URL;
import java.time.LocalDate;
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
public class JanelaRequisicaoController implements Initializable {
    
    @FXML
    private TableColumn<?, ?> colid;
    @FXML
    private TableColumn<?, ?> coldataida;
    @FXML
    private TableColumn<?, ?> coldatavolta;
    @FXML
    private TableColumn<?, ?> colhoraida;
    @FXML
    private TableColumn<?, ?> colhoravolta;
    @FXML
    private TableColumn<?, ?> coloirgem;
    @FXML
    private TableColumn<?, ?> coldestino;
    @FXML
    private TableColumn<?, ?> colcc;
    @FXML
    private TableColumn<?, ?> colhotel;
    @FXML
    private TableColumn<?, ?> colp1;
    @FXML
    private TableColumn<?, ?> colp2;
    @FXML
    private TableColumn<?, ?> colp3;
    @FXML
    private TableColumn<?, ?> colp4;
    @FXML
    private TableColumn<?, ?> colmotivoviagem;
    @FXML
    private TableColumn<?, ?> colobs;
    @FXML
    private JFXComboBox<Localidade> cbdestino;
    @FXML
    private JFXTextField tfcc;
    @FXML
    private JFXComboBox<Passageiro> cbpass1;
    @FXML
    private JFXComboBox<Passageiro> cbpass2;
    @FXML
    private JFXComboBox<Passageiro> cbpass3;
    @FXML
    private JFXComboBox<Passageiro> cbpass4;
    @FXML
    private JFXTextArea tamotivo;
    @FXML
    private JFXComboBox<String> cbhotel;
    @FXML
    private JFXTextArea taobs;
    @FXML
    private JFXTextField tfid;
    @FXML
    private JFXTimePicker tphida;
    @FXML
    private JFXDatePicker dpvolta;
    @FXML
    private JFXTimePicker tphvolta;
    @FXML
    private JFXComboBox<Localidade> cborigem;
    @FXML
    private TableView<Requisicao> tbrequisicao;
    @FXML
    private JFXDatePicker dpida;
    
    private Requisicao selecionado;
     
    private ObservableList<Requisicao> dados = FXCollections.observableArrayList();
    
    private RequisicaoServico servico = new RequisicaoServico();
    private PassageiroServico passageiroServico = new PassageiroServico();
    private LocalidadeServico localidadeServico = new LocalidadeServico();
    
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        confTabela();
        listaRc();
        listarPassageiros();
        listarLocalidades();
        
        ObservableList hotel = FXCollections.observableArrayList();
        hotel.add("Sim");
        hotel.add("Não");
        
        cbhotel.setItems(hotel);
        
    }    

    @FXML
    private void salvar(ActionEvent event) {
        if(tfid.getText().isEmpty()){
            
           Requisicao r = new Requisicao(dpida.getValue(), tphida.getValue(), dpvolta.getValue(),
                   tphvolta.getValue(), cborigem.getValue(), cbdestino.getValue(), tfcc.getText(),
                   cbpass1.getValue(), cbpass2.getValue(), cbpass3.getValue(), cbpass4.getValue(),
                   tamotivo.getText(), cbhotel.getValue(), taobs.getText(), null, null, null);
           servico.save_rc(r);
           AlertaUtil.mensagemSucesso("Requisição Salva!");
           listaRc();
        }else{
            Optional<ButtonType> btn = AlertaUtil.mensagemDeConfirmacao("Dejesa Alterar?", "Editar");
            if(btn.get()==ButtonType.OK){
                selecionado.setIda(dpida.getValue());
                selecionado.setHora_ida(tphida.getValue());
                selecionado.setVolta(dpvolta.getValue());
                selecionado.setHora_volta(tphvolta.getValue());
                selecionado.setOrigem(cborigem.getValue());
                selecionado.setDestino(cbdestino.getValue());
                selecionado.setCentro_custo(tfcc.getText());
                selecionado.setPassageiro1(cbpass1.getValue());
                selecionado.setPassageiro2(cbpass2.getValue());
                selecionado.setPassageiro3(cbpass3.getValue());
                selecionado.setPassageiro4(cbpass4.getValue());
                selecionado.setMotivo(tamotivo.getText());
                selecionado.setHotel(cbhotel.getValue());
                selecionado.setObservacoes(taobs.getText());
    
                servico.editar(selecionado);
                AlertaUtil.mensagemSucesso("Requisição Salva!"); 
                listaRc();
            }
        }
        dpida.setValue(null);
        tphida.setValue(null);
        dpvolta.setValue(null);
        tphvolta.setValue(null);
        cborigem.setValue(null);
        cbdestino.setValue(null);
        tfcc.setText("");
        cbpass1.setValue(null);
        cbpass2.setValue(null);
        cbpass3.setValue(null);
        cbpass4.setValue(null);
        tamotivo.setText("");
        cbhotel.setValue(null);
        taobs.setText("");               
    }
  
    @FXML
    private void editar(ActionEvent event) {
        selecionado = (Requisicao) tbrequisicao.getSelectionModel()
                .getSelectedItem();
        if (selecionado != null) { 
            tfid.setText(String.valueOf(selecionado.getId_rc()));
            cbdestino.setValue(selecionado.getDestino());
            tfcc.setText(selecionado.getCentro_custo());
            cbpass1.setValue(selecionado.getPassageiro1());
            cbpass2.setValue(selecionado.getPassageiro2());
            cbpass3.setValue(selecionado.getPassageiro3());
            cbpass4.setValue(selecionado.getPassageiro4());
            tamotivo.setText(selecionado.getMotivo());
            cbhotel.setValue(selecionado.getHotel());
            taobs.setText(selecionado.getObservacoes());
            tphida.setValue(selecionado.getHora_ida());
            dpvolta.setValue(selecionado.getVolta());
            tphvolta.setValue(selecionado.getHora_volta());
            cborigem.setValue(selecionado.getOrigem());
            dpida.setValue(selecionado.getIda()); 
        }else{ //não tem ator selecionado na tabela
            AlertaUtil.mensagemErro("Selecione uma requisição!");
        }
    }

    @FXML
    private void excluir(ActionEvent event) {
        selecionado = (Requisicao) tbrequisicao.getSelectionModel()
                .getSelectedItem();
        if(selecionado != null){
            Optional<ButtonType> btn = 
                AlertaUtil.mensagemDeConfirmacao("Deseja mesmo excluir?",
                      "EXCLUIR");
            if(btn.get() == ButtonType.OK){
                servico.excluir(selecionado);
                AlertaUtil.mensagemSucesso("Requisicao excluída Com Sucesso");
                listaRc();
            }
        }else{
            AlertaUtil.mensagemErro("Selecione uma Requisicao!");
        }
    }

    @FXML
    private void buscar(ActionEvent event) {
        dados.clear();
        LocalDate ida = dpida.getValue();
        List<Requisicao> data = servico.buscar(ida);
        dados = FXCollections.observableArrayList(data);
        tbrequisicao.setItems(dados);  
    }
    
    private void confTabela(){
        colid.setCellValueFactory(
                new PropertyValueFactory("id_rc"));
        coldataida.setCellValueFactory(
                new PropertyValueFactory("ida"));
        coldatavolta.setCellValueFactory(
                new PropertyValueFactory("volta"));
        colhoraida.setCellValueFactory(
                new PropertyValueFactory("hora_ida"));
        colhoravolta.setCellValueFactory(
                new PropertyValueFactory("hora_volta"));
        coloirgem.setCellValueFactory(
                new PropertyValueFactory("origem"));
        coldestino.setCellValueFactory(
                new PropertyValueFactory("destino"));
        colcc.setCellValueFactory(
                new PropertyValueFactory("centro_custo"));
        colhotel.setCellValueFactory(
                new PropertyValueFactory("hotel"));
        colp1.setCellValueFactory(
                new PropertyValueFactory("passageiro1"));
        colp2.setCellValueFactory(
                new PropertyValueFactory("passageiro2"));
        colp3.setCellValueFactory(
                new PropertyValueFactory("passageiro3"));
        colp4.setCellValueFactory(
                new PropertyValueFactory("passageiro4"));
        colmotivoviagem.setCellValueFactory(
                new PropertyValueFactory("motivo"));
        colobs.setCellValueFactory(
                new PropertyValueFactory("observacoes"));   
    }
    
    private void listaRc(){
        dados.clear();
        List<Requisicao> requisicao = servico.listar();
        dados = FXCollections.observableArrayList(requisicao);
        tbrequisicao.setItems(dados);
    }
    
    private void listarPassageiros() {

        List<Passageiro> passageiros = passageiroServico.listar();

        cbpass1.setItems(FXCollections.observableArrayList(passageiros));
        cbpass2.setItems(FXCollections.observableArrayList(passageiros));
        cbpass3.setItems(FXCollections.observableArrayList(passageiros));
        cbpass4.setItems(FXCollections.observableArrayList(passageiros));
    }
    
    private void listarLocalidades() {

        List<Localidade> localidade = localidadeServico.listar();

        cborigem.setItems(FXCollections.observableArrayList(localidade));
        cbdestino.setItems(FXCollections.observableArrayList(localidade));
    }  
}

