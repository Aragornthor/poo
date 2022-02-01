package services;

import entities.EntitiesEnum;
import org.hibernate.Transaction;
import org.hibernate.TransactionException;

public class GenericServiceImpl<T> implements CRUD<T>{

    public static GenericServiceImpl instance;
    private EntitiesEnum entityEnum;

    public static GenericServiceImpl getInstance(EntitiesEnum entityEnum) {
        getInstance();
        instance.entityEnum = entityEnum;

        return instance;
    }

    public static GenericServiceImpl getInstance() {
        if(instance == null) {
            instance = new GenericServiceImpl();
        }
        return instance;
    }

    private GenericServiceImpl() {}

    public GenericServiceImpl(EntitiesEnum entityEnum) {
        this.entityEnum = entityEnum;
        instance = GenericServiceImpl.getInstance(entityEnum);
    }

    @Override
    public Integer create(T entity) {
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
    public T readFromId(Integer searchId) {
        return (T) EntityManager.getSession().get(entityEnum.getClassType(), searchId);
    }

    @Override
    public void update(T entity) {
        Transaction transaction = EntityManager.getSession().getTransaction().isActive() ? EntityManager.getSession().getTransaction() : EntityManager.getSession().beginTransaction();

        try {
            EntityManager.getSession().saveOrUpdate(entity);
            transaction.commit();
        } catch (TransactionException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(T entity) {
        Transaction transaction = EntityManager.getSession().beginTransaction();
        try {
            EntityManager.getSession().remove(entity);
            transaction.commit();
        } catch (TransactionException e) {
            e.printStackTrace();
        }
    }
}
