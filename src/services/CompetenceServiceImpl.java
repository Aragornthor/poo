package services;

import entities.CompetenceEntity;
import org.hibernate.Transaction;
import org.hibernate.TransactionException;

public class CompetenceServiceImpl implements CRUD<CompetenceEntity> {

    public static CompetenceServiceImpl instance;

    public static CompetenceServiceImpl getInstance() {
        if(instance == null) {
            instance = new CompetenceServiceImpl();
        }
        return instance;
    }

    private CompetenceServiceImpl() {}

    @Override
    public void create(CompetenceEntity entity) {
        Transaction transaction = EntityManager.getSession().beginTransaction();
        try {
            EntityManager.getSession().save(entity);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public CompetenceEntity readFromId(Integer searchId) {
        return EntityManager.getSession().get(CompetenceEntity.class, searchId);
    }

    @Override
    public void update(CompetenceEntity entity) {
        Transaction transaction = EntityManager.getSession().beginTransaction();
        try {
            EntityManager.getSession().saveOrUpdate(entity);
            transaction.commit();
        } catch (TransactionException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(CompetenceEntity entity) {
        Transaction transaction = EntityManager.getSession().beginTransaction();
        try {
            EntityManager.getSession().remove(entity);
            transaction.commit();
        } catch (TransactionException e) {
            e.printStackTrace();
        }
    }
}
