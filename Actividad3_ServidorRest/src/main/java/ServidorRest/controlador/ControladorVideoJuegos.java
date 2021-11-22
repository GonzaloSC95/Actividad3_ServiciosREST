package ServidorRest.controlador;

import ServidorRest.modelo_entidad.VideoJuego;
import ServidorRest.modelo_persistencia.DaoVideoJuego;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Gonzalo
 */
@RestController
public class ControladorVideoJuegos {

    @Autowired
    private DaoVideoJuego daoVideojuego;

    /**
     * --GET-- METODO POR EL CUAL EL CLIENTE PODRÁ HACER UNA REQUEST A NUESTRO
     * SERVIDOR A TRAVES DE LA URL: "http://localhost:8080/videojuego/id", PARA
     * OBTENER UN VIDEOJUEGO A TRAVÉS DE SU ID, EN CASO DE ESTAR EN EL SERVIDOR;
     * O UN ERROR 404 NOT FOUND, SI NO EXISTE NINGUN VIDEOJUEGO CON DICHO ID
     *
     * @param id
     * @return
     */
    @GetMapping(path = "videojuego/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VideoJuego> getVideoJuego(@PathVariable("id") int id) {
        System.out.println("\nUn cliente ha hecho una consulta sobre el videojuego con id " + id);
        System.out.println("Buscando el vidieojuego con id " + id);
        VideoJuego v = daoVideojuego.getVideoJuegoByID(id);
        if (v != null) {
            return new ResponseEntity<>(v, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * --GET-- METODO POR EL CUAL EL CLIENTE PODRÁ HACER UNA REQUEST A NUESTRO
     * SERVIDOR A TRAVES DE LA URL: "http://localhost:8080/videojuegos", PARA
     * OBTENER LA LISTA DE TODOS LOS VIDEOJUEGOS DISPONIBLES EN EL SERVIDOR
     *
     * @return
     */
    @GetMapping(path = "videojuegos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getListaVideoJuegos() {
        String listaVideoJuegos = daoVideojuego.getListaVideoJuegos();
        ResponseEntity<String> lista = new ResponseEntity<>(listaVideoJuegos, HttpStatus.OK);
        return lista;
    }

    /**
     * --POST-- METODO POR EL CUAL EL CLIENTE PODRÁ HACER UNA REQUEST A NUESTRO
     * SERVIDOR A TRAVES DE LA URL: "http://localhost:8080/newvideojuego", PARA
     * DAR DE ALTA EN EL SERVIDOR, UN VIDEOJUEGO NUEVO. SI EL VIDEOJUEGO ESTA
     * REPETIDO (MISMO ID O NOMBRE), EL SERVIDOR DEVOLVERA 406 NOT ACCEPTABLE
     *
     * @param videojuego
     * @return
     */
    @PostMapping(path = "newvideojuego", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VideoJuego> putVideojuego(@RequestBody VideoJuego videojuego) {
        boolean checkNoRepetido = daoVideojuego.checkJuegoRepetido(videojuego);
        System.out.println("\nUn cliente esta intentando dar de alta este videojuego: " + videojuego);
        System.out.println("Comprobando si el videjuego ya esta en nuestro servidor.....");
        if (checkNoRepetido) {
            System.out.println("Perfecto, el juego no esta en el servidor, lo incluiremos");
            VideoJuego aux = daoVideojuego.postVideoJuego(videojuego);
            return new ResponseEntity<>(aux, HttpStatus.OK);
        } else {
            System.out.println("Vaya, ese juego ya lo tenemos, lo siento.");
        }
        return new ResponseEntity<VideoJuego>(HttpStatus.NOT_ACCEPTABLE);
    }

    /**
     * --DELETE-- METODO POR EL CUAL EL CLIENTE PODRÁ HACER UNA REQUEST A
     * NUESTRO SERVIDOR A TRAVES DE LA
     * URL:"http://localhost:8080/borrarvideojuego/id", PARA ELIMINAR DEL
     * SERVIDOR,UN VIDEOJUEGO. SI EL VIDEOJUEGO NO ESTA EN EL SERVIDOR, ESTE
     * DEVOLVERA 406 NOT ACCEPTABLE
     *
     * @param id
     * @return
     */
    @DeleteMapping(path = "borrarvideojuego/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VideoJuego> deleteVideojuego(@PathVariable("id") int id) {
        System.out.println("\nUn cliente esta intentando eliminar el videojuego con id " + id + ", de nuestro servidor");
        System.out.println("Comprobando si esto es posible........");
        boolean borrado = daoVideojuego.delVideoJuego(id);
        if (borrado) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * --PUT-- METODO POR EL CUAL EL CLIENTE PODRÁ HACER UNA REQUEST A NUESTRO
     * SERVIDOR A TRAVES DE LA
     * URL:"http://localhost:8080/modificarvideojuego/id", PARA ELIMINAR DEL
     * SERVIDOR,UN VIDEOJUEGO.SI EL VIDEOJUEGO NO ESTA EN EL SERVIDOR, ESTE
 DEVOLVERA 403 FORBIDDEN
     *
     * @param id
     * @param vid
     * @return
     */
    @PutMapping(path = "modificarvideojuego/{id}", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VideoJuego> modificarVideojuego(@PathVariable("id") int id,
            @RequestBody VideoJuego vid) {
        System.out.println("\nUn cliente esta intentando modificar el videojuego con id " + id + ", de nuestro servidor");
        System.out.println("Comprobando si esto es posible........");
        boolean modificado = daoVideojuego.putVideojuego(id, vid);
        if (modificado) {
            return new ResponseEntity<>(vid,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

}
