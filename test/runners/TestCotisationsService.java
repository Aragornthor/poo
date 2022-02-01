package runners;

import entities.CotisationsEntity;
import org.junit.jupiter.api.Test;
import services.CotisationsServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;

public class TestCotisationsService {

    @Test
    public void testCreateDelete() {
        CotisationsEntity cotisationsEntity = new CotisationsEntity();
        cotisationsEntity.setDateCotisation(Date.valueOf("2021-12-25"));
        cotisationsEntity.setIdMembre(1);
        cotisationsEntity.setIdTarif(6);

        CotisationsServiceImpl.getInstance().create(cotisationsEntity);

        CotisationsServiceImpl.getInstance().delete(cotisationsEntity);
    }

    @Test
    public void testRead() {
        CotisationsEntity cotisationsEntity = CotisationsServiceImpl.getInstance().readFromId(1);

        assertEquals(1, cotisationsEntity.getIdCotisation());
        assertEquals(Date.valueOf("2017-01-09"), cotisationsEntity.getDateCotisation());
        assertEquals(1, cotisationsEntity.getIdMembre());
        assertEquals(6, cotisationsEntity.getIdTarif());
    }

    @Test
    public void testUpdate() {
        CotisationsEntity cotisationsEntity = new CotisationsEntity();
        cotisationsEntity.setDateCotisation(Date.valueOf("2021-12-25"));
        cotisationsEntity.setIdMembre(1);
        cotisationsEntity.setIdTarif(6);

        Integer id = CotisationsServiceImpl.getInstance().create(cotisationsEntity);

        cotisationsEntity = CotisationsServiceImpl.getInstance().readFromId(id);
        cotisationsEntity.setDateCotisation(Date.valueOf("2022-01-31"));
        CotisationsServiceImpl.getInstance().update(cotisationsEntity);

        cotisationsEntity = CotisationsServiceImpl.getInstance().readFromId(id);

        assertNotEquals(Date.valueOf("2021-12-25"), cotisationsEntity.getDateCotisation());
        assertEquals(Date.valueOf("2022-01-31"), cotisationsEntity.getDateCotisation());

        CotisationsServiceImpl.getInstance().delete(cotisationsEntity);
    }
}
