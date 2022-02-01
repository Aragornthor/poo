package services;

import entities.CotisationsEntity;
import entities.EntitiesEnum;

public class CotisationsServiceImpl extends GenericServiceImpl<CotisationsEntity> {

    public static CotisationsServiceImpl instance;

    public static CotisationsServiceImpl getInstance() {
        if(instance == null) {
            instance = new CotisationsServiceImpl();
        }
        return instance;
    }

    private CotisationsServiceImpl() {
        super(EntitiesEnum.COTISATIONS);
    }
}
