
package TESTES;

import dados_entidades.Condutor;
import javax.persistence.*;
import UTIL.JPAUtil;


public class teste_inserir {
    public static void main(String[] args) {
        Condutor c1=new Condutor();
        c1.setCNH(151511);
        c1.setNome_motorista("hader messias");
        c1.setSetor("Suprimentos");
        
        EntityManager gerenciador=JPAUtil.getGerenciador();
        gerenciador.getTransaction().begin();
        gerenciador.persist(c1);
        gerenciador.getTransaction().commit();
        gerenciador.close();
    }
    
    
    
}
