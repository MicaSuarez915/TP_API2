package DAO;

import org.hibernate.Session;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public interface Daos
{
       List<Object> gelAll(Session session) throws Exception;
        void save(Session session) throws Exception;
        void update(Session session, Object obj) throws Exception;
        void delete(Session session) throws Exception;

}
