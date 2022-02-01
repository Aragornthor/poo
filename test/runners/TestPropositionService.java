package runners;

import entities.PropositionEntity;
import org.junit.jupiter.api.Test;
import services.PropositionServiceImpl;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

public class TestPropositionService {

    @Test
    public void testCreateDelete() {
        PropositionEntity propositionEntity = new PropositionEntity();
        propositionEntity.setDateDebut(Date.valueOf("2020-01-01"));
        propositionEntity.setDateFin(Date.valueOf("2020-01-21"));
        propositionEntity.setDescription("Je suis dispo");
        propositionEntity.setIdTalent(1);

        PropositionServiceImpl.getInstance().create(propositionEntity);

        PropositionServiceImpl.getInstance().delete(propositionEntity);
    }

    @Test
    public void testRead() {
        PropositionEntity propositionEntity = PropositionServiceImpl.getInstance().readFromId(1);

        assertEquals(1, propositionEntity.getIdProposition());
        assertEquals(1, propositionEntity.getIdTalent());
        assertEquals("INIT BDD", propositionEntity.getDescription());
        assertEquals(Date.valueOf("2021-12-04"), propositionEntity.getDateDebut());
        assertEquals(Date.valueOf("2021-12-10"), propositionEntity.getDateFin());
    }

    @Test
    public void testUpdate() {
        PropositionEntity propositionEntity = new PropositionEntity();
        propositionEntity.setDateDebut(Date.valueOf("2020-01-01"));
        propositionEntity.setDateFin(Date.valueOf("2020-01-21"));
        propositionEntity.setDescription("Je suis dispo");
        propositionEntity.setIdTalent(1);

        Integer id = PropositionServiceImpl.getInstance().create(propositionEntity);

        propositionEntity = PropositionServiceImpl.getInstance().readFromId(id);
        propositionEntity.setDescription("Toto trop rigolo");
        PropositionServiceImpl.getInstance().update(propositionEntity);

        propositionEntity = PropositionServiceImpl.getInstance().readFromId(id);

        assertEquals("Toto trop rigolo", propositionEntity.getDescription());
        assertNotEquals("Je suis dispo", propositionEntity.getDescription());

        PropositionServiceImpl.getInstance().delete(propositionEntity);
    }

}
