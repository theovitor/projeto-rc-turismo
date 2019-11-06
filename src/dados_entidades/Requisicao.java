package dados_entidades;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Requisicao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_rc;
    private LocalDate ida;
    private LocalTime hora_ida;
    private LocalDate volta;
    private LocalTime hora_volta;
    
    @ManyToOne(optional = false)
    private Localidade origem;
    
    @ManyToOne(optional = false)
    private Localidade destino;
    
    private String centro_custo;
    
    
    @ManyToOne(optional = false)
    private Passageiro passageiro1;
    @ManyToOne
    private Passageiro passageiro2;
    @ManyToOne
    private Passageiro passageiro3;
    @ManyToOne
    private Passageiro passageiro4;
    
    
    private String motivo;
    private boolean hotel;
    private String observacoes;
    private String situacao;
    
    @ManyToOne
    private Condutor motorista;
    @ManyToOne
    private Veiculo carro;
    
    

    public Requisicao() {
    }

    public Requisicao(LocalDate ida, LocalTime hora_ida, LocalDate volta, LocalTime hora_volta, Localidade origem, Localidade destino, String centro_custo, Passageiro passageiro1, Passageiro passageiro2, Passageiro passageiro3, Passageiro passageiro4, String motivo, boolean hotel, String observacoes, String situacao, Condutor motorista, Veiculo carro) {
        this.setIda (ida);
        this.setHora_ida(hora_ida);
        this.setVolta(volta);
        this.setHora_volta(hora_volta);
        this.setOrigem(origem);
        this.setDestino(destino);
        this.setCentro_custo(centro_custo);
        this.setPassageiro1(passageiro1);
        this.setPassageiro2(passageiro2);
        this.setPassageiro3(passageiro3);
        this.setPassageiro4(passageiro4);
        this.setMotivo(motivo);
        this.setHotel(hotel);
        this.setObservacoes(observacoes);
        this.setSituacao(situacao);
        this.setMotorista(motorista);
        this.setCarro(carro);
    }

    public Integer getId_rc() {
        return id_rc;
    }

    public void setId_rc(Integer id_rc) {
        this.id_rc = id_rc;
    }

    public LocalDate getIda() {
        return ida;
    }

    public void setIda(LocalDate ida) {
        this.ida = ida;
    }

    public LocalTime getHora_ida() {
        return hora_ida;
    }

    public void setHora_ida(LocalTime hora_ida) {
        this.hora_ida = hora_ida;
    }

    public LocalDate getVolta() {
        return volta;
    }

    public void setVolta(LocalDate volta) {
        this.volta = volta;
    }

    public LocalTime getHora_volta() {
        return hora_volta;
    }

    public void setHora_volta(LocalTime hora_volta) {
        this.hora_volta = hora_volta;
    }

    public Localidade getOrigem() {
        return origem;
    }

    public void setOrigem(Localidade origem) {
        this.origem = origem;
    }

    public Localidade getDestino() {
        return destino;
    }

    public void setDestino(Localidade destino) {
        this.destino = destino;
    }

    public String getCentro_custo() {
        return centro_custo;
    }

    public void setCentro_custo(String centro_custo) {
        this.centro_custo = centro_custo;
    }

    public Passageiro getPassageiro1() {
        return passageiro1;
    }

    public void setPassageiro1(Passageiro passageiro1) {
        this.passageiro1 = passageiro1;
    }

    public Passageiro getPassageiro2() {
        return passageiro2;
    }

    public void setPassageiro2(Passageiro passageiro2) {
        this.passageiro2 = passageiro2;
    }

    public Passageiro getPassageiro3() {
        return passageiro3;
    }

    public void setPassageiro3(Passageiro passageiro3) {
        this.passageiro3 = passageiro3;
    }

    public Passageiro getPassageiro4() {
        return passageiro4;
    }

    public void setPassageiro4(Passageiro passageiro4) {
        this.passageiro4 = passageiro4;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public boolean isHotel() {
        return hotel;
    }

    public void setHotel(boolean hotel) {
        this.hotel = hotel;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Condutor getMotorista() {
        return motorista;
    }

    public void setMotorista(Condutor motorista) {
        this.motorista = motorista;
    }

    public Veiculo getCarro() {
        return carro;
    }

    public void setCarro(Veiculo carro) {
        this.carro = carro;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.id_rc);
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
        final Requisicao other = (Requisicao) obj;
        if (!Objects.equals(this.id_rc, other.id_rc)) {
            return false;
        }
        return true;
    }
    
    

}
