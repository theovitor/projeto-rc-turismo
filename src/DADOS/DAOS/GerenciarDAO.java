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
 * @author Sarah
 */
public class GerenciarDAO {
    public void save_grc(Requisicao g){
        
        EntityManager gerenciador =JPAUtil.getGerenciador();
        gerenciador.getTransaction().begin();
        gerenciador.persist(g);
        gerenciador.getTransaction().commit();
        
    }
    
    
    public List<Requisicao> listar() {

        EntityManager gerenciador = JPAUtil.getGerenciador();
        TypedQuery consulta = gerenciador.createQuery(
                "Select a from Requisicao a", Requisicao.class);
        return consulta.getResultList();
        
    }
    
    public void editar(Requisicao g){
        EntityManager gerenciador = JPAUtil.getGerenciador();
        gerenciador.getTransaction().begin();
        gerenciador.merge(g);
        gerenciador.getTransaction().commit();
    }
    
    public void excluir(Requisicao g){
        EntityManager gerenciador = JPAUtil.getGerenciador();
        gerenciador.getTransaction().begin();
        g=gerenciador.merge(g);
        gerenciador.remove(g);
        gerenciador.getTransaction().commit();
    }
    public List<Requisicao> buscar(LocalDate g){
        EntityManager gerenciador = JPAUtil.getGerenciador();
        TypedQuery consulta = gerenciador.createQuery(
                "Select a from Requisicao a where a.ida like :ida", Requisicao.class);
        consulta.setParameter("ida", g);
        return consulta.getResultList();
    
}
}
