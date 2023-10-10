package service;
import java.util.List;

import org.hibernate.Session;

import model.*;
public interface IReclamoService {
    public List<Object> findAll(Session session) throws Exception;

    static void save(Session session, Reclamo reclamo) throws Exception {

    }

    public void update(Session session, Reclamo reclamo, Foto foto, EstadoReclamo estado, String desc) throws Exception;

    public void deleteById(Session session, int id) throws Exception;


}
