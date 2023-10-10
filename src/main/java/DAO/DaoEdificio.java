package DAO;

import model.Edificio;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Collections;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class DaoEdificio implements Daos{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public List<Object> gelAll(Session session) throws Exception {

        Query<Edificio> getQuery = session.createQuery("FROM Edificio", Edificio.class);
        List<Edificio> edificios = getQuery.list();
        for (Edificio e : edificios) {
            System.out.println(e);
        }
        return Collections.singletonList(edificios);
    }

    @Override
    public void save(Session session) throws Exception {
        Edificio edificio1= new Edificio("Rivadavia 1657");
        Edificio edificio2= new Edificio("Lima 506");
        //this.edificios.add(edificio1);
        //this.edificios.add(edificio2);
        Transaction tx = session.beginTransaction();
        session.save(edificio1);
        session.save(edificio2);

        tx.commit();

    }

    @Override
    public void update(Session session, Object obj) throws Exception {
        Edificio edificio= (Edificio) obj;
        session.update(edificio);

    }


    public void delete(Session session) throws Exception {
        Edificio res = session.get(Edificio.class, 3);
        if (res != null) {
            session.beginTransaction();
            session.delete(res);
            session.getTransaction().commit();
        }

    }


}
