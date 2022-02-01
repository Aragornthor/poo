package entities;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity(name = "CascadeRefEntity")
@Table(name = "T_EX_CASCADE_REF", schema = "IG2I_POO", catalog = "")
public class CascadeRefEntity {
    @Id
    @Basic
    @Column(name = "ID_REF")
    private Integer idRef;
    @Basic
    @Column(name = "LIB_REF")
    private String libRef;
    @OneToMany(mappedBy = "refEntity", cascade = CascadeType.REMOVE)
    private List<CascadeFkEntity> fkEntity;

    public Integer getIdRef() {
        return idRef;
    }

    public void setIdRef(Integer idRef) {
        this.idRef = idRef;
    }

    public String getLibRef() {
        return libRef;
    }

    public void setLibRef(String libRef) {
        this.libRef = libRef;
    }

    public List<CascadeFkEntity> getFkEntity() {
        return fkEntity;
    }

    public void setFkEntity(List<CascadeFkEntity> fkEntity) {
        this.fkEntity = fkEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CascadeRefEntity that = (CascadeRefEntity) o;
        return Objects.equals(idRef, that.idRef) && Objects.equals(libRef, that.libRef);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRef, libRef);
    }
}
