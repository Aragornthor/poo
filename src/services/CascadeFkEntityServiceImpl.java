package services;

import entities.CascadeFkEntity;
import org.hibernate.Transaction;
import org.hibernate.TransactionException;

public class CascadeFkEntityServiceImpl implements CRUD<CascadeFkEntity> {

    public static CascadeFkEntityServiceImpl instance;

    public static CascadeFkEntityServiceImpl getInstance() {
        if(instance == null) {
            instance = new CascadeFkEntityServiceImpl();
        }
        return instance;
    }

    private CascadeFkEntityServiceImpl() {}

    @Override
    public Integer create(CascadeFkEntity entity) {
        Transaction transaction = EntityManager.getSession().beginTransaction();
        Integer id = null;
        try {
            id = (Integer) EntityManager.getSession().save(entity);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return id;
    }

    @Override
    public CascadeFkEntity readFromId(Integer searchId) {
        return EntityManager.getSession().get(CascadeFkEntity.class, searchId);
    }

    @Override
    public void update(CascadeFkEntity entity) {
        Transaction transaction = EntityManager.getSession().beginTransaction();
        try {
            EntityManager.getSession().saveOrUpdate(entity);
            transaction.commit();
        } catch (TransactionException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(CascadeFkEntity entity) {
        Transaction transaction = EntityManager.getSession().beginTransaction();
        try {
            EntityManager.getSession().remove(entity);
            transaction.commit();
        } catch (TransactionException e) {
            e.printStackTrace();
        }
    }
}
