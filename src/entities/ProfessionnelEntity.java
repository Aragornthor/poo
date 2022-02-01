package entities;

import javax.persistence.*;

@Entity(name = "ProfessionnelEntity")
@Table(name = "T_MEMBRE", schema = "IG2I_POO", catalog = "")
@DiscriminatorValue("PRO")
public class ProfessionnelEntity extends MembreEntity {
    @Basic
    @Column(name = "siret")
    private String siret;

    @Basic
    @Column(name = "codeApe")
    private String codeApe;

    @Basic
    @Column(name = "tribunal_commerce")
    private String tribunal;

    public ProfessionnelEntity() {
        super();
    }

    public String getSiret() {
        return siret;
    }

    public void setSiret(String siret) {
        this.siret = siret;
    }

    public String getCodeApe() {
        return codeApe;
    }

    public void setCodeApe(String codeApe) {
        this.codeApe = codeApe;
    }

    public String getTribunal() {
        return tribunal;
    }

    public void setTribunal(String tribunal) {
        this.tribunal = tribunal;
    }
}
