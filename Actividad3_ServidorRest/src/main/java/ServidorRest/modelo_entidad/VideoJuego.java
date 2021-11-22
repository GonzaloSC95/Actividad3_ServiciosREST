package ServidorRest.modelo_entidad;

/**
 *
 * @author Gonzalo
 */
public class VideoJuego {
    
    private int id;
    private String nombre,empresa;
    private int nota;
    //-------------------------------
    /**
     *Constructro para crear VideoJuegos
     * @param id
     * @param nombre
     * @param nota
     * @param empresa
     */
    public VideoJuego(int id, String nombre, String empresa, int nota) {
        this.id = id;
        this.nombre = nombre;
        this.empresa = empresa;
        this.nota = nota;
    }

    //---------------------------------------------------------
    /**
     *GET ID
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *SET ID
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *GET NOMBRE
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *SET NOMBRE
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *GET COMPAÑIA
     * @return
     */
    public String getEmpresa() {
        return empresa;
    }

    /**
     *SET COMPAÑIA
     * @param empresa
     */
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    /**
     *GET NOTA
     * @return
     */
    public int getNota() {
        return nota;
    }

    /**
     *SET NOTA
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
