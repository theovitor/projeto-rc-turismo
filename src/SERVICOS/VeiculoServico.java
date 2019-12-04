/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVICOS;


import DADOS.DAOS.VeiculoDAO;
import dados_entidades.Veiculo;
import java.util.List;

/**
 *
 * @author IFNMG
 */
public class VeiculoServico {
    
    private VeiculoDAO dao = new VeiculoDAO();
    public void save_veic(Veiculo v){
        dao.save_veic(v);
    }
    
    public List<Veiculo> listar(){
        return dao.listar();
    }
    
    public void editar(Veiculo v){
        dao.editar(v);
    }
    
    public void excluir(Veiculo v){
        dao.excluir(v);
    }
    
    public List<Veiculo> buscar(String n){
        return dao.buscar(n);
    }
    
}
