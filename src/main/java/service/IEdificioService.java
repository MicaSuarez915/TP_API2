package service;

import java.util.List;

import org.hibernate.Session;

import model.*;

public interface IEdificioService {
    public List<Object> findAll(Session session) throws Exception;

    static void save(Session session, Edificio edificio) throws Exception {

    }

    public void update(Session session, Edificio edificio) throws Exception;

    public void deleteById(Session session, int id) throws Exception;


}
