package entities;

import javax.persistence.*;

@Entity(name = "VacancierEntity")
@Table(name = "T_MEMBRE", schema = "IG2I_POO", catalog = "")
@DiscriminatorValue("VAC")
public class VacancierEntity extends MembreEntity {
    @Basic
    @Column(name = "mode_logement")
    private String modeLogement;

    public VacancierEntity() {
        super();
    }

    public String getModeLogement() {
        return modeLogement;
    }

    public void setModeLogement(String modeLogement) {
        this.modeLogement = modeLogement;
    }
}
