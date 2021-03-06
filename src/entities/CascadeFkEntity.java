package entities;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "CascadeFkEntity")
@Table(name = "T_EX_CASCADE_FK", schema = "IG2I_POO", catalog = "")
public class CascadeFkEntity {
    @Id
    @Basic
    @Column(name = "ID_FK")
    private Integer idFk;
    @ManyToOne
    @JoinColumn(name = "ID_REF")
    private CascadeRefEntity refEntity;
    @Basic
    @Column(name = "LIB_FK")
    private String libFk;

    public Integer getIdFk() {
        return idFk;
    }

    public void setIdFk(Integer idFk) {
        this.idFk = idFk;
    }

    public CascadeRefEntity getRefEntity() {
        return refEntity;
    }

    public void setRefEntity(CascadeRefEntity idRef) {
        this.refEntity = idRef;
    }

    public String getLibFk() {
        return libFk;
    }

    public void setLibFk(String libFk) {
        this.libFk = libFk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CascadeFkEntity that = (CascadeFkEntity) o;
        return Objects.equals(idFk, that.idFk) && Objects.equals(refEntity, that.refEntity) && Objects.equals(libFk, that.libFk);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFk, refEntity, libFk);
    }
}
