/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVICOS;

import DADOS.DAOS.RequisicaoDAO;
import dados_entidades.Requisicao;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author IFNMG
 */
public class RequisicaoServico {
    
    private RequisicaoDAO dao = new RequisicaoDAO();
    public void save_rc(Requisicao r){
        dao.save_rc(r);
    }
    
    public List<Requisicao> listar(){
        return dao.listar();
    }
    
    public void editar(Requisicao r){
        dao.editar(r);
    }
    
    public void excluir(Requisicao r){
        dao.excluir(r);
    }
    
    public List<Requisicao> buscar(LocalDate r){
        return dao.buscar(r);
    }
    
    
    
}
