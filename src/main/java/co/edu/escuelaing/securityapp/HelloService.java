
package co.edu.escuelaing.securityapp;
import static spark.Spark.*;

/**
 *
 * @author dtorres
 */
public class HelloService {
    
    public static void main(String[] args) {
        port(getPort());
        
        //API: secure(keystoreFilePath, keystorePassword, truststoreFilePath,truststorePassword);
 secure("keystore/ecikeystore.p12", "diego123", null, null);
 get("/hello", (req, res) -> "Hello World"); 
 
    }
    
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5000; //returns default port if heroku-port isn't set (i.e. on localhost)
    }

    
    
}
