package service;

import java.util.*;

import DAO.Daos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.hibernate.Session;

import model.*;

public class ReclamoServiceImpl {
    @Autowired
    private Daos reclamoDao;

    @Override
    public List<Object> findAll(Session session) throws Exception {
        return reclamoDao.gelAll(session);
    }



    public void save(Session session, Reclamo reclamo) throws Exception {
        reclamoDao.save(session);
    }

    @Override
    public void update(Session session, Reclamo reclamo, Foto foto, EstadoReclamo estado, String desc) throws Exception {
        reclamo.setDescripcion(desc);
        reclamo.setEstado(estado);
        reclamo.setFoto(foto);

        reclamoDao.save(session);
    }

    @Override
    public void deleteById(Session session, int id) throws Exception {
        Daos.delete(session, id);
    }
}
