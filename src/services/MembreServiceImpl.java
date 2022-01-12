package services;

import entities.MembreEntity;
import org.hibernate.Transaction;
import org.hibernate.TransactionException;

public class MembreServiceImpl implements CRUD<MembreEntity> {

    public static MembreServiceImpl instance;

    public static MembreServiceImpl getInstance() {
        if(instance == null) {
            instance = new MembreServiceImpl();
        }
        return instance;
    }

    private MembreServiceImpl() {}

    @Override
    public void create(MembreEntity entity) {
        Transaction transaction = EntityManager.getSession().beginTransaction();
        try {
            EntityManager.getSession().save(entity);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public MembreEntity readFromId(Integer searchId) {
        return EntityManager.getSession().get(MembreEntity.class, searchId);
    }

    @Override
    public void update(MembreEntity entity) {
        Transaction transaction = EntityManager.getSession().beginTransaction();
        try {
            EntityManager.getSession().saveOrUpdate(entity);
            transaction.commit();
        } catch (TransactionException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(MembreEntity entity) {
        Transaction transaction = EntityManager.getSession().beginTransaction();
        try {
            EntityManager.getSession().remove(entity);
            transaction.commit();
        } catch (TransactionException e) {
            e.printStackTrace();
        }
    }

}
