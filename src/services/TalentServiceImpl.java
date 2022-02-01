package services;

import entities.EntitiesEnum;
import entities.TalentEntity;

public class TalentServiceImpl extends GenericServiceImpl<TalentEntity> {
    
    public static TalentServiceImpl instance;

    public static TalentServiceImpl getInstance() {
        if(instance == null) {
            instance = new TalentServiceImpl();
        }
        return instance;
    }

    private TalentServiceImpl() {
        super(EntitiesEnum.TALENT);
    }
}
