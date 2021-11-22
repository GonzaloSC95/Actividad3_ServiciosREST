package ServidorRestCliente.modelo_servicio;

import ServidorRestCliente.modelo_entidad.VideoJuego;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Gonzalo
 */
//Con esta anotacion damos de alta un objeto de tipo
//ServicioProxyVideoJuego dentro del contexto de Spring
@Service
public class ServicioProxyVideoJuego {

    /**
     * La URL base del servicio REST de VideoJuegos
     */
    public static final String URL = "http://localhost:8080/";

    //Inyectamos el objeto de tipo RestTemplate que nos ayudara
    //a hacer las peticiones HTTP al servicio REST
    @Autowired
    private RestTemplate restTemplate;

    /**
     * --GET-- METODO POR EL CUAL EL CLIENTE PODRÁ HACER UNA REQUEST A NUESTRO
     * SERVIDOR A TRAVES DE LA URL: "http://localhost:8080/videojuego/id", PARA
     * OBTENER UN VIDEOJUEGO A TRAVÉS DE SU ID, EN CASO DE ESTAR EN EL SERVIDOR;
     * O UN ERROR 404 NOT FOUND, SI NO EXISTE NINGUN VIDEOJUEGO CON DICHO ID
     *
     * @param id
     * @return
     */
    public VideoJuego obtenerVideoJuegoID(int id) {
        try {
            //Ej http://localhost:8080/videojuego/id GET
            ResponseEntity<VideoJuego> re = restTemplate.getForEntity(URL + "videojuego/" + id, VideoJuego.class);
            HttpStatus hs = re.getStatusCode();
            if (hs == HttpStatus.OK) {
                //Si el videojuego existe, viene en formato JSON en el body
                //Al ser el objeto ResponseEntity de tipo videojuego, al obtener el 
                //body me lo convierte automaticamente a tipo videojuego
                return re.getBody();
            } else {
                //JOptionPane.showMessageDialog(null, "Respuesta no contemplada", null, JOptionPane.ERROR_MESSAGE);
                System.out.println("Respuesta no contemplada");
                return null;
            }

        } catch (HttpClientErrorException e) {
//            JOptionPane.showMessageDialog(null,
//                    "El videojuego no se ha encontrado, id: " + id
//                    + "\nCodigo de respuesta: " + e.getStatusCode(),
//                    null, JOptionPane.ERROR_MESSAGE);
            System.out.println("obtener -> El videojuego NO se ha encontrado, id: " + id);
            System.out.println("obtener -> Codigo de respuesta: " + e.getStatusCode());
            return null;
        }

    }

    /**
     * --POST-- METODO POR EL CUAL EL CLIENTE PODRÁ HACER UNA REQUEST A NUESTRO
     * SERVIDOR A TRAVES DE LA URL: "http://localhost:8080/newvideojuego", PARA
     * DAR DE ALTA EN EL SERVIDOR, UN VIDEOJUEGO NUEVO.SI EL VIDEOJUEGO ESTA
 REPETIDO (MISMO ID O NOMBRE), EL SERVIDOR DEVOLVERA 406 NOT ACCEPTABLE
     *
     * @param videojuego
     * @return
     */
    public VideoJuego darAltaVideoJuego(VideoJuego videojuego) {
        //http://localhost:8080/newvideojuego POST
        try {
            ResponseEntity<VideoJuego> re = restTemplate.postForEntity(URL + "newvideojuego", videojuego, VideoJuego.class);
            //JOptionPane.showMessageDialog(null, "Codigo de respuesta " + re.getStatusCode(), null, JOptionPane.OK_OPTION);
            System.out.println("alta -> Codigo de respuesta " + re.getStatusCode());
            return re.getBody();

        } catch (HttpClientErrorException e) {
            /////////////////////////////////////////////////////////////////////////
            System.out.println("alta -> El videojuego NO se ha dado de alta, id: " + videojuego);
            System.out.println("alta -> Codigo de respuesta: " + e.getStatusCode());
            return null;
        }
        
    }

    /**
     * --PUT-- METODO POR EL CUAL EL CLIENTE PODRÁ HACER UNA REQUEST A NUESTRO
     * SERVIDOR A TRAVES DE LA
     * URL:"http://localhost:8080/modificarvideojuego/id", PARA ELIMINAR DEL
     * SERVIDOR,UN VIDEOJUEGO. SI EL VIDEOJUEGO NO ESTA EN EL SERVIDOR, ESTE
     * DEVOLVERA 403 FORBIDDEN
     *
     * @param videojuego
     * @return
     */
    public boolean modificarVideojuegoID(VideoJuego videojuego) {
        //http://localhost:8080/modificarvideojuego/id PUT
        try {

            restTemplate.put(URL + "modificarvideojuego/" + videojuego.getId(), videojuego, VideoJuego.class);
            return true;
        } catch (HttpClientErrorException e) {
//            JOptionPane.showMessageDialog(null,
//                    "El videoJuego NO se ha modificado, id: " + videojuego.getId()
//                    + "\nCodigo de respuesta: " + e.getStatusCode(),
//                    null, JOptionPane.ERROR_MESSAGE);
            System.out.println("modificar -> El videoJuego NO se ha modificado, id: " + videojuego.getId());
            System.out.println("modificar -> Codigo de respuesta: " + e.getStatusCode());
            return false;
        }
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
    public boolean borrarVideojuegoID(int id) {
        //http://localhost:8080/borrarvideojuego/id DELETE
        try {

            restTemplate.delete(URL + "borrarvideojuego/" + id);
            return true;
        } catch (HttpClientErrorException e) {
//            JOptionPane.showMessageDialog(null,
//                    "El videojuego NO se ha borrado, id: " + id
//                    + "\nCodigo de respuesta: " + e.getStatusCode(),
//                    null, JOptionPane.ERROR_MESSAGE);
            System.out.println("borrar -> El videojuego NO se ha borrado, id: " + id);
            System.out.println("borrar -> Codigo de respuesta: " + e.getStatusCode());
            return false;
        }
    }

    /**
     *
     * @return
     */
    public List<VideoJuego> listar() {
        try {
            //http://localhost:8080/videojuegos GET
            ResponseEntity<VideoJuego[]> re = restTemplate.getForEntity(URL + "videojuegos", VideoJuego[].class);
            VideoJuego[] arrayVideojuegos = re.getBody();
            return Arrays.asList(arrayVideojuegos);//convertimos el array en un arraylist
        } catch (HttpClientErrorException e) {
//            JOptionPane.showMessageDialog(null,
//                    "Error al obtener la lista de Videojuegos"
//                    + "\nCodigo de respuesta: " + e.getStatusCode(),
//                    null, JOptionPane.ERROR_MESSAGE);
            System.out.println("listar -> Error al obtener la lista de Videojuegos");
            System.out.println("listar -> Codigo de respuesta: " + e.getStatusCode());
            return null;
        }
    }

}
