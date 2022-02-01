package runners;

import entities.HabitantEntity;
import entities.MembreEntity;
import entities.ProfessionnelEntity;
import entities.VacancierEntity;
import org.junit.jupiter.api.Test;
import services.MembreServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

public class TestMembreService {

    @Test
    public void testCreateDelete() {
        HabitantEntity habitantEntity = new HabitantEntity();
        habitantEntity.setPrenomMembre("Quentin");
        habitantEntity.setNomMembre("Delmarre");
        habitantEntity.setStatut("y");
        habitantEntity.setElu(true);
        MembreServiceImpl.getInstance().create(habitantEntity);
        MembreServiceImpl.getInstance().delete(habitantEntity);

        ProfessionnelEntity professionnelEntity = new ProfessionnelEntity();
        professionnelEntity.setPrenomMembre("Quentin");
        professionnelEntity.setNomMembre("Delmarre");
        professionnelEntity.setStatut("y");
        professionnelEntity.setSiret("Test siret");
        professionnelEntity.setCodeApe("1234");
        professionnelEntity.setTribunal("Lille");
        MembreServiceImpl.getInstance().create(professionnelEntity);
        MembreServiceImpl.getInstance().delete(professionnelEntity);

        VacancierEntity vacancierEntity = new VacancierEntity();
        vacancierEntity.setPrenomMembre("Quentin");
        vacancierEntity.setNomMembre("Delmarre");
        vacancierEntity.setStatut("y");
        vacancierEntity.setModeLogement("I");
        MembreServiceImpl.getInstance().create(vacancierEntity);
        MembreServiceImpl.getInstance().delete(vacancierEntity);
    }

    @Test
    public void testRead() {
        MembreServiceImpl membreService = MembreServiceImpl.getInstance();
        MembreEntity membreEntity = membreService.readFromId(20); // Normalement la catégorie n°13 est "BRICOLAGE"

        assertEquals("Baker", membreEntity.getNomMembre());
        assertEquals("Beverly", membreEntity.getPrenomMembre());

        assertNotEquals("Pan", membreEntity.getNomMembre());
        assertNotEquals("Peter", membreEntity.getPrenomMembre());



        VacancierEntity vacancierEntity = new VacancierEntity();
        vacancierEntity.setPrenomMembre("Quentin");
        vacancierEntity.setNomMembre("Delmarre");
        vacancierEntity.setStatut("y");
        vacancierEntity.setModeLogement("I");
        Integer id = MembreServiceImpl.getInstance().create(vacancierEntity);

        membreEntity = membreService.readFromId(id);
        assertEquals("Delmarre", membreEntity.getNomMembre());
        assertEquals("Quentin", membreEntity.getPrenomMembre());

        membreService.delete(vacancierEntity);



        HabitantEntity habitantEntity = new HabitantEntity();
        habitantEntity.setPrenomMembre("Quentin");
        habitantEntity.setNomMembre("Delmarre");
        habitantEntity.setStatut("y");
        habitantEntity.setElu(true);
        id = MembreServiceImpl.getInstance().create(habitantEntity);

        membreEntity = membreService.readFromId(id);
        assertEquals("Delmarre", membreEntity.getNomMembre());
        assertEquals("Quentin", membreEntity.getPrenomMembre());

        membreService.delete(habitantEntity);
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



        VacancierEntity vacancierEntity = new VacancierEntity();
        vacancierEntity.setPrenomMembre("Quentin");
        vacancierEntity.setNomMembre("Delmarre");
        vacancierEntity.setStatut("y");
        vacancierEntity.setModeLogement("I");
        Integer id = MembreServiceImpl.getInstance().create(vacancierEntity);
        vacancierEntity = (VacancierEntity) membreService.readFromId(id);
        vacancierEntity.setModeLogement("C");
        membreService.update(vacancierEntity);

        vacancierEntity = (VacancierEntity) membreService.readFromId(id);
        assertEquals("C", vacancierEntity.getModeLogement());
        assertNotEquals("I", vacancierEntity.getModeLogement());
        membreService.delete(vacancierEntity);



        HabitantEntity habitantEntity = new HabitantEntity();
        habitantEntity.setPrenomMembre("Quentin");
        habitantEntity.setNomMembre("Delmarre");
        habitantEntity.setStatut("y");
        habitantEntity.setElu(true);
        id = MembreServiceImpl.getInstance().create(habitantEntity);

        habitantEntity = (HabitantEntity) membreService.readFromId(id);
        habitantEntity.setElu(false);
        membreService.update(habitantEntity);

        habitantEntity = (HabitantEntity) membreService.readFromId(id);
        assertEquals(false, habitantEntity.isElu());
        assertNotEquals(true, habitantEntity.isElu());
        membreService.delete(habitantEntity);

    }

    @Test
    public void testSearchByName() {
        VacancierEntity vacancierEntity = new VacancierEntity();
        vacancierEntity.setPrenomMembre("Quentin");
        vacancierEntity.setNomMembre("Delmarre");
        vacancierEntity.setStatut("y");
        vacancierEntity.setModeLogement("I");
        MembreServiceImpl.getInstance().create(vacancierEntity);

        MembreEntity res = MembreServiceImpl.getInstance().getByFirstnameAndLastname("Quentin", "Delmarre");
        assertEquals("Quentin", res.getPrenomMembre());
        assertEquals("Delmarre", res.getNomMembre());

        MembreServiceImpl.getInstance().delete(vacancierEntity);
    }
}
