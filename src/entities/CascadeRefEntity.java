package entities;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "CascadeRefEntity")
@Table(name = "T_EX_CASCADE_REF", schema = "IG2I_POO", catalog = "")
public class CascadeRefEntity {
    @Id
    @Basic
    @Column(name = "ID_REF")
    private Integer idRef;
    @Id
    @Basic
    @Column(name = "LIB_REF")
    private String libRef;

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
