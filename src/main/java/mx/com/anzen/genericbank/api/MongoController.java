package mx.com.anzen.genericbank.api;


import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 

import io.minio.messages.Bucket;
import mx.com.anzen.minio.services.MinioService;
import mx.com.anzen.mongo.services.MongoService; 

@RestController
public class MongoController {

	// Inyeccion de dependencias del servicio
	@Autowired
	private MinioService nameService;
	
	@Autowired
	private MongoService mongo;
	
	private static Logger log = Logger.getLogger(MongoController.class);
	
	@RequestMapping(value="/layout")
 public Map<String,Object> layout(@RequestBody JSONObject  json ) { 
		
		Map<String,Object> map=new HashMap();
		Map<String,Object> mapResult=null;
		try{
			map.put("fileDefinition.idFileType",json.get("IdFileType")); 
			mapResult=mongo.consulta("ADBancaGenerica",map); 
			  
		}catch (HttpMessageNotReadableException e) {
			System.out.println("exception");
			log.info("Error: "+e.getMessage());
			mapResult.put("CodigoError: ",100);
			mapResult.put("Error: ",e.getMessage()); 
			 
		}catch (Exception e) {
			log.info("Error: "+e.getMessage());
			mapResult.put("CodigoError: ",100);
			mapResult.put("Error: ",e.getMessage()); 
		}
		
        return mapResult;
    }
	

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/consulta")
	public JSONArray insertState() {
		//nos trae todos los nodos que existen
		 
		JSONObject jsonObject=new JSONObject();
		JSONArray array=new JSONArray();
				List<Bucket> lista= nameService.listaNodos();
				
				for (Bucket bucket : lista) {
					jsonObject.put("Nombre", bucket.name());
					jsonObject.put("Fecha creación", bucket.creationDate());
			        System.out.println(bucket.creationDate() + ", " + bucket.name());
			        array.add(jsonObject);
			        
				} 
	 
		return array;

	}
}
