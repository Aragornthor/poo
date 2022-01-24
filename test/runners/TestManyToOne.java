package runners;

import entities.CategorieEntity;
import entities.CompetenceEntity;
import org.junit.jupiter.api.Test;
import services.CategorieServiceImpl;
import services.CompetenceServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

public class TestManyToOne {

    @Test
    public void testRecuperationManyToOne() {
        CompetenceEntity competenceEntity = CompetenceServiceImpl.getInstance().readFromId(20);
        assertEquals(38, competenceEntity.getCategorieEntity().getIdCategorie());
        assertNotEquals(14, competenceEntity.getCategorieEntity().getIdCategorie());
        System.out.println(competenceEntity);

        competenceEntity = CompetenceServiceImpl.getInstance().readFromId(7);
        assertEquals(14, competenceEntity.getCategorieEntity().getIdCategorie());
        assertNotEquals(38, competenceEntity.getCategorieEntity().getIdCategorie());
        System.out.println(competenceEntity);
    }

    @Test
    public void testEnvoiManyToOne() {
        CategorieEntity categorieEntity = new CategorieEntity();
        categorieEntity.setCategorie("Jeux de société");
        Integer id = CategorieServiceImpl.getInstance().create(categorieEntity);

        categorieEntity = null;
        categorieEntity = CategorieServiceImpl.getInstance().readFromId(id);
        assertNotEquals(null, categorieEntity);
        assertEquals(id, categorieEntity.getIdCategorie());
        assertEquals("Jeux de société", categorieEntity.getCategorie());

        CompetenceEntity competenceEntity = new CompetenceEntity();
        competenceEntity.setCompetence("Uno");
        competenceEntity.setCategorieEntity(categorieEntity);
        Integer id2 = CompetenceServiceImpl.getInstance().create(competenceEntity);

        competenceEntity = null;
        competenceEntity = CompetenceServiceImpl.getInstance().readFromId(id2);
        assertNotEquals(null, competenceEntity);
        assertEquals(id2, competenceEntity.getIdCompetence());
        assertEquals(id, competenceEntity.getCategorieEntity().getIdCategorie());

        CompetenceServiceImpl.getInstance().delete(competenceEntity);
        CategorieServiceImpl.getInstance().delete(categorieEntity);
    }

}
