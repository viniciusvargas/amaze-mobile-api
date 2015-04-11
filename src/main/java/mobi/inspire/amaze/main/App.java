package mobi.inspire.amaze.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.hibernate.cfg.Configuration;

@ApplicationPath("/restapi")
public class App extends ResourceConfig {
    public App() {
        packages("mobi.inspire.amaze.endpoints");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("mobi-inspiring-amaze-persistence");
        EntityManager em = emf.createEntityManager();
    }
}