package runners;

import entities.TarifEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestReporter;
import services.TarifServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

public class TestTarifService {

    @Test
    public void testCreateDelete() {
        TarifEntity tarifEntity = new TarifEntity();
        tarifEntity.setAnnee(2060);
        tarifEntity.setMontant(1000);

        TarifServiceImpl.getInstance().create(tarifEntity);

        TarifServiceImpl.getInstance().delete(tarifEntity);
    }

    @Test
    public void testRead() {
        TarifEntity tarifEntity = TarifServiceImpl.getInstance().readFromId(1);

        assertEquals(1, tarifEntity.getIdTarif());
        assertEquals(2020, tarifEntity.getAnnee());
        assertEquals(18, tarifEntity.getMontant());
    }

    @Test
    public void testUpdate() {
        TarifEntity tarifEntity = new TarifEntity();
        tarifEntity.setAnnee(2060);
        tarifEntity.setMontant(1000);

        Integer id = TarifServiceImpl.getInstance().create(tarifEntity);

        tarifEntity = TarifServiceImpl.getInstance().readFromId(id);
        tarifEntity.setMontant(29999999);
        TarifServiceImpl.getInstance().update(tarifEntity);

        tarifEntity = TarifServiceImpl.instance.readFromId(id);

        assertEquals(29999999, tarifEntity.getMontant());
        assertNotEquals(1000, tarifEntity.getMontant());

        TarifServiceImpl.getInstance().delete(tarifEntity);
    }

}
