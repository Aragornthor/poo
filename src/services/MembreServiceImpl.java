package services;

import entities.EntitiesEnum;
import entities.MembreEntity;

import javax.persistence.Query;
import java.util.List;
import java.util.stream.Collectors;

public class MembreServiceImpl extends GenericServiceImpl<MembreEntity> {

    public static MembreServiceImpl instance;

    public static MembreServiceImpl getInstance() {
        if(instance == null) {
            instance = new MembreServiceImpl();
        }
        return instance;
    }

    private MembreServiceImpl() {
        super(EntitiesEnum.MEMBRE);
    }
    
    public MembreEntity getByFirstnameAndLastname(String firstname, String lastname) {
        if(firstname == null || lastname == null) { return null; }

        Query query = EntityManager.getSession().createQuery(
                "SELECT m FROM MembreEntity m WHERE 1>0 "
                + "AND m.nomMembre = :nom "
                + "AND m.prenomMembre = :prenom "
        );

        query.setParameter("nom", lastname);
        query.setParameter("prenom", firstname);

        return (MembreEntity) query.getSingleResult();
    }
}
