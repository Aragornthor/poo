package entities;

import javax.persistence.*;

@Entity(name = "CompetenceEntity")
@Table(name = "T_COMPETENCE", schema = "IG2I_POO", catalog = "")
public class CompetenceEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_COMPETENCE")
    private int idCompetence;
    @Basic
    @Column(name = "COMPETENCE")
    private String competence;
    @Basic
    @Column(name = "ID_CATEGORIE")
    private int idCategorie;

    public int getIdCompetence() {
        return idCompetence;
    }

    public void setIdCompetence(int idCompetence) {
        this.idCompetence = idCompetence;
    }

    public String getCompetence() {
        return competence;
    }

    public void setCompetence(String competence) {
        this.competence = competence;
    }

    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CompetenceEntity that = (CompetenceEntity) o;

        if (idCompetence != that.idCompetence) return false;
        if (idCategorie != that.idCategorie) return false;
        if (competence != null ? !competence.equals(that.competence) : that.competence != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCompetence;
        result = 31 * result + (competence != null ? competence.hashCode() : 0);
        result = 31 * result + idCategorie;
        return result;
    }
}
