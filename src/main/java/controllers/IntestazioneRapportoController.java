package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;
import javax.xml.soap.SOAPException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import models.IntestazioneRapportoCCOType;
import models.IntestazioneRapportoCCIType;
import service.IntestazioneRapportoService;

import service.interfaces.IIntestazioneRapportoService;

@RestController
public class IntestazioneRapportoController {
 
	
	@Autowired
	IIntestazioneRapportoService intestazioneService=new IntestazioneRapportoService();
	
	
	@CrossOrigin
	@RequestMapping(path = "/getRapp",method = RequestMethod.POST)
	public void takeRapporto(@RequestBody IntestazioneRapportoCCIType rappCCI, HttpServletResponse response) throws IOException {
		
		intestazioneService.takeRapp(rappCCI);
		
		response.sendRedirect("http://localhost:8080/projekat/rapporto");
	
	}
	
	@CrossOrigin
	@RequestMapping(path = "/rapporto",method = RequestMethod.GET, produces = "application/json")
	public List<IntestazioneRapportoCCOType> getRapporto() throws JAXBException, SOAPException, IOException{
	 
		List<IntestazioneRapportoCCOType> rapp=new ArrayList<IntestazioneRapportoCCOType>();
		rapp.add(intestazioneService.getRapporto());
		return rapp;
	}
}
