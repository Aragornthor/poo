package entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "T_COTISATIONS", schema = "IG2I_POO", catalog = "")
public class CotisationsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_COTISATION")
    private int idCotisation;
    @Basic
    @Column(name = "DATE_COTISATION")
    private Date dateCotisation;
    @Basic
    @Column(name = "ID_MEMBRE")
    private int idMembre;
    @Basic
    @Column(name = "ID_TARIF")
    private int idTarif;

    public int getIdCotisation() {
        return idCotisation;
    }

    public void setIdCotisation(int idCotisation) {
        this.idCotisation = idCotisation;
    }

    public Date getDateCotisation() {
        return dateCotisation;
    }

    public void setDateCotisation(Date dateCotisation) {
        this.dateCotisation = dateCotisation;
    }

    public int getIdMembre() {
        return idMembre;
    }

    public void setIdMembre(int idMembre) {
        this.idMembre = idMembre;
    }

    public int getIdTarif() {
        return idTarif;
    }

    public void setIdTarif(int idTarif) {
        this.idTarif = idTarif;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CotisationsEntity that = (CotisationsEntity) o;

        if (idCotisation != that.idCotisation) return false;
        if (idMembre != that.idMembre) return false;
        if (idTarif != that.idTarif) return false;
        if (dateCotisation != null ? !dateCotisation.equals(that.dateCotisation) : that.dateCotisation != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCotisation;
        result = 31 * result + (dateCotisation != null ? dateCotisation.hashCode() : 0);
        result = 31 * result + idMembre;
        result = 31 * result + idTarif;
        return result;
    }
}
