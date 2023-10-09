package DAO;

import model.AreaComun;
import model.Duenio;
import model.Reclamo;
import model.Unidad;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class  DaoReclamo implements Daos{
    @Override
    public List<Object> gelAll(Session session) throws Exception {
        Query<Reclamo> getQuery = session.createQuery("FROM Reclamo", Reclamo.class);
        List<Reclamo> reclamos = getQuery.list();
        for (Reclamo r : reclamos){
            System.out.println(r);
        }
        return Collections.singletonList(reclamos);
    }

    @Override
    public void save(Session session) throws Exception {
        Duenio duenio = new Duenio("Mariano","Lopez",23456876, "marianlopez", "marianlopez");
        AreaComun areaComun= new AreaComun("Jacuzzi", "Area cubierta");
        Reclamo reclamo1 = new Reclamo("Reclamo 1",null);

        areaComun.agregarReclamo(reclamo1);
        reclamo1.setAreaComun(areaComun);
        duenio.agregarReclamo(reclamo1);
        reclamo1.setDuenio(duenio);
        Transaction tx = session.beginTransaction();
        session.save(areaComun);
        session.save(duenio);
        session.save(reclamo1);
        session.getTransaction().commit();
    }

    @Override
    public void update(Session session, Object obj) throws Exception {
        Reclamo reclamo= (Reclamo) obj;
        session.update(reclamo);
    }

    @Override
    public void delete(Session session) throws Exception {
        Reclamo res = session.get(Reclamo.class, 3);
        if (res != null) {
            session.beginTransaction();
            session.delete(res);
            session.getTransaction().commit();
        }

    }
}
