
package DADOS.DAOS;

import UTIL.JPAUtil;
import dados_entidades.Localidade;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
        
public class LocalidadeDAO {
    public void save_local(Localidade l){
        
        EntityManager gerenciador =JPAUtil.getGerenciador();
        gerenciador.getTransaction().begin();
        gerenciador.persist(l);
        gerenciador.getTransaction().commit();
    }
    
    public List<Localidade> listar() {

        EntityManager gerenciador = JPAUtil.getGerenciador();
        TypedQuery consulta = gerenciador.createQuery(
                "Select a from Localidade a", Localidade.class);
        return consulta.getResultList();
    }
    
    public void editar(Localidade l){
        EntityManager gerenciador = JPAUtil.getGerenciador();
        gerenciador.getTransaction().begin();
        gerenciador.merge(l);
        gerenciador.getTransaction().commit();
    }
    
    public void excluir(Localidade l){
        EntityManager gerenciador = JPAUtil.getGerenciador();
        gerenciador.getTransaction().begin();
        l=gerenciador.merge(l);
        gerenciador.remove(l);
        gerenciador.getTransaction().commit();
    }
    public List<Localidade> buscar(String n){
        EntityManager gerenciador = JPAUtil.getGerenciador();
        TypedQuery consulta = gerenciador.createQuery(
                "Select a from Localidade a where a.nome_local like :nome_local", Localidade.class);
        consulta.setParameter("nome_local", n+"%");
        return consulta.getResultList();
        
        
    }
}
