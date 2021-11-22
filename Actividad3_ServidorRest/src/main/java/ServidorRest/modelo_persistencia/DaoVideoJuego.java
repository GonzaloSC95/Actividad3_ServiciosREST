package ServidorRest.modelo_persistencia;

import ServidorRest.modelo_entidad.VideoJuego;
import com.google.gson.Gson;
import java.util.LinkedList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author Gonzalo
 */
@Component
public class DaoVideoJuego {

    /**
     * Lista de VideoJuegos
     */
    public List<VideoJuego> ListaVideoJuegos;

    /**
     * Contador ID
     */
    public int contador;

    /**
     * COSTRUCTOR DAOVIDEOJUEGO
     */
    public DaoVideoJuego() {
        contador = 1;
        VideoJuego v1 = new VideoJuego(contador++, "Fifa 2021", "EA SPORTS", 10);
        VideoJuego v2 = new VideoJuego(contador++, "AVENGERS", "UBISOFT", 6);
        VideoJuego v3 = new VideoJuego(contador++, "NBA 2K21", "EA SPORTS", 10);
        VideoJuego v4 = new VideoJuego(contador++, "SONIC", "SEGA", 3);
        VideoJuego v5 = new VideoJuego(contador++, "SPIDERMAN", "SONY", 10);
        //-------------------------------------------------------
        ListaVideoJuegos = new LinkedList<>();
        ListaVideoJuegos.add(v1);
        ListaVideoJuegos.add(v2);
        ListaVideoJuegos.add(v3);
        ListaVideoJuegos.add(v4);
        ListaVideoJuegos.add(v5);
        System.out.println("\n-----VIDEOJUEGOS DISPONIBLES-----");
        ListaVideoJuegos.forEach((v) -> {
            System.out.println(v);
        }
        );
        System.out.println("--------------------------------\n");

    }

    //-------------------------METODOS----------------------------------------
    /**
     * METODO PARA DAR DE ALTA UN VIDEOJUEGO
     *
     * @param VideoJuego
     * @return VideoJuego
     */
    public VideoJuego postVideoJuego(VideoJuego VideoJuego) {
        ListaVideoJuegos.add(VideoJuego);
        return VideoJuego;
    }

    /**
     * METODO PARA BORRAR UN VIDEOJUEGO POR SU ID
     *
     * @param id
     * @return boolean
     */
    public boolean delVideoJuego(int id) {
        boolean borrado = false;
        for (VideoJuego vid : ListaVideoJuegos) {
            if (vid.getId() == id) {
                System.out.println("El videojuego " + vid + " ha sido eliminado del servidor");
                borrado = ListaVideoJuegos.remove(vid);
                return borrado;
            }
        }
        System.out.println("No disponemos de ese videojuego en nuestro servidor");
        return borrado;
    }

    /**
     * METODO PARA MODIFICAR UN VIDEOJUEGO POR SU ID
     *
     * @param id
     * @param videojuego
     * @return boolean
     */
    public boolean putVideojuego(int id, VideoJuego videojuego) {
        VideoJuego aux = null;
        VideoJuego modificado = null;
        boolean salir = false;
        if (!checkJuegoRepetidoNombre(videojuego)) {
            System.out.println("El videojuego con nombre: " + videojuego.getNombre()
                    + " e ID: " + videojuego.getId() + ", ya existe en nuestro servidor."
                    + "Prueba con otras modificaciones");
            return salir;
        }

        for (VideoJuego vid : ListaVideoJuegos) {
            if (vid.getId() == id) {
                modificado = vid;
                //System.out.println("Modificado: "+modificado);
                //System.out.println("Vid: "+vid);
            }
        }

        if (modificado != null) {
            int posicion=ListaVideoJuegos.indexOf(modificado);
            aux = videojuego;
            System.out.println("Vas a modificar el videojuego " + ListaVideoJuegos.set(posicion, videojuego));
            System.out.println("Modificaste el videojuego correctamente.\n"
                    + "El nuevo videojuego es: " + aux);
            salir = true;
            return salir;

        }

        System.out.println("Ese videojuego no esta en el servidor, no lo puedes cambiar");
        return salir;
    }

    /**
     * METODO PARA OBTENER UN VIDEOJUEGO POR SU ID
     *
     * @param id
     * @return
     */
    public VideoJuego getVideoJuegoByID(int id) {
        VideoJuego aux = null;
        for (VideoJuego vid : ListaVideoJuegos) {
            if (vid.getId() == id) {
                aux = vid;
            }
        }
        if (aux != null) {
            System.out.println("Videojuego encontrado: " + aux + "\n");
        } else {
            System.out.println("El videojuego con ID " + id + " no esta en el servidor\n");
        }

        return aux;
    }

    /**
     * METODO PARA LISTAR TODOS LOS VIDEOJUEGOS DEL SERVIDOR
     *
     * @return JSON
     */
    public String getListaVideoJuegos() {
        Gson json = new Gson();
        System.out.println("--------------------------------");
        System.out.println("Aqui tienes tus videojuegos:");
        ListaVideoJuegos.forEach(((v) -> {
            System.out.println(v);
        }));
        System.out.println("--------------------------------");
        return json.toJson(ListaVideoJuegos);
    }

    /**
     * METODO PARA SABER SI UN JUEGO ESTA EN EL SERVIDOR O NO
     *
     * @param videoJuego
     * @return boolean
     */
    public boolean checkJuegoRepetido(VideoJuego videoJuego) {
        boolean noRepetido = true;
        for (VideoJuego vid : ListaVideoJuegos) {
            if (vid.getId() == videoJuego.getId() || vid.getNombre().equalsIgnoreCase(videoJuego.getNombre())) {
                noRepetido = false;
                System.out.println("El videojuego con ID:" + videoJuego.getId() + " y NOMBRE: " + videoJuego.getNombre() + " ya esta en el servidor\n");
                return noRepetido;
            }
        }
        System.out.println("El videojuego con ID:" + videoJuego.getId() + " y NOMBRE: " + videoJuego.getNombre() + " no esta en el servidor\n");
        return noRepetido;
    }
    
    /**
     *METODO PARA SABER SI UN JUEGO ESTA EN EL SERVIDOR O NO, POR SU NOMBRE
     * ESPECIFICO PARA EL METODO putVideojuego(int id, VideoJuego videojuego)
     * MODIFICAR VIDEOJUEGO
     * @param videoJuego
     * @return
     */
    public boolean checkJuegoRepetidoNombre(VideoJuego videoJuego) {
        boolean noRepetido = true;
        for (VideoJuego vid : ListaVideoJuegos) {
            if (vid.getNombre().equalsIgnoreCase(videoJuego.getNombre())) {
                noRepetido = false;
                System.out.println("El videojuego con ID:" + videoJuego.getId() + " y NOMBRE: " + videoJuego.getNombre() + " ya esta en el servidor\n");
                return noRepetido;
            }
        }
        System.out.println("El videojuego con ID:" + videoJuego.getId() + " y NOMBRE: " + videoJuego.getNombre() + " no esta en el servidor\n");
        return noRepetido;
    }

}
