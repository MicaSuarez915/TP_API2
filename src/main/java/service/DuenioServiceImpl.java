package service;

import DAO.Daos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.hibernate.Session;

import model.*;

import java.util.List;

@Service
public class DuenioServiceImpl implements IDuenioService{

    @Autowired
    private Daos duenioDao;

    @Override
    public List<Object> findAll(Session session) throws Exception {
        return duenioDao.gelAll(session);
    }



    public void save(Session session, Duenio duenio) throws Exception {
        duenioDao.save(session);
    }

    @Override
    public void update(Session session, Duenio duenio, Reclamo reclamo) throws Exception {
        duenio.agregarReclamo(reclamo);
        duenioDao.save(session);
    }

    public void update(Session session, Duenio duenio, Unidad unidad) throws Exception {
        duenio.agregarUnidad(unidad);
        duenioDao.save(session);
    }

    @Override
    public void deleteById(Session session, int id) throws Exception {
        Daos.delete(session, id);
    }

}
