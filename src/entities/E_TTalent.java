package entities;

import javax.persistence.*;

@Entity
@Table(name = "T_TALENT", schema = "IG2I_POO", catalog = "")
public class E_TTalent {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_TALENT")
    private int idTalent;
    @Basic
    @Column(name = "ID_MEMBRE")
    private int idMembre;
    @Basic
    @Column(name = "ID_COMPETENCE")
    private int idCompetence;
    @Basic
    @Column(name = "DetailCompetence")
    private String detailCompetence;

    public int getIdTalent() {
        return idTalent;
    }

    public void setIdTalent(int idTalent) {
        this.idTalent = idTalent;
    }

    public int getIdMembre() {
        return idMembre;
    }

    public void setIdMembre(int idMembre) {
        this.idMembre = idMembre;
    }

    public int getIdCompetence() {
        return idCompetence;
    }

    public void setIdCompetence(int idCompetence) {
        this.idCompetence = idCompetence;
    }

    public String getDetailCompetence() {
        return detailCompetence;
    }

    public void setDetailCompetence(String detailCompetence) {
        this.detailCompetence = detailCompetence;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        E_TTalent e_tTalent = (E_TTalent) o;

        if (idTalent != e_tTalent.idTalent) return false;
        if (idMembre != e_tTalent.idMembre) return false;
        if (idCompetence != e_tTalent.idCompetence) return false;
        if (detailCompetence != null ? !detailCompetence.equals(e_tTalent.detailCompetence) : e_tTalent.detailCompetence != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idTalent;
        result = 31 * result + idMembre;
        result = 31 * result + idCompetence;
        result = 31 * result + (detailCompetence != null ? detailCompetence.hashCode() : 0);
        return result;
    }
}
