package services;

import entities.EntitiesEnum;
import entities.MembreEntity;

public class MembreServiceImpl extends GenericServiceImpl<MembreEntity> {

    public static MembreServiceImpl instance;

    public static MembreServiceImpl getInstance() {
        if(instance == null) {
            instance = new MembreServiceImpl();
        }
        return instance;
    }

    private MembreServiceImpl() {
        super(EntitiesEnum.MEMBRE);
    }
}
