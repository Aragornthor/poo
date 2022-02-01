package entities;

public enum EntitiesEnum {
    CATEGORIE(CategorieEntity.class),
    COMPETENCE(CompetenceEntity.class),
    COTISATIONS(CotisationsEntity.class),
    MEMBRE(MembreEntity.class),
    PROPOSITION(PropositionEntity.class),
    TALENT(TalentEntity.class),
    TARIF(TarifEntity.class),
    TRANSACTION(TransactionEntity.class);

    private Class classType;

    EntitiesEnum(Class classType) {
        this.classType = classType;
    }

    public Class getClassType() {
        return this.classType;
    }
}
