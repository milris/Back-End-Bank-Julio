package repos.interfaces;

import java.util.List;

import models.xsd.DatiRapportoCCIType;

public interface IDatiRapportoCCIType {
	

	List<DatiRapportoCCIType> getDatiRapportoList();
	
	void insertDatiRapportoCCIType(DatiRapportoCCIType datiRapportoCIIType);
}
