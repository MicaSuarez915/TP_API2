package controller;

import java.sql.SQLException;
import java.util.List;

import DAO.DaoEdificio;
import com.mysql.cj.jdbc.CallableStatement;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.Edificio;
import service.IEdificioService;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@RestController
@RequestMapping("/TP_API2")
public class EdificioController {

    private IEdificioService edificioService;

    private CallableStatement.CallableStatementParamInfo entityManager;
    Session currentSession= entityManager.unwrap(Session.class);

    public EdificioController() throws SQLException {
    }

    @GetMapping({"/edificios",""})
    public List<Object> findAll() throws Exception {
        Session session = entityManager.unwrap(Session.class);
        return edificioService.findAll(session);
    }

    @PostMapping("/edificios")
    public ResponseEntity<Object> addCliente(@RequestBody Edificio edificio, Session session) throws Exception {

        // Este metodo guardará al cliente enviado
        IEdificioService.save(session);

        return new ResponseEntity<>(edificio, HttpStatus.CREATED);
    }

    @DeleteMapping("edificios/{edificioId}")
    public ResponseEntity<String> deleteEdificios(@PathVariable int edificioId) throws Exception {
        Edificio res = currentSession.get(Edificio.class, edificioId);
        if (res == null) {
            String mensaje = "edificio no encontrado: ";
            return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
        }else{
            DaoEdificio.delete(currentSession,edificioId);

            // Esto método, recibira el id de un edificio por URL y se borrará de la bd.
            String mensaje = "Edificio eliminado [edificioId = " + edificioId + "]";
            return new ResponseEntity<String>(mensaje, HttpStatus.NO_CONTENT);
        }


}}
