package runners;

import entities.MembreEntity;
import org.junit.jupiter.api.Test;
import services.MembreServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

public class TestMembreService {

    @Test
    public void testCreateDelete() {
        MembreEntity membreEntity = new MembreEntity();
        membreEntity.setPrenomMembre("Quentin");
        membreEntity.setNomMembre("Delmarre");
        membreEntity.setStatut("y");

        MembreServiceImpl.getInstance().create(membreEntity);

        MembreServiceImpl.getInstance().delete(membreEntity);
    }

    @Test
    public void testRead() {
        MembreServiceImpl membreService = MembreServiceImpl.getInstance();
        MembreEntity membreEntity = membreService.readFromId(20); // Normalement la catégorie n°13 est "BRICOLAGE"

        assertEquals("Baker", membreEntity.getNomMembre());
        assertEquals("Beverly", membreEntity.getPrenomMembre());

        assertNotEquals("Pan", membreEntity.getNomMembre());
        assertNotEquals("Peter", membreEntity.getPrenomMembre());
    }

    @Test
    public void testUpdate() {
        MembreServiceImpl membreService = MembreServiceImpl.getInstance();
        MembreEntity membreEntity = membreService.readFromId(20);

        membreEntity.setNomMembre("Pan");
        membreEntity.setPrenomMembre("Peter");

        membreService.update(membreEntity);

        membreEntity.setNomMembre("Baker");
        membreEntity.setPrenomMembre("Beverly");

        membreService.update(membreEntity);
    }
}
