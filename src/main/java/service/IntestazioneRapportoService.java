package service;

import java.io.IOException;

import javax.xml.bind.JAXBException;
import javax.xml.soap.SOAPException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import models.IntestazioneRapportoCCIType;
import models.IntestazioneRapportoCCOType;
import repos.IntestazioneRapportoRepository;
import repos.interfaces.IIntestazioneRapportoRepository;
import service.interfaces.IIntestazioneRapportoService;

@Service
public class IntestazioneRapportoService implements IIntestazioneRapportoService{
	
	@Autowired
	IIntestazioneRapportoRepository intestazioneRepo= new IntestazioneRapportoRepository();
	
	@Override
	public IntestazioneRapportoCCOType getRapporto() throws JAXBException, SOAPException, IOException {
		
		return intestazioneRepo.getRapporto();
	}

	@Override
	public void takeRapp(IntestazioneRapportoCCIType rappCCI) {
		intestazioneRepo.takeRapporto(rappCCI);
		
	}

}
