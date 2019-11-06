
package DADOS.DAOS;

import UTIL.JPAUtil;
import dados_entidades.Passageiro;
import javax.persistence.EntityManager;
        
public class PassageiroDAO {
    public void save_passag(Passageiro p){
        
        EntityManager gerenciador =JPAUtil.getGerenciador();
        gerenciador.getTransaction().begin();
        gerenciador.persist(p);
        gerenciador.getTransaction().commit();
        
    }
}
