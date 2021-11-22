package ServidorRest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author Gonzalo
 */
@SpringBootApplication
public class Application {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Servicio Rest -> Cargando el contexto de Spring...");

        SpringApplication.run(Application.class, args);

        System.out.println("Servicio Rest -> Contexto de Spring cargado!");

    }

}
