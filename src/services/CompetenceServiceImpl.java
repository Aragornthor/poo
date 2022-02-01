package services;

import entities.CompetenceEntity;
import entities.EntitiesEnum;

public class CompetenceServiceImpl extends GenericServiceImpl<CompetenceEntity> {

    public static CompetenceServiceImpl instance;

    public static CompetenceServiceImpl getInstance() {
        if(instance == null) {
            instance = new CompetenceServiceImpl();
        }
        return instance;
    }

    private CompetenceServiceImpl() {
        super(EntitiesEnum.COMPETENCE);
    }

}
