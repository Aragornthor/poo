package services;

import entities.CategorieEntity;
import entities.EntitiesEnum;


public class CategorieServiceImpl extends GenericServiceImpl<CategorieEntity> {

    public static CategorieServiceImpl instance;

    public static CategorieServiceImpl getInstance() {
        if(instance == null) {
            instance = new CategorieServiceImpl();
        }
        return instance;
    }

    private CategorieServiceImpl() {
        super(EntitiesEnum.CATEGORIE);
    }

}
