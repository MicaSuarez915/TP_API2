package DAO;

import model.Duenio;
import model.Foto;
import org.hibernate.Session;

import java.util.List;

public class DaoFotos implements Daos {
    @Override
    public List<Object> gelAll(Session session) throws Exception {
        return null;
    }

    @Override
    public void save(Session session) throws Exception {

    }

    @Override
    public void update(Session session, Object obj) throws Exception {

    }

    public static void delete(Session session, int id) throws Exception {
        Foto res = session.get(Foto.class, id);
        if (res != null) {
            session.beginTransaction();
            session.delete(res);
            session.getTransaction().commit();
        }

    }
}
