package runners;

import entities.MembreEntity;
import entities.TransactionEntity;
import org.junit.jupiter.api.Test;
import services.MembreServiceImpl;
import services.TransactionServiceImpl;

import java.sql.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestTransactionService {

    @Test
    public void testCreateDelete() {
        TransactionEntity transaction = new TransactionEntity();
        transaction.setMontantTransaction(20);
        transaction.setDateCreation(Date.valueOf("2022-02-01"));
        transaction.setDateValidation(Date.valueOf("2022-03-01"));
        transaction.setEtat("V");
        transaction.setIdMembreBeneficiaire(1);
        transaction.setMontantEcu(2);
        transaction.setIdProposition(422);

        TransactionServiceImpl.getInstance().create(transaction);

        TransactionServiceImpl.getInstance().delete(transaction);
    }

    @Test
    public void testRead() {
        TransactionEntity transaction = TransactionServiceImpl.getInstance().readFromId(1);

        assertEquals(1, transaction.getIdTransaction());
        assertEquals(Date.valueOf("2021-12-01"), transaction.getDateCreation());
        assertEquals(Date.valueOf("2021-12-07"), transaction.getDateValidation());
        assertEquals("C", transaction.getEtat());
        assertEquals(422, transaction.getIdProposition());
        assertEquals(2, transaction.getMontantTransaction());
        assertEquals(2998, transaction.getIdMembreBeneficiaire());
        assertEquals(0, transaction.getMontantEcu());

    }

    @Test
    public void testUpdate() {
        TransactionEntity transaction = new TransactionEntity();
        transaction.setMontantTransaction(20);
        transaction.setDateCreation(Date.valueOf("2022-02-01"));
        transaction.setDateValidation(Date.valueOf("2022-03-01"));
        transaction.setEtat("V");
        transaction.setIdMembreBeneficiaire(1);
        transaction.setMontantEcu(2);
        transaction.setIdProposition(422);

        Integer id = TransactionServiceImpl.getInstance().create(transaction);

        transaction = TransactionServiceImpl.getInstance().readFromId(id);
        transaction.setMontantEcu(1000);
        TransactionServiceImpl.getInstance().update(transaction);

        transaction = TransactionServiceImpl.getInstance().readFromId(id);

        assertEquals(1000, transaction.getMontantEcu());
        assertNotEquals(2, transaction.getMontantEcu());

        TransactionServiceImpl.getInstance().delete(transaction);
    }

    @Test
    public void testGetByBeneficiare() {
        List<TransactionEntity> transactionEntities = TransactionServiceImpl.getInstance().getTransactionByBeneficiaire("Phyllis", "Gonzales");
        MembreEntity membreEntity = MembreServiceImpl.getInstance().getByFirstnameAndLastname("Phyllis", "Gonzales");

        for(TransactionEntity transactionEntity : transactionEntities) {
            assertEquals(transactionEntity.getIdMembreBeneficiaire(), membreEntity.getIdMembre());
        }
    }
}
