package controllers;

 
import java.util.List;
 

import org.springframework.beans.factory.annotation.Autowired;
 
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
 
import models.xsd.DatiRapportoCCIType;
import service.interfaces.IDatiRapportoService;

@RestController 
public class DatiRapportoController {
	
	@Autowired
	IDatiRapportoService datiRapportService;
	
	
	@CrossOrigin
	@RequestMapping(path = "/getDatiRapports",method = RequestMethod.POST)
	public List<DatiRapportoCCIType> getDatiRapportos() {	 
		return  datiRapportService.getDatiRapportoList();
	}

}
