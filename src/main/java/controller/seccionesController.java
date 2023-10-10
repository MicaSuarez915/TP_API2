package controller;


import DAO.DaoEdificio;
import com.mysql.cj.jdbc.CallableStatement;
import model.Edificio;
import org.hibernate.Session;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.EdificioServiceImpl;
import service.IEdificioService;
import service.UnidadServiceImpl;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/TP_API2")
public class seccionesController {
    private UnidadServiceImpl unidadService;

    private CallableStatement.CallableStatementParamInfo entityManager;
    Session currentSession= entityManager.unwrap(Session.class);

    public seccionesController() throws SQLException {
    }

    @GetMapping({"/unidades_tabla",""})
    public List<Object> findAll() throws Exception {
        Session session = entityManager.unwrap(Session.class);
        return EdificioServiceImpl.findAll(session);
    }

    @PostMapping("/unidades_tabla")
    public ResponseEntity<Object> addCliente(@RequestBody Edificio edificio, Session session) throws Exception {

        // Este metodo guardará al cliente enviado
        IEdificioService.save(session, edificio);

        return new ResponseEntity<>(edificio, HttpStatus.CREATED);
    }

    @DeleteMapping("unidades_tabla/{edificioId}")
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


    }
