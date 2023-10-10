package DAO;

import model.AreaComun;
import model.Duenio;
import model.Usuario;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class DaoDuenio implements Daos{
    @Override
    public List<Object> gelAll(Session session) throws Exception {
        Query<Duenio> getQuery = session.createQuery("FROM Duenio", Duenio.class);
//		getQuery.setFirstResult(1);
//		getQuery.setMaxResults(2);
        List<Duenio> usuarios = getQuery.list();
        for (Usuario e : usuarios) {
            System.out.println(e);
        }
        return Collections.singletonList(usuarios);
    }

    @Override
    public void save(Session session) throws Exception {
        Duenio duenio = new Duenio("Mario","Lopez",22837463, "mlopez", "mlopez");
        Duenio duenio2 = new Duenio("Victoria","Castarelli",17938746, "vcast", "viviki");
        Duenio duenio3 = new Duenio("Tamara","Villaruel",26738472, "tamiVillaruel", "pirinchito");


        Transaction tx = session.beginTransaction();
        session.save(duenio);
        session.save(duenio2);
        session.save(duenio3);

        tx.commit();

    }

    @Override
    public void update(Session session, Object obj) throws Exception {
        Duenio due= (Duenio) obj;
        session.update(due);

    }


    public static void delete(Session session, int id) throws Exception {
        Duenio res = session.get(Duenio.class, id);
        if (res != null) {
            session.beginTransaction();
            session.delete(res);
            session.getTransaction().commit();
        }

    }
}
