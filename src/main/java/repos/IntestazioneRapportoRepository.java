package repos;

import java.io.IOException;

import javax.xml.bind.JAXBException;
import javax.xml.soap.SOAPException;

import org.springframework.stereotype.Repository;

import models.IntestazioneRapportoCCIType;
import models.IntestazioneRapportoCCOType;
import repos.interfaces.IIntestazioneRapportoRepository;

@Repository
public class IntestazioneRapportoRepository implements IIntestazioneRapportoRepository{

	@Override
	public IntestazioneRapportoCCOType getRapporto() throws JAXBException, SOAPException, IOException {
	
		//ovde objekat iz xmla
		IntestazioneRapportoCCOType intestazioneRapporto=new IntestazioneRapportoCCOType();
		return intestazioneRapporto;
	}

	@Override
	public void takeRapporto(IntestazioneRapportoCCIType rappCCI) {
		//ovde bi trebalo konvertovati u xml
		System.out.println("Conto: "+rappCCI.getCodConto());
		System.out.println("Sportello: "+rappCCI.getCodSportello());
		System.out.println("Chanel type: "+rappCCI.getServiceInput().getAhChannelType());
		System.out.println("Cod centro: "+rappCCI.getServiceInput().getAhCodCentro());
		System.out.println("Domain id: "+rappCCI.getServiceInput().getAhDomainId());
		System.out.println("Header tyoe: "+rappCCI.getServiceInput().getAhHeaderType());
		System.out.println("Node id: "+rappCCI.getServiceInput().getAhNodeId());
		System.out.println("User id: "+rappCCI.getServiceInput().getAhUserId());
		
		
	}
}
