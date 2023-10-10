package service;

import java.util.List;

import org.hibernate.Session;

public interface IService {
    public List<Object> findAll(Session session) throws Exception;


    public void deleteById(Session session, int id) throws Exception;
}
