package DAO;

import model.AreaComun;
import model.Unidad;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class DaoUnidad implements Daos{
    @Override
    public List<Object> gelAll(Session session) throws Exception {

        Query<Unidad> getQuery = session.createQuery("FROM Unidad", Unidad.class);
        List<Unidad> unidades = getQuery.list();
        for (Unidad u : unidades){
            System.out.println(u);
        }
        return Collections.singletonList(unidades);
    }

    @Override
    public void save(Session session) throws Exception {
        Unidad unidad1= new Unidad(5, 3, true, false);
        Unidad unidad2= new Unidad(9, 1, true, true);
        Unidad unidad3= new Unidad(5, 2, true, true);

        Transaction tx = session.beginTransaction();
        session.save(unidad1);
        session.save(unidad2);
        session.save(unidad3);

        tx.commit();
    }

    @Override
    public void update(Session session, Object obj) throws Exception {
        Unidad unidad= (Unidad) obj;
        session.update(unidad);
    }

    @Override
    public void delete(Session session) throws Exception {
        Unidad res = session.get(Unidad.class, 3);
        if (res != null) {
            session.beginTransaction();
            session.delete(res);
            session.getTransaction().commit();
        }

    }
}
