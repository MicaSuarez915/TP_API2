package controller;
import model.*;
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

    @Autowired
    private IEdificioService edificioService;

    //@RequestMapping(value = "/edificios_tabla", method = RequestMethod.GET)

    public EdificioController() throws SQLException {
    }

    @GetMapping({"/edificios_tabla",""})
    public List<Object> findAll() throws Exception {
        return edificioService.findAll();

    }
   /*@param clienteId id del cliente a buscar;
     *@return;
     *agregar mapping x id y x parametroid
    */


    /**
     * @param edificio
     * @return
     */


    @PostMapping("/edificios_tabla")
    public ResponseEntity<Object> addEdificio(@RequestBody Edificio edificio) {
        edificioService.save(edificio);
        return new ResponseEntity<>(edificio, HttpStatus.CREATED);


    }

    @PutMapping("/edificios_tabla/{edificioId}")
    public ResponseEntity<?> updateCliente(@PathVariable int edificioId, @RequestBody Edificio edificio) {

        Edificio edifOld = edificioService.findById(clienteId);

        if (clienteOld == null) {
            String mensaje = "Cliente no encontrado con ID: " + clienteId;
            return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
        }

        // este metodo actualizará al cliente enviado
        clienteService.update(clienteId, cliente);

        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    @DeleteMapping("edificios_tabla/{edificioId}")
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
