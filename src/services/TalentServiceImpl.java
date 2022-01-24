package services;

import entities.TalentEntity;
import org.hibernate.Transaction;
import org.hibernate.TransactionException;

public class TalentServiceImpl implements CRUD<TalentEntity> {
    
    public static TalentServiceImpl instance;

    public static TalentServiceImpl getInstance() {
        if(instance == null) {
            instance = new TalentServiceImpl();
        }
        return instance;
    }

    private TalentServiceImpl() {}

    @Override
    public Integer create(TalentEntity entity) {
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
    public TalentEntity readFromId(Integer searchId) {
        return EntityManager.getSession().get(TalentEntity.class, searchId);
    }

    @Override
    public void update(TalentEntity entity) {
        Transaction transaction = EntityManager.getSession().beginTransaction();
        try {
            EntityManager.getSession().saveOrUpdate(entity);
            transaction.commit();
        } catch (TransactionException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(TalentEntity entity) {
        Transaction transaction = EntityManager.getSession().beginTransaction();
        try {
            EntityManager.getSession().remove(entity);
            transaction.commit();
        } catch (TransactionException e) {
            e.printStackTrace();
        }
    }
}
