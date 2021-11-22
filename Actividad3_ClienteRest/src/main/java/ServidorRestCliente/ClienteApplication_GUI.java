package ServidorRestCliente;

import ServidorRestCliente.modelo_entidad.VideoJuego;
import ServidorRestCliente.modelo_servicio.ServicioProxyVideoJuego;
import java.awt.Toolkit;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Gonzalo
 */
@SpringBootApplication
public class ClienteApplication_GUI extends JFrame implements CommandLineRunner {

    /**
     *Constructor de la ventana GUI
     */
    public ClienteApplication_GUI() {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage("img\\ghost.png"));
        setLocationRelativeTo(null);
        logo.setIcon(new ImageIcon("img\\logo.png"));
        id.requestFocus();
        setVisible(true);

    }
    //Primero inyectaremos todos los objetos que necesitamos para
    //acceder a nuestro ServicioRest, el ServicioProxyPersona y el
    //ServicioProxyMensaje
    @Autowired
    private ServicioProxyVideoJuego spp;

    //Tambien necesitaremos acceder al contexto de Spring para parar
    //la aplicacion, ya que esta app al ser una aplicacion web se
    //lanzará en un tomcat. De esta manera le decimos a Spring que
    //nos inyecte su propio contexto.
    @Autowired
    private ApplicationContext context;

    //En este metodo daremos de alta un objeto de tipo RestTemplate que sera
    //el objeto mas importante de esta aplicacion. Sera usado por los 
    //objetos ServicioProxy para hacer las peticiones HTTP a nuestro
    //servicio REST. Como no podemos anotar la clase RestTemplate porque
    //no la hemos creado nosotros, usaremos la anotacion @Bean para decirle
    //a Spring que ejecute este metodo y meta el objeto devuelto dentro
    //del contexto de Spring con ID "restTemplate" (el nombre del metodo)
    /**
     *
     * @param builder
     * @return
     */
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        get_Videojuego = new javax.swing.JButton();
        crear_Videojuego = new javax.swing.JButton();
        borrar_Videojuego = new javax.swing.JButton();
        modificar_Videojuego = new javax.swing.JButton();
        listar_Videojuegos = new javax.swing.JButton();
        salir = new javax.swing.JButton();
        id = new javax.swing.JTextField();
        id_Label = new javax.swing.JLabel();
        nombre_Label = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        empresa_Label = new javax.swing.JLabel();
        empresa = new javax.swing.JTextField();
        nota_Label = new javax.swing.JLabel();
        nota = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        muestraDe_Videojuegos = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImages(null);
        setMinimumSize(new java.awt.Dimension(1235, 815));
        setResizable(false);
        setSize(new java.awt.Dimension(1235, 815));

        panel.setBackground(new java.awt.Color(6, 0, 37));
        panel.setMaximumSize(getMaximumSize());
        panel.setMinimumSize(getMinimumSize());

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo.png"))); // NOI18N
        logo.setLabelFor(this);

        get_Videojuego.setBackground(new java.awt.Color(85, 17, 237));
        get_Videojuego.setFont(new java.awt.Font("Segoe UI Symbol", 1, 12)); // NOI18N
        get_Videojuego.setForeground(new java.awt.Color(142, 204, 231));
        get_Videojuego.setText("BUSCAR VIDEOJUEGO");
        get_Videojuego.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(85, 74, 105), javax.swing.UIManager.getDefaults().getColor("Button.background")));
        get_Videojuego.setContentAreaFilled(false);
        get_Videojuego.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        get_Videojuego.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        get_Videojuego.setFocusPainted(false);
        get_Videojuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                get_VideojuegoActionPerformed(evt);
            }
        });

        crear_Videojuego.setBackground(new java.awt.Color(85, 17, 237));
        crear_Videojuego.setFont(new java.awt.Font("Segoe UI Symbol", 1, 12)); // NOI18N
        crear_Videojuego.setForeground(new java.awt.Color(142, 204, 231));
        crear_Videojuego.setText("CREAR VIDEOJUEGO");
        crear_Videojuego.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(85, 74, 105), javax.swing.UIManager.getDefaults().getColor("Button.background")));
        crear_Videojuego.setContentAreaFilled(false);
        crear_Videojuego.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        crear_Videojuego.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        crear_Videojuego.setFocusPainted(false);
        crear_Videojuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crear_VideojuegoActionPerformed(evt);
            }
        });

        borrar_Videojuego.setBackground(new java.awt.Color(85, 17, 237));
        borrar_Videojuego.setFont(new java.awt.Font("Segoe UI Symbol", 1, 12)); // NOI18N
        borrar_Videojuego.setForeground(new java.awt.Color(142, 204, 231));
        borrar_Videojuego.setText("BORRAR VIDEOJUEGO");
        borrar_Videojuego.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(85, 74, 105), javax.swing.UIManager.getDefaults().getColor("Button.background")));
        borrar_Videojuego.setContentAreaFilled(false);
        borrar_Videojuego.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        borrar_Videojuego.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        borrar_Videojuego.setFocusPainted(false);
        borrar_Videojuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrar_VideojuegoActionPerformed(evt);
            }
        });

        modificar_Videojuego.setBackground(new java.awt.Color(85, 17, 237));
        modificar_Videojuego.setFont(new java.awt.Font("Segoe UI Symbol", 1, 12)); // NOI18N
        modificar_Videojuego.setForeground(new java.awt.Color(142, 204, 231));
        modificar_Videojuego.setText("MODIFICAR VIDEOJUEGO");
        modificar_Videojuego.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(85, 74, 105), javax.swing.UIManager.getDefaults().getColor("Button.background")));
        modificar_Videojuego.setContentAreaFilled(false);
        modificar_Videojuego.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        modificar_Videojuego.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        modificar_Videojuego.setFocusPainted(false);
        modificar_Videojuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificar_VideojuegoActionPerformed(evt);
            }
        });

        listar_Videojuegos.setBackground(new java.awt.Color(85, 17, 237));
        listar_Videojuegos.setFont(new java.awt.Font("Segoe UI Symbol", 1, 12)); // NOI18N
        listar_Videojuegos.setForeground(new java.awt.Color(142, 204, 231));
        listar_Videojuegos.setText("LISTAR VIDEOJUEGOS");
        listar_Videojuegos.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(85, 74, 105), javax.swing.UIManager.getDefaults().getColor("Button.background")));
        listar_Videojuegos.setContentAreaFilled(false);
        listar_Videojuegos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        listar_Videojuegos.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        listar_Videojuegos.setFocusPainted(false);
        listar_Videojuegos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listar_VideojuegosActionPerformed(evt);
            }
        });

        salir.setBackground(new java.awt.Color(85, 17, 237));
        salir.setFont(new java.awt.Font("Segoe UI Symbol", 1, 12)); // NOI18N
        salir.setForeground(new java.awt.Color(142, 204, 231));
        salir.setText("EXIT");
        salir.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(85, 74, 105), javax.swing.UIManager.getDefaults().getColor("Button.background")));
        salir.setContentAreaFilled(false);
        salir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        salir.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        salir.setFocusPainted(false);
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });

        id.setBackground(new java.awt.Color(212, 212, 217));
        id.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        id.setForeground(new java.awt.Color(6, 0, 37));
        id.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 3, 75), new java.awt.Color(153, 3, 75), new java.awt.Color(153, 3, 75), new java.awt.Color(153, 3, 75)));

        id_Label.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        id_Label.setForeground(new java.awt.Color(142, 204, 231));
        id_Label.setText("ID");

        nombre_Label.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        nombre_Label.setForeground(new java.awt.Color(142, 204, 231));
        nombre_Label.setText("NOMBRE");

        nombre.setBackground(new java.awt.Color(212, 212, 217));
        nombre.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        nombre.setForeground(new java.awt.Color(6, 0, 37));
        nombre.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 3, 75), new java.awt.Color(153, 3, 75), new java.awt.Color(153, 3, 75), new java.awt.Color(153, 3, 75)));

        empresa_Label.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        empresa_Label.setForeground(new java.awt.Color(142, 204, 231));
        empresa_Label.setText("EMPRESA");

        empresa.setBackground(new java.awt.Color(212, 212, 217));
        empresa.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        empresa.setForeground(new java.awt.Color(6, 0, 37));
        empresa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 3, 75), new java.awt.Color(153, 3, 75), new java.awt.Color(153, 3, 75), new java.awt.Color(153, 3, 75)));

        nota_Label.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        nota_Label.setForeground(new java.awt.Color(142, 204, 231));
        nota_Label.setText("NOTA");

        nota.setBackground(new java.awt.Color(212, 212, 217));
        nota.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        nota.setForeground(new java.awt.Color(6, 0, 37));
        nota.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 3, 75), new java.awt.Color(153, 3, 75), new java.awt.Color(153, 3, 75), new java.awt.Color(153, 3, 75)));

        muestraDe_Videojuegos.setEditable(false);
        muestraDe_Videojuegos.setBackground(new java.awt.Color(6, 0, 37));
        muestraDe_Videojuegos.setColumns(20);
        muestraDe_Videojuegos.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        muestraDe_Videojuegos.setForeground(id_Label.getForeground());
        muestraDe_Videojuegos.setLineWrap(true);
        muestraDe_Videojuegos.setRows(5);
        muestraDe_Videojuegos.setText("AQUI APARECERÁN TUS CONSULTAS........");
        muestraDe_Videojuegos.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(153, 3, 75)));
        muestraDe_Videojuegos.setSelectedTextColor(new java.awt.Color(179, 0, 71));
        muestraDe_Videojuegos.setSelectionColor(new java.awt.Color(6, 0, 37));
        jScrollPane1.setViewportView(muestraDe_Videojuegos);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(listar_Videojuegos, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(184, 184, 184)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 770, Short.MAX_VALUE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(get_Videojuego, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(crear_Videojuego, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(184, 184, 184)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addComponent(nombre_Label)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                        .addComponent(id_Label)
                                        .addGap(98, 98, 98)
                                        .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addComponent(empresa_Label)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(empresa, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addComponent(nota_Label)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(nota, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(borrar_Videojuego, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(modificar_Videojuego, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(logo)))
                .addGap(77, 77, 77))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(get_Videojuego, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(id_Label)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nombre_Label))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(empresa, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(empresa_Label)
                            .addComponent(crear_Videojuego, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nota, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nota_Label))
                        .addGap(3, 3, 3)
                        .addComponent(borrar_Videojuego, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(modificar_Videojuego, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(listar_Videojuegos, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(253, 253, 253)
                        .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(72, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //------------------EVENTOS------------------------------------------
    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        dispose();
        pararAplicacion();
    }//GEN-LAST:event_salirActionPerformed

    private void crear_VideojuegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crear_VideojuegoActionPerformed
        System.out.println("*********** ALTA VIDEOJUEGO EN PROCESO ***************");
        try {
            int auxId = Integer.parseInt(id.getText());
            String auxNombre = nombre.getText();
            String auxEmpresa = empresa.getText();
            int auxNota = Integer.parseInt(this.nota.getText());
            //////////////////////////////////////////
            if (auxNombre.equalsIgnoreCase("") || auxEmpresa.equalsIgnoreCase("")) {
                throw new Exception();
            }
            ///////////////////////////////////////////
            VideoJuego v = new VideoJuego();
            v.setId(auxId);
            v.setNombre(auxNombre);
            v.setEmpresa(auxEmpresa);
            v.setNota(auxNota);
            ///////////////////////////////////////////////////////
            VideoJuego vAlta = spp.darAltaVideoJuego(v);
            System.out.println("Run -> Videojuego dado de alta " + vAlta);
            ////////////////////////////////////////////////////////////////
            muestraDe_Videojuegos.setText("Run -> Videojuego dado de alta:\n");
            muestraDe_Videojuegos.append(vAlta.toString());
            /////////////////////////////////////
            borrarContenidoCajasTexto();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Tanto el ID como la nota del viedeojuego,"
                    + "\ndeben ser números enteros.", null, JOptionPane.ERROR_MESSAGE);
            id.setText(null);
            nota.setText(null);
        } catch (NullPointerException e) {
            muestraDe_Videojuegos.setText("Run -> El Videojuego NO se ha dado de alta, "
                    + "hay otro con el mismo id o nombre en el el servidor.\n"
                    + "Error: " + HttpStatus.NOT_ACCEPTABLE);
        } catch (ResourceAccessException e) {
            JOptionPane.showMessageDialog(null, "El servidor no esta conectado.",
                    null, JOptionPane.ERROR_MESSAGE);
            borrarContenidoCajasTexto();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Tanto el nombre como la empresa del viedeojuego,"
                    + "\nson campos obligatorios.", null, JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_crear_VideojuegoActionPerformed

    private void get_VideojuegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_get_VideojuegoActionPerformed
        System.out.println("************ GET VIDEOJUEGO EN PROCESO ***************");
        try {
            int idAux = Integer.parseInt(id.getText());
            ////////////////////////////////////////////////
            VideoJuego v = spp.obtenerVideoJuegoID(idAux);
            System.out.println("Run -> Videojuego con id " + idAux + ": " + v);
            //////////////////////////////////////////////////
            muestraDe_Videojuegos.setText("Run -> Videojuego con id " + idAux + ": " + v);
            if (v == null) {
                muestraDe_Videojuegos.setText("Run -> Ese Videojuego NO esta en el servidor.\n"
                        + "Error: " + HttpStatus.NOT_FOUND);
            }
            borrarContenidoCajasTexto();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El ID del viedeojuego,"
                    + "\ndebe ser un número entero.", null, JOptionPane.ERROR_MESSAGE);
            borrarContenidoCajasTexto();
        } catch (NullPointerException e) {
            muestraDe_Videojuegos.setText("Run -> Ese Videojuego NO esta en el servidor.\n"
                    + "Error: " + HttpStatus.NOT_FOUND);
        } catch (ResourceAccessException e) {
            JOptionPane.showMessageDialog(null, "El servidor no esta conectado.",
                    null, JOptionPane.ERROR_MESSAGE);
            borrarContenidoCajasTexto();
        }

    }//GEN-LAST:event_get_VideojuegoActionPerformed

    private void modificar_VideojuegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificar_VideojuegoActionPerformed
        System.out.println("********* MODIFICAR VIDEOJUEGO EN PROCESO *************");
        try {
            VideoJuego vModificar = new VideoJuego();
            int auxId = Integer.parseInt(id.getText());
            String auxNombre = nombre.getText();
            String auxEmpresa = empresa.getText();
            int auxNota = Integer.parseInt(this.nota.getText());
            ////////////////////////////////////////////////////
            //////////////////////////////////////////
            if (auxNombre.equalsIgnoreCase("") || auxEmpresa.equalsIgnoreCase("")) {
                throw new Exception();
            }
            ///////////////////////////////////////////
            vModificar.setId(auxId);
            vModificar.setNombre(auxNombre);
            vModificar.setEmpresa(auxEmpresa);
            vModificar.setNota(auxNota);
            //////////////////////////////////////////////////////
            boolean modificado = spp.modificarVideojuegoID(vModificar);
            ///////////////////////////////////////////////////////
            System.out.println("Run -> Videojuego modificado? " + modificado);
            muestraDe_Videojuegos.setText("Run -> Videojuego modificado? " + modificado);
            if (modificado == false) {
                muestraDe_Videojuegos.append("\nEl videojuego con id " + auxId + " no esta en el servidor, o el nombre esta repetido.\n"
                        + "Error: " + HttpStatus.FORBIDDEN);
            }
            //////////////////////////////////////////////////////////////////////
            borrarContenidoCajasTexto();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El ID del viedeojuego,"
                    + "\ndebe ser un número entero.", null, JOptionPane.ERROR_MESSAGE);
            borrarContenidoCajasTexto();
        } catch (ResourceAccessException e) {
            JOptionPane.showMessageDialog(null, "El servidor no esta conectado.",
                    null, JOptionPane.ERROR_MESSAGE);
            borrarContenidoCajasTexto();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Tanto el nombre como la empresa del viedeojuego,"
                    + "\nson campos obligatorios.", null, JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_modificar_VideojuegoActionPerformed

    private void borrar_VideojuegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrar_VideojuegoActionPerformed
        System.out.println("********** BORRAR VIDEOJUEGO EN PROCESO **************");
        ///////////////////////////////////////////////////////////////////////////
        try {
            int auxId = Integer.parseInt(id.getText());
            boolean borrado = spp.borrarVideojuegoID(auxId);
            ////////////////////////////////////////////////////
            System.out.println("run -> Videojuego con id " + auxId + " borrado? " + borrado);
            muestraDe_Videojuegos.setText("run -> Videojuego con id " + auxId + " borrado? " + borrado);
            /////////////////////////////////////////////////////
            if (borrado == false) {
                muestraDe_Videojuegos.append("\nEl videojuego con id " + auxId + " no esta en el servidor.\n"
                        + "Error: " + HttpStatus.NOT_FOUND);
            }
            borrarContenidoCajasTexto();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El ID del viedeojuego,"
                    + "\ndebe ser un número entero.", null, JOptionPane.ERROR_MESSAGE);
            borrarContenidoCajasTexto();
        } catch (ResourceAccessException e) {
            JOptionPane.showMessageDialog(null, "El servidor no esta conectado.",
                    null, JOptionPane.ERROR_MESSAGE);
            borrarContenidoCajasTexto();
        }

    }//GEN-LAST:event_borrar_VideojuegoActionPerformed

    private void listar_VideojuegosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listar_VideojuegosActionPerformed
        System.out.println("********** LISTAR VIDEOJUEGOS EN PROCESO ***************");
        try {
            List<VideoJuego> listaVideoJuegos = spp.listar();
            //Recorremos la lista y la imprimimos con funciones lambda
            //Tambien podriamos haber usado un for-each clasico de java
            listaVideoJuegos.forEach((v) -> System.out.println(v));
            ///--------------------------------------------------------------
            muestraDe_Videojuegos.setText("----------LISTA DE VIDEOJUEGOS-----------\n");
            for (VideoJuego Vid : listaVideoJuegos) {
                muestraDe_Videojuegos.append(Vid.toString() + "\n");
            }
        } catch (ResourceAccessException e) {
            JOptionPane.showMessageDialog(null, "El servidor no esta conectado.",
                    null, JOptionPane.ERROR_MESSAGE);
            borrarContenidoCajasTexto();
        }
    }//GEN-LAST:event_listar_VideojuegosActionPerformed

    //-----------------------MAIN--------------------------------------
    /**
     * METODO MAIN
     *
     * @param args
     */
    public static void main(String args[]) {
        System.out.println("Cliente -> Cargando el contexto de Spring");
        SpringApplication.run(ClienteApplication_GUI.class, args);
    }

    /**
     * METODO RUN
     *
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {

    }

    //-------------------------METODOS------------------------------------------------
    /**
     * METODO PARA PARAR LA APLICACION
     */
    public void pararAplicacion() {
        //Esta aplicacion levanta un servidor web, por lo que tenemos que darle 
        //la orden de pararlo cuando acabemos. Para ello usamos el metodo exit, 
        //de la clase SpringApplication, que necesita el contexto de Spring y 
        //un objeto que implemente la interfaz ExitCodeGenerator. 
        //Podemos usar la funcion lambda "() -> 0" para simplificar 
        SpringApplication.exit(context, () -> 0);
    }

    /**
     * METODO PARA BORRAR LAS CAJAS DE TEXTO
     */
    public void borrarContenidoCajasTexto() {
        id.setText(null);
        nombre.setText(null);
        empresa.setText(null);
        nota.setText(null);
    }

    //////////////ATRIBUTOS////////////////////////////////////
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton borrar_Videojuego;
    private javax.swing.JButton crear_Videojuego;
    private javax.swing.JTextField empresa;
    private javax.swing.JLabel empresa_Label;
    private javax.swing.JButton get_Videojuego;
    private javax.swing.JTextField id;
    private javax.swing.JLabel id_Label;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton listar_Videojuegos;
    private javax.swing.JLabel logo;
    private javax.swing.JButton modificar_Videojuego;
    private javax.swing.JTextArea muestraDe_Videojuegos;
    private javax.swing.JTextField nombre;
    private javax.swing.JLabel nombre_Label;
    private javax.swing.JTextField nota;
    private javax.swing.JLabel nota_Label;
    private javax.swing.JPanel panel;
    private javax.swing.JButton salir;
    // End of variables declaration//GEN-END:variables
}
