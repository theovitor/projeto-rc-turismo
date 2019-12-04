/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVICOS;

import DADOS.DAOS.PassageiroDAO;
import dados_entidades.Passageiro;
import java.util.List;

/**
 *
 * @author IFNMG
 */
public class PassageiroServico {
    private PassageiroDAO dao = new PassageiroDAO();
    public void save_passag(Passageiro p){
        dao.save_passag(p);
    }
    
    public List<Passageiro> listar(){
        return dao.listar();
    }
    
    public void editar(Passageiro p){
        dao.editar(p);
    }
    
    public void excluir(Passageiro p){
        dao.excluir(p);
    }
    
    public List<Passageiro> buscar(String n){
        return dao.buscar(n);
        
    } 
}
