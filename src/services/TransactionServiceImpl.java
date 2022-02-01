package services;

import antlr.StringUtils;
import entities.EntitiesEnum;
import entities.MembreEntity;
import entities.TransactionEntity;
import org.hibernate.query.Query;

import java.util.List;

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

    public List<TransactionEntity> getTransactionByBeneficiaire(String firstname, String lastname) {
        if(firstname == null || lastname == null) { return null; }

        Query query = EntityManager.getSession().createQuery("SELECT t FROM TransactionEntity t WHERE t.idMembreBeneficiaire = :idMembre");
        MembreEntity membreEntity = MembreServiceImpl.getInstance().getByFirstnameAndLastname(firstname, lastname);
        query.setParameter("idMembre", membreEntity.getIdMembre());

        return (List<TransactionEntity>) query.getResultList();
    }
}
