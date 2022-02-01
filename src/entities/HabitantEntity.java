package entities;

import javax.persistence.*;

@Entity(name = "HabitantEntity")
@Table(name = "T_MEMBRE", schema = "IG2I_POO", catalog = "")
@DiscriminatorValue("HAB")
public class HabitantEntity extends MembreEntity {

    @Basic
    @Column(name = "elu")
    private Boolean elu;

    public HabitantEntity() {
        super();
    }

    public Boolean isElu() {
        return elu;
    }

    public void setElu(Boolean elu) {
        this.elu = elu;
    }
}
