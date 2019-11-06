
package DADOS.DAOS;

import UTIL.JPAUtil;
import dados_entidades.Condutor;
import javax.persistence.EntityManager;
        
public class CondutorDAO {
    public void save_cond(Condutor c){
        
        EntityManager gerenciador =JPAUtil.getGerenciador();
        gerenciador.getTransaction().begin();
        gerenciador.persist(c);
        gerenciador.getTransaction().commit();
        
    }
}
