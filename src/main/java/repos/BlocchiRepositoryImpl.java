package repos;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import extraction.ExtractoOfSoapMessage;
import models.BlocchiTypeCCI;
import models.BlocchiTypeCCO;
import repos.interfaces.IBlocchiRepository;

@Repository
public class BlocchiRepositoryImpl implements IBlocchiRepository{	
	
	@Autowired
	ExtractoOfSoapMessage ouhg0ierg; 
	
	/*String tempXml = "<soapenv:Envelope xmlns:soapenv=\\\"http://schemas.xmlsoap.org/soap/envelope/\\\" xmlns:soapenc=\\\"http://schemas.xmlsoap.org/soap/encoding/\\\" xmlns:xsd=\\\"http://www.w3.org/2001/XMLSchema\\\" xmlns:xsi=\\\"http://www.w3.org/2001/XMLSchema-instance\\\">\\r\\n\" + \r\n" + 
			"            \"   <soapenv:Header/>\\r\\n\" + \r\n" + 
			"            \"   <soapenv:Body>\\r\\n\" + \r\n" + 
			"            \"       \\r\\n\" + \r\n" + 
			"            \"            <BlocchiCCOType>\" + \r\n" + 
			"            \"               <esistenzaConto>S</esistenzaConto>\\r\\n\" + \r\n" + 
			"            \"               <statoConto>20</statoConto>\\r\\n\" + \r\n" + 
			"            \"               <divisaConto>EUR</divisaConto>\\r\\n\" + \r\n" + 
			"            \"               <richiestaChiusura>N</richiestaChiusura>\\r\\n\" + \r\n" + 
			"            \"               <presenzaBlocchi>N</presenzaBlocchi>\\r\\n\" + \r\n" + 
			"            \"            </BlocchiCCOType>\\r\\n\" + \r\n" + 
			"            \"          \\r\\n\" + \r\n" + 
			"            \"   </soapenv:Body>\\r\\n\" + \r\n" + 
			"            \"</soapenv:Envelope>";*/
	 
	@Override
	public BlocchiTypeCCO getBlocchi() throws JAXBException, SOAPException, IOException{
		
		StringWriter sw = new StringWriter();
		SOAPMessage soapResponse = getSoapMessageFromString(ouhg0ierg.extrctorMethod());
		
		 
		try {
			TransformerFactory.newInstance().newTransformer().transform(new DOMSource(soapResponse.getSOAPPart()),
					new StreamResult(sw));
		} catch (TransformerException e) {
			throw new RuntimeException(e);
		}

		Unmarshaller unmarshaller = JAXBContext.newInstance(models.BlocchiTypeCCO.class).createUnmarshaller();
		BlocchiTypeCCO blocchiTypeCCO = (models.BlocchiTypeCCO)unmarshaller.unmarshal(soapResponse.getSOAPBody().extractContentAsDocument());
		return blocchiTypeCCO;
	}
	
	private static SOAPMessage getSoapMessageFromString(String xml) throws SOAPException, IOException {
		MessageFactory factory = MessageFactory.newInstance();
		SOAPMessage message = factory.createMessage(new MimeHeaders(),
				new ByteArrayInputStream(xml.getBytes(Charset.forName("UTF-8"))));
		return message;
	}
	
	public List<BlocchiTypeCCO> getBlocchiList() throws JAXBException, SOAPException, IOException{
		ArrayList<BlocchiTypeCCO> temp = new ArrayList<>();
		temp.add(getBlocchi());
		temp.add(getBlocchi());
		
		return temp;
	}

	@Override

	public void insertBlocchiCC(BlocchiTypeCCI blocchiTypeCCI) {

		try {

			JAXBContext jaxbContext = JAXBContext.newInstance(BlocchiTypeCCI.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			dbf.setNamespaceAware(true);
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(new File("C:\\BlocchiCC_Request.xml"));

			NodeList nodes = doc.getElementsByTagName("inp:input-data");
			nodes.item(0).setTextContent("\n");

			File tempFile = new File("C:\\file.xml");
			jaxbMarshaller.marshal((Object) blocchiTypeCCI, tempFile);

			Document docTemp = db.parse("C:\\file.xml");
			NodeList nodesTemp = docTemp.getElementsByTagName("inp:BlocchiCCIType");
			Node firstDocImportedNode = doc.importNode(nodesTemp.item(0), true);
			nodes.item(0).appendChild(firstDocImportedNode);

			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			Result output = new StreamResult(new File("C:\\BlocchiCC_Request.xml"));
			Source input = new DOMSource(doc);
			transformer.transform(input, output);

		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}

}
