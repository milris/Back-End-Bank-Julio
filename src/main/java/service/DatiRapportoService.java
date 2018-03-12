package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import models.xsd.DatiRapportoCCIType;
import repos.interfaces.IDatiRapportoCCIType;
import service.interfaces.IDatiRapportoService;

@Service
public class DatiRapportoService implements IDatiRapportoService{

	@Autowired
	IDatiRapportoCCIType datiRapport;
	
	@Override
	public List<DatiRapportoCCIType> getDatiRapportoList() {		 
		return datiRapport.getDatiRapportoList();
	}

}
