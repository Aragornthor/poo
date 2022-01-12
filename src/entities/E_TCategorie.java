package entities;

import javax.persistence.*;

@Entity(name = "CategorieEntity")
@Table(name = "T_CATEGORIE", schema = "IG2I_POO", catalog = "")
public class E_TCategorie {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_CATEGORIE")
    private int idCategorie;
    @Basic
    @Column(name = "CATEGORIE")
    private String categorie;

    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        E_TCategorie that = (E_TCategorie) o;

        if (idCategorie != that.idCategorie) return false;
        if (categorie != null ? !categorie.equals(that.categorie) : that.categorie != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCategorie;
        result = 31 * result + (categorie != null ? categorie.hashCode() : 0);
        return result;
    }
}
