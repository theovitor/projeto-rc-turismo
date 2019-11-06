
package DADOS.DAOS;

import UTIL.JPAUtil;
import dados_entidades.Localidade;
import javax.persistence.EntityManager;
        
public class LocalidadeDAO {
    public void save_local(Localidade l){
        
        EntityManager gerenciador =JPAUtil.getGerenciador();
        gerenciador.getTransaction().begin();
        gerenciador.persist(l);
        gerenciador.getTransaction().commit();
        
    }
}
