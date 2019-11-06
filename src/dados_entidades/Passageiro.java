package dados_entidades;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Passageiro {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_passageiro;
    private String nome;
    private String setor;
    private boolean dirige;
    private int CPF;
    private String rua;
    private int numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private int CEP;
    private String email;
    private String gerente;
    private String email_gerente;

    public Passageiro() {
    }

    public Passageiro(String nome, String setor, boolean dirige, int CPF, String rua, int numero, String complemento, String bairro, String cidade, int CEP, String email, String gerente, String email_gerente) {
        this.setNome(nome);
        this.setSetor(setor);
        this.setDirige(dirige);
        this.setCPF(CPF);
        this.setRua(rua);
        this.setNumero(numero);
        this.setComplemento(complemento);
        this.setBairro(bairro);
        this.setCidade(cidade);
        this.setCEP(CEP);
        this.setEmail(email);
        this.setGerente(gerente);
        this.setEmail_gerente(email_gerente);
    }

    
    
    public Integer getId_passageiro() {
        return id_passageiro;
    }

    public void setId_passageiro(Integer id_passageiro) {
        this.id_passageiro = id_passageiro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public boolean isDirige() {
        return dirige;
    }

    public void setDirige(boolean dirige) {
        this.dirige = dirige;
    }

    public int getCPF() {
        return CPF;
    }

    public void setCPF(int CPF) {
        this.CPF = CPF;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String endereco) {
        this.rua = endereco;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getCEP() {
        return CEP;
    }

    public void setCEP(int CEP) {
        this.CEP = CEP;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGerente() {
        return gerente;
    }

    public void setGerente(String gerente) {
        this.gerente = gerente;
    }

    public String getEmail_gerente() {
        return email_gerente;
    }

    public void setEmail_gerente(String email_gerente) {
        this.email_gerente = email_gerente;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id_passageiro);
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
        final Passageiro other = (Passageiro) obj;
        if (!Objects.equals(this.id_passageiro, other.id_passageiro)) {
            return false;
        }
        return true;
    }


    
}
