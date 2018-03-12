package service.interfaces;

import java.io.IOException;

import javax.xml.bind.JAXBException;
import javax.xml.soap.SOAPException;
 
import models.IntestazioneRapportoCCIType;
import models.IntestazioneRapportoCCOType;

public interface IIntestazioneRapportoService {

	IntestazioneRapportoCCOType getRapporto() throws JAXBException, SOAPException, IOException;

	void takeRapp(IntestazioneRapportoCCIType rappCCI);
	
}
