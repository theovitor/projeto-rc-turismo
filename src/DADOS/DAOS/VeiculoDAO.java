
package DADOS.DAOS;

import UTIL.JPAUtil;
import dados_entidades.Veiculo;
import javax.persistence.EntityManager;
        
public class VeiculoDAO {
    public void save_veic(Veiculo v){
        
        EntityManager gerenciador =JPAUtil.getGerenciador();
        gerenciador.getTransaction().begin();
        gerenciador.persist(v);
        gerenciador.getTransaction().commit();
        
    }
}
