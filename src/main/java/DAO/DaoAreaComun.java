package DAO;

import model.AreaComun;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class DaoAreaComun implements Daos {
    @Override
    public List<Object> gelAll(Session session) throws Exception {
        Query<AreaComun> getQuery = session.createQuery("FROM AreaComun", AreaComun.class);
        List<AreaComun> areasComunes = getQuery.list();
        for (AreaComun a : areasComunes){
            System.out.println(a);
        }
        return Collections.singletonList(areasComunes);
    }

    @Override
    public void save(Session session) throws Exception {
        AreaComun areaComun1= new AreaComun("Pasillo Principal", "Vestidor rojo");
        AreaComun areaComun2= new AreaComun("Ascensores", "Ascensor 1");
        AreaComun areaComun3= new AreaComun("Zoom", "Area cubierta");
        AreaComun areaComun4= new AreaComun("Piscina", "Area descubierta");
        Transaction tx = session.beginTransaction();
        session.save(areaComun1);
        session.save(areaComun2);
        session.save(areaComun3);
        session.save(areaComun4);
        tx.commit();
    }

    @Override
    public void update(Session session) throws Exception {

    }

    @Override
    public void delete(Session session) throws Exception {

    }
}
