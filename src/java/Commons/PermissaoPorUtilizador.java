package Commons;
// Generated 10/jun/2017 0:10:28 by Hibernate Tools 4.3.1


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * PermissaoPorUtilizador generated by hbm2java
 */
@Entity
@Table(name="PermissaoPorUtilizador"
    ,catalog="eventos"
)
public class PermissaoPorUtilizador  implements java.io.Serializable {


     private PermissaoPorUtilizadorId id;
     private int permitido;

    public PermissaoPorUtilizador() {
    }

    public PermissaoPorUtilizador(PermissaoPorUtilizadorId id, int permitido) {
       this.id = id;
       this.permitido = permitido;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="idPermissao", column=@Column(name="id_permissao", nullable=false) ), 
        @AttributeOverride(name="idUtilizador", column=@Column(name="id_utilizador", nullable=false) ) } )
    public PermissaoPorUtilizadorId getId() {
        return this.id;
    }
    
    public void setId(PermissaoPorUtilizadorId id) {
        this.id = id;
    }

    
    @Column(name="permitido", nullable=false)
    public int getPermitido() {
        return this.permitido;
    }
    
    public void setPermitido(int permitido) {
        this.permitido = permitido;
    }




}

