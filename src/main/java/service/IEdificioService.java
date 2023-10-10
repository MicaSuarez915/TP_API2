package service;

import java.util.List;

import org.hibernate.Session;

import model.Edificio;

public interface IEdificioService {
    public List<Object> findAll(Session session) throws Exception;

    public static void save(Session session) throws Exception {

    }

    void save(Session session, Edificio edificio) throws Exception;

    public void update(Session session, Edificio edificio) throws Exception;

    public void deleteById(Session session) throws Exception;


}
