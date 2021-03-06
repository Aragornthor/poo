package runners;

import org.hibernate.Metamodel;
import org.hibernate.query.Query;
import org.hibernate.Session;
import services.EntityManager;

import javax.persistence.metamodel.EntityType;

public class Main {
    public static void main(final String[] args) throws Exception {
        final Session session = EntityManager.getSession();
        try {
            System.out.println("Querying all the managed entities...");
            final Metamodel metamodel = session.getSessionFactory().getMetamodel();
            for (EntityType<?> entityType : metamodel.getEntities()) {
                final String entityName = entityType.getName();
                final Query query = session.createQuery("from " + entityName);
                System.out.println("executing: " + query.getQueryString());
                for (Object o : query.list()) {
                    System.out.println("  " + o);
                }
            }
        } finally {
            session.close();
        }
    }
}