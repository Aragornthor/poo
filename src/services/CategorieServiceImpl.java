package services;

import entities.CategorieEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.TransactionException;

import javax.transaction.Transactional;

public class CategorieServiceImpl implements CRUD<CategorieEntity> {

    public static CategorieServiceImpl instance;

    public static CategorieServiceImpl getInstance() {
        if(instance == null) {
            instance = new CategorieServiceImpl();
        }
        return instance;
    }

    private CategorieServiceImpl() {}


    @Override
    public void create(CategorieEntity entity) {
        Transaction transaction = EntityManager.getSession().beginTransaction();
        try {
            EntityManager.getSession().save(entity);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public CategorieEntity readFromId(Integer searchId) {
        return EntityManager.getSession().get(CategorieEntity.class, searchId);
    }

    @Override
    public void update(CategorieEntity entity) {
        Transaction transaction = EntityManager.getSession().beginTransaction();
        try {
            EntityManager.getSession().saveOrUpdate(entity);
            transaction.commit();
        } catch (TransactionException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(CategorieEntity entity) {
        Transaction transaction = EntityManager.getSession().beginTransaction();
        try {
            EntityManager.getSession().remove(entity);
            transaction.commit();
        } catch (TransactionException e) {
            e.printStackTrace();
        }
    }
}
