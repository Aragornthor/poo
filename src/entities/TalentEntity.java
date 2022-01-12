package entities;

import javax.persistence.*;

@Entity(name = "TalentEntity")
@Table(name = "T_TALENT", schema = "IG2I_POO", catalog = "")
public class TalentEntity {
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

        TalentEntity talentEntity = (TalentEntity) o;

        if (idTalent != talentEntity.idTalent) return false;
        if (idMembre != talentEntity.idMembre) return false;
        if (idCompetence != talentEntity.idCompetence) return false;
        if (detailCompetence != null ? !detailCompetence.equals(talentEntity.detailCompetence) : talentEntity.detailCompetence != null)
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
