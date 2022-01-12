package entities;

import javax.persistence.*;

@Entity(name = "MembreEntity")
@Table(name = "T_MEMBRE", schema = "IG2I_POO", catalog = "")
public class MembreEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_MEMBRE")
    private int idMembre;
    @Basic
    @Column(name = "NOM_MEMBRE")
    private String nomMembre;
    @Basic
    @Column(name = "PRENOM_MEMBRE")
    private String prenomMembre;
    @Basic
    @Column(name = "MAIL_MEMBRE")
    private String mailMembre;
    @Basic
    @Column(name = "STATUT")
    private String statut;
    @Basic
    @Column(name = "SOLDE_HEURE")
    private int soldeHeure;
    @Basic
    @Column(name = "SOLDE_ECU")
    private int soldeEcu;
    @Basic
    @Column(name = "TYPE_MEMBRE")
    private String typeMembre;
    @Basic
    @Column(name = "HABITANT")
    private Integer habitant;
    @Basic
    @Column(name = "RAISON_SOCIALE")
    private String raisonSociale;
    @Basic
    @Column(name = "CLIENT_COMPTE_ECU")
    private int clientCompteEcu;

    public int getIdMembre() {
        return idMembre;
    }

    public void setIdMembre(int idMembre) {
        this.idMembre = idMembre;
    }

    public String getNomMembre() {
        return nomMembre;
    }

    public void setNomMembre(String nomMembre) {
        this.nomMembre = nomMembre;
    }

    public String getPrenomMembre() {
        return prenomMembre;
    }

    public void setPrenomMembre(String prenomMembre) {
        this.prenomMembre = prenomMembre;
    }

    public String getMailMembre() {
        return mailMembre;
    }

    public void setMailMembre(String mailMembre) {
        this.mailMembre = mailMembre;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public int getSoldeHeure() {
        return soldeHeure;
    }

    public void setSoldeHeure(int soldeHeure) {
        this.soldeHeure = soldeHeure;
    }

    public int getSoldeEcu() {
        return soldeEcu;
    }

    public void setSoldeEcu(int soldeEcu) {
        this.soldeEcu = soldeEcu;
    }

    public String getTypeMembre() {
        return typeMembre;
    }

    public void setTypeMembre(String typeMembre) {
        this.typeMembre = typeMembre;
    }

    public Integer getHabitant() {
        return habitant;
    }

    public void setHabitant(Integer habitant) {
        this.habitant = habitant;
    }

    public String getRaisonSociale() {
        return raisonSociale;
    }

    public void setRaisonSociale(String raisonSociale) {
        this.raisonSociale = raisonSociale;
    }

    public int getClientCompteEcu() {
        return clientCompteEcu;
    }

    public void setClientCompteEcu(int clientCompteEcu) {
        this.clientCompteEcu = clientCompteEcu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MembreEntity membreEntity = (MembreEntity) o;

        if (idMembre != membreEntity.idMembre) return false;
        if (soldeHeure != membreEntity.soldeHeure) return false;
        if (soldeEcu != membreEntity.soldeEcu) return false;
        if (clientCompteEcu != membreEntity.clientCompteEcu) return false;
        if (nomMembre != null ? !nomMembre.equals(membreEntity.nomMembre) : membreEntity.nomMembre != null) return false;
        if (prenomMembre != null ? !prenomMembre.equals(membreEntity.prenomMembre) : membreEntity.prenomMembre != null)
            return false;
        if (mailMembre != null ? !mailMembre.equals(membreEntity.mailMembre) : membreEntity.mailMembre != null) return false;
        if (statut != null ? !statut.equals(membreEntity.statut) : membreEntity.statut != null) return false;
        if (typeMembre != null ? !typeMembre.equals(membreEntity.typeMembre) : membreEntity.typeMembre != null) return false;
        if (habitant != null ? !habitant.equals(membreEntity.habitant) : membreEntity.habitant != null) return false;
        if (raisonSociale != null ? !raisonSociale.equals(membreEntity.raisonSociale) : membreEntity.raisonSociale != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idMembre;
        result = 31 * result + (nomMembre != null ? nomMembre.hashCode() : 0);
        result = 31 * result + (prenomMembre != null ? prenomMembre.hashCode() : 0);
        result = 31 * result + (mailMembre != null ? mailMembre.hashCode() : 0);
        result = 31 * result + (statut != null ? statut.hashCode() : 0);
        result = 31 * result + soldeHeure;
        result = 31 * result + soldeEcu;
        result = 31 * result + (typeMembre != null ? typeMembre.hashCode() : 0);
        result = 31 * result + (habitant != null ? habitant.hashCode() : 0);
        result = 31 * result + (raisonSociale != null ? raisonSociale.hashCode() : 0);
        result = 31 * result + clientCompteEcu;
        return result;
    }
}
