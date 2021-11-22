package ServidorRestCliente.modelo_entidad;

import org.springframework.stereotype.Component;

/**
 *
 * @author Gonzalo
 */
@Component
public class VideoJuego {

    private int id;
    private String nombre, empresa;
    private int nota;

    //-------------------------------
    /**
     * Constructor 1 para crear VideoJuegos
     *
     * @param id
     * @param nombre
     * @param empresa
     * @param nota
     */
    public VideoJuego(int id, String nombre, String empresa, int nota) {
        this.id = id;
        this.nombre = nombre;
        this.empresa = empresa;
        this.nota = nota;
    }

    /**
     * Constructor 2 para crear VideoJuegos
     */
    public VideoJuego() {
        super();
    }

    //---------------------------------------------------------
    /**
     * GET ID
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * SET ID
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * GET NOMBRE
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * SET NOMBRE
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * GET COMPAÑIA
     *
     * @return
     */
    public String getEmpresa() {
        return empresa;
    }

    /**
     * SET COMPAÑIA
     *
     * @param empresa
     */
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    /**
     * GET NOTA
     *
     * @return
     */
    public int getNota() {
        return nota;
    }

    /**
     * SET NOTA
     *
     * @param nota
     */
    public void setNota(int nota) {
        this.nota = nota;
    }

    //-----------------------------------
    @Override
    /**
     * TO STRING DE VIDEOJUEGO
     */
    public String toString() {
        String json="VideoJuego{" + "id: " + id + ", nombre: " + nombre + ", empresa: " + empresa + ", nota: " + nota + '}';
        return json.toUpperCase();
    }

}
