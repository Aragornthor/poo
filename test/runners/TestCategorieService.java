package runners;

import entities.CategorieEntity;
import org.junit.jupiter.api.Test;
import services.CategorieServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

public class TestCategorieService {

    @Test
    public void testCreateDelete() {
        CategorieEntity categorieEntity = new CategorieEntity();
        categorieEntity.setCategorie("Modélisme");

        CategorieServiceImpl.getInstance().create(categorieEntity);

        CategorieServiceImpl.getInstance().delete(categorieEntity);
    }

    @Test
    public void testRead() {
        CategorieServiceImpl categorieService = CategorieServiceImpl.getInstance();
        CategorieEntity categorieEntity = categorieService.readFromId(13); // Normalement la catégorie n°13 est "BRICOLAGE"

        assertEquals("BRICOLAGE", categorieEntity.getCategorie());
        assertNotEquals("Cuisine", categorieEntity.getCategorie());
    }

    @Test
    public void testUpdate() {
        CategorieServiceImpl categorieService = CategorieServiceImpl.getInstance();
        CategorieEntity categorieEntity = categorieService.readFromId(13);
        categorieEntity.setCategorie("Jeux-vidéos");

        categorieService.update(categorieEntity);

        categorieEntity.setCategorie("BRICOLAGE");

        categorieService.update(categorieEntity);
    }
}
