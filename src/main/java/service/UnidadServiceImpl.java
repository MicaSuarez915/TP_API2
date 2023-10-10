package service;


import model.Edificio;
import model.Unidad;
import org.hibernate.Session;

import DAO.Daos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.List;

@Service
public class UnidadServiceImpl implements IService{

    @Autowired
    private Daos unidadDao;

    @Override
    public List<Object> findAll(Session session) throws Exception {
        return unidadDao.gelAll(session);
    }

    public void save(Session session, Unidad unidad) throws Exception{
        unidadDao.save(session);
    };

    public void update(Session session, Unidad unidad) throws Exception{

    };

    @Override
    public void deleteById(Session session, int id) throws Exception {
        Daos.delete(session, id);
    }
}
