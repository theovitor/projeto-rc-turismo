/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVICOS;

import DADOS.DAOS.GerenciarDAO;
import dados_entidades.Requisicao;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Sarah
 */
public class GerenciarServico {
    private GerenciarDAO dao = new GerenciarDAO();
    public void save_grc(Requisicao g){
        dao.save_grc(g);
    }
    
    public List<Requisicao> listar(){
        return dao.listar();
    }
    
    public void editar(Requisicao g){
        dao.editar(g);
    }
    
    public void excluir(Requisicao g){
        dao.excluir(g);
    }
    
    public List<Requisicao> buscar(LocalDate g){
        return dao.buscar(g);
    }
}
