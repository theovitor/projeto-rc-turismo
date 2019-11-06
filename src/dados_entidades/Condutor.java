package dados_entidades;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Condutor {
   
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id_motorista;
   private String nome_motorista;
   private String setor;
   private int CNH;
   
   
public Condutor(){}

    public Condutor(String nome_motorista, String setor, int CNH) {
        this.setNome_motorista (nome_motorista);
        this.setSetor(setor);
        this.setCNH(CNH);
    }


    public Integer getId_motorista() {
        return id_motorista;
    }

    public void setId_motorista(Integer id_motorista) {
        this.id_motorista = id_motorista;
    }

    public String getNome_motorista() {
        return nome_motorista;
    }

    public void setNome_motorista(String nome_motorista) {
        this.nome_motorista = nome_motorista;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public int getCNH() {
        return CNH;
    }

    public void setCNH(int CNH) {
        this.CNH = CNH;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id_motorista);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Condutor other = (Condutor) obj;
        if (!Objects.equals(this.id_motorista, other.id_motorista)) {
            return false;
        }
        return true;
    }
   
   
    
}
