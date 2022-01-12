package runners;

import entities.TalentEntity;
import org.junit.jupiter.api.Test;
import services.TalentServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

public class TestTalentService {

    @Test
    public void testCreateDelete() {
        TalentEntity talentEntity = new TalentEntity();
        talentEntity.setDetailCompetence("Lire dans les pensées");
        talentEntity.setIdCompetence(20);
        talentEntity.setIdMembre(2);

        TalentServiceImpl.getInstance().create(talentEntity);

        TalentServiceImpl.getInstance().delete(talentEntity);
    }

    @Test
    public void testRead() {
        TalentServiceImpl talentService = TalentServiceImpl.getInstance();
        TalentEntity talentEntity = talentService.readFromId(20); // Normalement la catégorie n°13 est "BRICOLAGE"

        assertEquals("Être une feuille", talentEntity.getDetailCompetence());
        assertNotEquals("Cuisine", talentEntity.getDetailCompetence());
    }

    @Test
    public void testUpdate() {
        TalentServiceImpl talentService = TalentServiceImpl.getInstance();
        TalentEntity talentEntity = talentService.readFromId(20);
        talentEntity.setDetailCompetence("Jeux-vidéos");

        talentService.update(talentEntity);

        talentEntity.setDetailCompetence("Être une feuille");

        talentService.update(talentEntity);
    }
}
