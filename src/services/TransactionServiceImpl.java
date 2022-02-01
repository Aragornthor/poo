package services;

import entities.EntitiesEnum;
import entities.TransactionEntity;

public class TransactionServiceImpl extends GenericServiceImpl<TransactionEntity> {
    public static TransactionServiceImpl instance;

    public static TransactionServiceImpl getInstance() {
        if(instance == null) {
            instance = new TransactionServiceImpl();
        }
        return instance;
    }

    private TransactionServiceImpl() {
        super(EntitiesEnum.TRANSACTION);
    }
}
