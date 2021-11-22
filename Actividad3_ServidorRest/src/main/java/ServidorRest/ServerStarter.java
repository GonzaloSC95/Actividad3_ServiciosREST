package ServidorRest;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 *
 * @author Gonzalo
 */
public class ServerStarter extends SpringBootServletInitializer {

    /**
     *
     * @param application
     * @return
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
