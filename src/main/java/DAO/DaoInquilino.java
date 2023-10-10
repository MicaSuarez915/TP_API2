package DAO;

import model.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceContext;
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

    public static void delete(Session session, int id) throws Exception {
        Duenio res = session.get(Duenio.class, id);
        if (res != null) {
            session.beginTransaction();
            session.delete(res);
            session.getTransaction().commit();
        }

    }

    @PersistenceContext

    @Transactional(readOnly = true)
    public Inquilino findUser(String username, String password, Session session) {

        Query<Inquilino> theQuery = session.createQuery("FROM Inquilino WHERE nombreUsuario=:username", Inquilino.class);
        theQuery.setParameter("username", username);

        Inquilino user = theQuery.uniqueResult();

        if(user != null && checkPassword(password, user.getContrasenia())) {
            return user;
        } else {
            return null;
        }
    }

    private boolean checkPassword(String password, String passwordDB) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        //String hashedPassword = passwordEncoder.encode(password);
        System.out.println("Password: " + password);
        //System.out.println("hashedPassword: " + hashedPassword);
        System.out.println("passwordDB: " + passwordDB);
        boolean isPasswordMatch = passwordEncoder.matches(password, passwordDB);

        return isPasswordMatch;
    }
}
