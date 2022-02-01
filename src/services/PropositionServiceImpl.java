package services;

import entities.EntitiesEnum;
import entities.PropositionEntity;

public class PropositionServiceImpl extends GenericServiceImpl<PropositionEntity> {
    public static PropositionServiceImpl instance;

    public static PropositionServiceImpl getInstance() {
        if(instance == null) {
            instance = new PropositionServiceImpl();
        }
        return instance;
    }

    private PropositionServiceImpl() {
        super(EntitiesEnum.PROPOSITION);
    }
}
