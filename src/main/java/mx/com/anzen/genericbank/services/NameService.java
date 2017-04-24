package mx.com.anzen.genericbank.services;

import java.util.List;
import mx.com.anzen.genericbank.models.NameBean;

public interface NameService {
	
	// Inserta en catalogo un nuevo estado
	public Object insertState(int id, String state);
	
	// Recuperar estado por ID
	public List<NameBean> getState(int id);
}
