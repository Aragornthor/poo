package entities;

public enum EntitiesEnum {
    CATEGORIE(CategorieEntity.class),
    COMPETENCE(CompetenceEntity.class),
    MEMBRE(MembreEntity.class),
    TALENT(TalentEntity.class);

    private Class classType;

    EntitiesEnum(Class classType) {
        this.classType = classType;
    }

    public Class getClassType() {
        return this.classType;
    }
}
