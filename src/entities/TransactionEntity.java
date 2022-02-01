package entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "T_TRANSACTION", schema = "IG2I_POO", catalog = "")
public class TransactionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_TRANSACTION")
    private int idTransaction;
    @Basic
    @Column(name = "DATE_CREATION")
    private Date dateCreation;
    @Basic
    @Column(name = "ETAT")
    private String etat;
    @Basic
    @Column(name = "DATE_VALIDATION")
    private Date dateValidation;
    @Basic
    @Column(name = "ID_PROPOSITION")
    private int idProposition;
    @Basic
    @Column(name = "MONTANT_TRANSACTION")
    private int montantTransaction;
    @Basic
    @Column(name = "ID_MEMBRE_BENEFICIAIRE")
    private int idMembreBeneficiaire;
    @Basic
    @Column(name = "MONTANT_ECU")
    private int montantEcu;

    public int getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(int idTransaction) {
        this.idTransaction = idTransaction;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Date getDateValidation() {
        return dateValidation;
    }

    public void setDateValidation(Date dateValidation) {
        this.dateValidation = dateValidation;
    }

    public int getIdProposition() {
        return idProposition;
    }

    public void setIdProposition(int idProposition) {
        this.idProposition = idProposition;
    }

    public int getMontantTransaction() {
        return montantTransaction;
    }

    public void setMontantTransaction(int montantTransaction) {
        this.montantTransaction = montantTransaction;
    }

    public int getIdMembreBeneficiaire() {
        return idMembreBeneficiaire;
    }

    public void setIdMembreBeneficiaire(int idMembreBeneficiaire) {
        this.idMembreBeneficiaire = idMembreBeneficiaire;
    }

    public int getMontantEcu() {
        return montantEcu;
    }

    public void setMontantEcu(int montantEcu) {
        this.montantEcu = montantEcu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransactionEntity that = (TransactionEntity) o;

        if (idTransaction != that.idTransaction) return false;
        if (idProposition != that.idProposition) return false;
        if (montantTransaction != that.montantTransaction) return false;
        if (idMembreBeneficiaire != that.idMembreBeneficiaire) return false;
        if (montantEcu != that.montantEcu) return false;
        if (dateCreation != null ? !dateCreation.equals(that.dateCreation) : that.dateCreation != null) return false;
        if (etat != null ? !etat.equals(that.etat) : that.etat != null) return false;
        if (dateValidation != null ? !dateValidation.equals(that.dateValidation) : that.dateValidation != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idTransaction;
        result = 31 * result + (dateCreation != null ? dateCreation.hashCode() : 0);
        result = 31 * result + (etat != null ? etat.hashCode() : 0);
        result = 31 * result + (dateValidation != null ? dateValidation.hashCode() : 0);
        result = 31 * result + idProposition;
        result = 31 * result + montantTransaction;
        result = 31 * result + idMembreBeneficiaire;
        result = 31 * result + montantEcu;
        return result;
    }
}
