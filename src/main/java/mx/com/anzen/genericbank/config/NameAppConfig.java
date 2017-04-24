package mx.com.anzen.genericbank.config;
  
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import mx.com.anzen.minio.models.ConexionMinioBean;
import mx.com.anzen.mongo.models.ConexionDataBean;
import mx.com.anzen.repository.SPRepository;
 
//@ComponentScan("mx.com.anzen.mongo")
@ComponentScan(basePackages={"mx.com.anzen.minio","mx.com.anzen.mongo"})
@Configuration
public class NameAppConfig {
	
	//Minio
	
	@Bean
	public ConexionMinioBean conexionMinio(){
		return new ConexionMinioBean();
	}
 
	@Bean
	public ConexionDataBean conexion(){
		return new ConexionDataBean();
	}
	
	// Realizar la inyección de dependencia para el repositorio de persistencia
	@Bean
    public SPRepository entityManager() {
        return new SPRepository();
    }
	 
	
}
