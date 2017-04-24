package mx.com.anzen.genericbank.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.anzen.bean.ParametrosSP;
import mx.com.anzen.genericbank.models.NameBean;
import mx.com.anzen.repository.SPRepository;

@Service
public class NameServiceImpl implements NameService{

	@Autowired
	private SPRepository spService;

	
	/*
	 * Invoke a Stored Procedure (insercion, eliminacion y actualizacion)
	 * 
	 * Tipos de Datos de PARAMETROS
	 * 1.- Enteros
	 * 2.- Decimales
	 * 3.- Texto
	 */
	@Override
	public Object insertState(int id, String state) {
		
		// Nombre SP
		String nombreSP = "adb_spi_statesTest";
				
		// Parametros SP
		List<ParametrosSP> lstParametrosSP = new ArrayList<ParametrosSP>();
		ParametrosSP pId = new ParametrosSP(1,"idStateCode",id);
		ParametrosSP pState = new ParametrosSP(3,"state",state);
		lstParametrosSP.add(pId);
		lstParametrosSP.add(pState);
		
		// Invocar SP para insert, update y delete
		return spService.getCRUDSP(nombreSP, lstParametrosSP);
	}


	/*
	 * Invoke a Stored Procedure (Consultas)
	 * 
	 * Tipos de Datos de PARAMETROS
	 * 1.- Enteros
	 * 2.- Decimales
	 * 3.- Texto
	 */
	@Override
	public List<NameBean> getState(int id) {
		
		// Nombre SP
		String nombreSP = "adb_spr_statesTest";
						
		// Parametros SP
		List<ParametrosSP> lstParametrosSP = new ArrayList<ParametrosSP>();
		ParametrosSP pId = new ParametrosSP(1,"idState",id);
		lstParametrosSP.add(pId);
				
		// Invocar SP para insert, update y delete
		@SuppressWarnings("unchecked")
		List<NameBean> lstStates = (List<NameBean>)spService.getQuerySP(nombreSP, lstParametrosSP);
		
		return lstStates;
	}
	
}
