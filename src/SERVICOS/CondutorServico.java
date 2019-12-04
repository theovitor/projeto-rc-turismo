/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVICOS;

import DADOS.DAOS.CondutorDAO;
import dados_entidades.Condutor;
import java.util.List;

/**
 *
 * @author Sarah
 */
public class CondutorServico {
    private CondutorDAO dao = new CondutorDAO();
    public void save_cond(Condutor c){
        dao.save_cond(c);
    }
    
    public List<Condutor> listar(){
        return dao.listar();
    }
    
    public void editar(Condutor c){
        dao.editar(c);
    }
    
    public void excluir(Condutor c){
        dao.excluir(c);
    }
    
    public List<Condutor> buscar(String nome){
        return dao.buscar(nome);
        
    }
}
