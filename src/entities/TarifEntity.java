package entities;

import javax.persistence.*;

@Entity
@Table(name = "T_TARIF", schema = "IG2I_POO", catalog = "")
public class TarifEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_TARIF")
    private int idTarif;
    @Basic
    @Column(name = "ANNEE")
    private int annee;
    @Basic
    @Column(name = "MONTANT")
    private int montant;

    public int getIdTarif() {
        return idTarif;
    }

    public void setIdTarif(int idTarif) {
        this.idTarif = idTarif;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TarifEntity that = (TarifEntity) o;

        if (idTarif != that.idTarif) return false;
        if (annee != that.annee) return false;
        if (montant != that.montant) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idTarif;
        result = 31 * result + annee;
        result = 31 * result + montant;
        return result;
    }
}
