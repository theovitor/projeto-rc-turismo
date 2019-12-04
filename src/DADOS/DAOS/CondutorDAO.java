
package DADOS.DAOS;

import UTIL.JPAUtil;
import dados_entidades.Condutor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
        
public class CondutorDAO {
    public void save_cond(Condutor c){
        
        EntityManager gerenciador =JPAUtil.getGerenciador();
        gerenciador.getTransaction().begin();
        gerenciador.persist(c);
        gerenciador.getTransaction().commit();
    }
    
    public List<Condutor> listar() {

        EntityManager gerenciador = JPAUtil.getGerenciador();
        TypedQuery consulta = gerenciador.createQuery(
                "Select a from Condutor a", Condutor.class);
        return consulta.getResultList();
    }
    
    public void editar(Condutor c){
        EntityManager gerenciador = JPAUtil.getGerenciador();
        gerenciador.getTransaction().begin();
        gerenciador.merge(c);
        gerenciador.getTransaction().commit();
    }
    
    public void excluir(Condutor c){
        EntityManager gerenciador = JPAUtil.getGerenciador();
        gerenciador.getTransaction().begin();
        c=gerenciador.merge(c);
        gerenciador.remove(c);
        gerenciador.getTransaction().commit();
    }
    
    public List<Condutor> buscar(String nome){
        EntityManager gerenciador = JPAUtil.getGerenciador();
        TypedQuery consulta = gerenciador.createQuery(
                "Select a from Condutor a where a.nome_motorista like :nome_motorista", Condutor.class);
        consulta.setParameter("nome_motorista", nome+"%");
        return consulta.getResultList();
        
    }
}
