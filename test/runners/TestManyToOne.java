package runners;

import entities.CompetenceEntity;
import org.junit.jupiter.api.Test;
import services.CompetenceServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

public class TestManyToOne {

    @Test
    public void testManyToOne() {
        CompetenceEntity competenceEntity = CompetenceServiceImpl.getInstance().readFromId(20);
        assertEquals(38, competenceEntity.getCategorieEntity().getIdCategorie());
        assertNotEquals(14, competenceEntity.getCategorieEntity().getIdCategorie());
        System.out.println(competenceEntity);

        competenceEntity = CompetenceServiceImpl.getInstance().readFromId(7);
        assertEquals(14, competenceEntity.getCategorieEntity().getIdCategorie());
        assertNotEquals(38, competenceEntity.getCategorieEntity().getIdCategorie());
        System.out.println(competenceEntity);
    }

}
