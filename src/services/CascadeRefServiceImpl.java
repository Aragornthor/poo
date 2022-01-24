package services;

import entities.CascadeRefEntity;
import entities.CategorieEntity;
import org.hibernate.Transaction;
import org.hibernate.TransactionException;

public class CascadeRefServiceImpl implements CRUD<CascadeRefEntity> {

    public static CascadeRefServiceImpl instance;

    public static CascadeRefServiceImpl getInstance() {
        if(instance == null) {
            instance = new CascadeRefServiceImpl();
        }
        return instance;
    }

    private CascadeRefServiceImpl() {}

    @Override
    public Integer create(CascadeRefEntity entity) {
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
    public CascadeRefEntity readFromId(Integer searchId) {
        return EntityManager.getSession().get(CascadeRefEntity.class, searchId);
    }

    @Override
    public void update(CascadeRefEntity entity) {
        Transaction transaction = EntityManager.getSession().beginTransaction();
        try {
            EntityManager.getSession().saveOrUpdate(entity);
            transaction.commit();
        } catch (TransactionException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(CascadeRefEntity entity) {
        Transaction transaction = EntityManager.getSession().beginTransaction();
        try {
            EntityManager.getSession().remove(entity);
            transaction.commit();
        } catch (TransactionException e) {
            e.printStackTrace();
        }
    }
}
