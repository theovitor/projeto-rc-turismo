/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVICOS;

import DADOS.DAOS.LocalidadeDAO;
import dados_entidades.Localidade;
import java.util.List;

/**
 *
 * @author Sarah
 */
public class LocalidadeServico {
    private LocalidadeDAO dao = new LocalidadeDAO();
    public void save_local(Localidade l){
        dao.save_local(l);
    }
    
    public List<Localidade> listar(){
        return dao.listar();
    }
    
    public void editar(Localidade l){
        dao.editar(l);
    }
    
    public void excluir(Localidade l){
        dao.excluir(l);
    }
    
    public List<Localidade> buscar(String n){
        return dao.buscar(n);
        
    }
}
