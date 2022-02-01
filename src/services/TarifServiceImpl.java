package services;

import entities.EntitiesEnum;
import entities.TarifEntity;

public class TarifServiceImpl extends GenericServiceImpl<TarifEntity> {
    public static TarifServiceImpl instance;

    public static TarifServiceImpl getInstance() {
        if(instance == null) {
            instance = new TarifServiceImpl();
        }
        return instance;
    }

    private TarifServiceImpl() {
        super(EntitiesEnum.TARIF);
    }
}
