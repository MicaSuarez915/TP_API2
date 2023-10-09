package DAO;

import model.AreaComun;
import model.Edificio;
import model.Inquilino;
import model.Usuario;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class DaoInquilino implements Daos{
    @Override
    public List<Object> gelAll(Session session) throws Exception {
        Query<Inquilino> getQuery = session.createQuery("FROM Inquilino", Inquilino.class);
        List<Inquilino> usuarios = getQuery.list();
        for (Usuario e : usuarios) {
            System.out.println(e);
        }
        return Collections.singletonList(usuarios);
    }

    @Override
    public void save(Session session) throws Exception {
        Inquilino inquilino = new Inquilino("Rita","Marciel",23948573,"rmar","jdei");
        Inquilino inquilino2 = new Inquilino("Candelaria","Kerlans",44738294,"cande","jfioep");
        Inquilino inquilino3 = new Inquilino("Marcos","Reinals",40394827,"mmr","ksid");


        Transaction tx = session.beginTransaction();
        session.save(inquilino);
        session.save(inquilino2);
        session.save(inquilino3);

        tx.commit();

    }

    @Override
    public void update(Session session, Object obj) throws Exception {
        Inquilino inq= (Inquilino) obj;
        session.update(inq);
    }

    @Override
    public void delete(Session session) throws Exception {
        Edificio res = session.get(Edificio.class, 3);
        if (res != null) {
            session.beginTransaction();
            session.delete(res);
            session.getTransaction().commit();
        }
    }
}
