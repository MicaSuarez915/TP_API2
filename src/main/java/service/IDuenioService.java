package service;

import java.util.List;

import org.hibernate.Session;

import model.*;

public interface IDuenioService {

     public List<Object> findAll(Session session) throws Exception;

     static void save(Session session, Duenio duenio) throws Exception {}

     public void update(Session session, Duenio duenio, Reclamo reclamo) throws Exception;

     public void update(Session session, Duenio duenio, Unidad unidad) throws Exception;

     public void deleteById(Session session, int id) throws Exception;


}
