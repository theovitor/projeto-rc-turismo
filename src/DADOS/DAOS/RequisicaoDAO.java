/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DADOS.DAOS;

import UTIL.JPAUtil;
import dados_entidades.Requisicao;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author IFNMG
 */
public class RequisicaoDAO {
    
    public void save_rc(Requisicao r){
        
        EntityManager gerenciador =JPAUtil.getGerenciador();
        gerenciador.getTransaction().begin();
        gerenciador.persist(r);
        gerenciador.getTransaction().commit();
        
    }
    
    
    public List<Requisicao> listar() {

        EntityManager gerenciador = JPAUtil.getGerenciador();
        TypedQuery consulta = gerenciador.createQuery(
                "Select a from Requisicao a", Requisicao.class);
        return consulta.getResultList();
        
    }
    
    public void editar(Requisicao r){
        EntityManager gerenciador = JPAUtil.getGerenciador();
        gerenciador.getTransaction().begin();
        gerenciador.merge(r);
        gerenciador.getTransaction().commit();
    }
    
    public void excluir(Requisicao r){
        EntityManager gerenciador = JPAUtil.getGerenciador();
        gerenciador.getTransaction().begin();
        r=gerenciador.merge(r);
        gerenciador.remove(r);
        gerenciador.getTransaction().commit();
    }
    public List<Requisicao> buscar(LocalDate r){
        EntityManager gerenciador = JPAUtil.getGerenciador();
        TypedQuery consulta = gerenciador.createQuery(
                "Select a from Requisicao a where a.ida like :ida", Requisicao.class);
        consulta.setParameter("ida", r);
        return consulta.getResultList();
    
}
    
}
