package repos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import extraction.MockDatiRapporto;
import models.xsd.DatiRapportoCCIType;
import repos.interfaces.IDatiRapportoCCIType;

@Repository
public class DatiRapportoRpositoryImpl implements IDatiRapportoCCIType{
	 
	 
	MockDatiRapporto datiRapport = new MockDatiRapporto(); 
	
	public DatiRapportoCCIType getDatiRapport() {		 
		return datiRapport.getDatiRapporto();		 
	}

	@Override
	public List<DatiRapportoCCIType> getDatiRapportoList() {
		ArrayList<DatiRapportoCCIType> temp = new ArrayList<>();
		temp.add(getDatiRapport());
		temp.add(getDatiRapport());
		
		return temp;	 
	}

	@Override
	public void insertDatiRapportoCCIType(DatiRapportoCCIType datiRapportoCIIType) {
		// TODO Auto-generated method stub
		
	}
	
	

}
