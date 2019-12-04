
package DADOS.DAOS;

import UTIL.JPAUtil;
import dados_entidades.Veiculo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
        
public class VeiculoDAO {
    public void save_veic(Veiculo v){
        
        EntityManager gerenciador =JPAUtil.getGerenciador();
        gerenciador.getTransaction().begin();
        gerenciador.persist(v);
        gerenciador.getTransaction().commit();
        
    }
    
    
    public List<Veiculo> listar() {

        EntityManager gerenciador = JPAUtil.getGerenciador();
        TypedQuery consulta = gerenciador.createQuery(
                "Select a from Veiculo a", Veiculo.class);
        return consulta.getResultList();
        
    }
    
    public void editar(Veiculo v){
        EntityManager gerenciador = JPAUtil.getGerenciador();
        gerenciador.getTransaction().begin();
        gerenciador.merge(v);
        gerenciador.getTransaction().commit();
    }
    
    public void excluir(Veiculo v){
        EntityManager gerenciador = JPAUtil.getGerenciador();
        gerenciador.getTransaction().begin();
        v=gerenciador.merge(v);
        gerenciador.remove(v);
        gerenciador.getTransaction().commit();
    }
    public List<Veiculo> buscar(String n){
        EntityManager gerenciador = JPAUtil.getGerenciador();
        TypedQuery consulta = gerenciador.createQuery(
                "Select a from Veiculo a where a.modelo like :modelo", Veiculo.class);
        consulta.setParameter("modelo", n+"%");
        return consulta.getResultList();
    }
}
