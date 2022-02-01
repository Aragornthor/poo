package entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "T_PROPOSITION", schema = "IG2I_POO", catalog = "")
public class PropositionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_PROPOSITION")
    private int idProposition;
    @Basic
    @Column(name = "ID_TALENT")
    private int idTalent;
    @Basic
    @Column(name = "DESCRIPTION")
    private String description;
    @Basic
    @Column(name = "DATE_DEBUT")
    private Date dateDebut;
    @Basic
    @Column(name = "DATE_FIN")
    private Date dateFin;

    public int getIdProposition() {
        return idProposition;
    }

    public void setIdProposition(int idProposition) {
        this.idProposition = idProposition;
    }

    public int getIdTalent() {
        return idTalent;
    }

    public void setIdTalent(int idTalent) {
        this.idTalent = idTalent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PropositionEntity that = (PropositionEntity) o;

        if (idProposition != that.idProposition) return false;
        if (idTalent != that.idTalent) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (dateDebut != null ? !dateDebut.equals(that.dateDebut) : that.dateDebut != null) return false;
        if (dateFin != null ? !dateFin.equals(that.dateFin) : that.dateFin != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idProposition;
        result = 31 * result + idTalent;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (dateDebut != null ? dateDebut.hashCode() : 0);
        result = 31 * result + (dateFin != null ? dateFin.hashCode() : 0);
        return result;
    }
}
