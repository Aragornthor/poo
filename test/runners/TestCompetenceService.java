package runners;

import entities.CompetenceEntity;
import org.junit.jupiter.api.Test;
import services.CategorieServiceImpl;
import services.CompetenceServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

public class TestCompetenceService {

    @Test
    public void testCreateDelete() {
        CompetenceEntity competenceEntity = new CompetenceEntity();
        competenceEntity.setCategorieEntity(CategorieServiceImpl.getInstance().readFromId(13));
        competenceEntity.setCompetence("Modélisme");

        CompetenceServiceImpl.getInstance().create(competenceEntity);

        CompetenceServiceImpl.getInstance().delete(competenceEntity);
    }

    @Test
    public void testRead() {
        CompetenceServiceImpl competenceService = CompetenceServiceImpl.getInstance();
        CompetenceEntity competenceEntity = competenceService.readFromId(20); // Normalement la compétence n° 20 = "telekinesie"

        assertEquals("telekinesie", competenceEntity.getCompetence());
        assertNotEquals("Cuisine", competenceEntity.getCompetence());
    }

    @Test
    public void testUpdate() {
        CompetenceServiceImpl competenceService = CompetenceServiceImpl.getInstance();
        CompetenceEntity competenceEntity = competenceService.readFromId(20);
        competenceEntity.setCompetence("Jeux-vidéos");

        competenceService.update(competenceEntity);

        competenceEntity.setCompetence("telekinesie");

        competenceService.update(competenceEntity);
    }
}
