package Commons;
// Generated 10/jun/2017 0:10:28 by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Recurso generated by hbm2java
 */
@Entity
@Table(name="Recurso"
    ,catalog="eventos"
)
public class Recurso  implements java.io.Serializable {


     private Integer idRecurso;
     private int quantidadeDisponivel;
     private String designacao;
     private float valorUnitario;
     private int visivel;

    public Recurso() {
    }

    public Recurso(int quantidadeDisponivel, String designacao, float valorUnitario, int visivel) {
       this.quantidadeDisponivel = quantidadeDisponivel;
       this.designacao = designacao;
       this.valorUnitario = valorUnitario;
       this.visivel = visivel;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id_recurso", unique=true, nullable=false)
    public Integer getIdRecurso() {
        return this.idRecurso;
    }
    
    public void setIdRecurso(Integer idRecurso) {
        this.idRecurso = idRecurso;
    }

    
    @Column(name="quantidadeDisponivel", nullable=false)
    public int getQuantidadeDisponivel() {
        return this.quantidadeDisponivel;
    }
    
    public void setQuantidadeDisponivel(int quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    
    @Column(name="designacao", nullable=false, length=45)
    public String getDesignacao() {
        return this.designacao;
    }
    
    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    
    @Column(name="valorUnitario", nullable=false, precision=12, scale=0)
    public float getValorUnitario() {
        return this.valorUnitario;
    }
    
    public void setValorUnitario(float valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    
    @Column(name="visivel", nullable=false)
    public int getVisivel() {
        return this.visivel;
    }
    
    public void setVisivel(int visivel) {
        this.visivel = visivel;
    }




}


