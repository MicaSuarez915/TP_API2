package service;

import java.util.*;

import DAO.Daos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.hibernate.Session;

import model.*;

@Service
public class EdificioServiceImpl implements IEdificioService{

    @Autowired
    private Daos edificioDao;

    @Override
    public List<Object> findAll(Session session) throws Exception {
        return edificioDao.gelAll(session);
    }



    public void save(Session session, Edificio edificio) throws Exception {
        edificioDao.save(session);
    }

    @Override
    public void update(Session session, Edificio edificio) throws Exception {
        edificio.setDireccion();

        edificioDao.save(session);
    }

    @Override
    public void deleteById(Session session, int id) throws Exception {
        Daos.delete(session, id);
    }

}
