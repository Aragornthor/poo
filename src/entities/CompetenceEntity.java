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

    @ManyToOne
    @JoinColumn(name = "ID_CATEGORIE")
    private CategorieEntity categorieEntity;

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

    public CategorieEntity getCategorieEntity() {
        return categorieEntity;
    }

    public void setCategorieEntity(CategorieEntity categorieEntity) {
        this.categorieEntity = categorieEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CompetenceEntity that = (CompetenceEntity) o;

        if (idCompetence != that.idCompetence) return false;
        if (competence != null ? !competence.equals(that.competence) : that.competence != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCompetence;
        result = 31 * result + (competence != null ? competence.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CompetenceEntity:\n\tNom de catégorie : " + categorieEntity.getCategorie() + "\n\tNom de compétence : " + competence;
    }
}
