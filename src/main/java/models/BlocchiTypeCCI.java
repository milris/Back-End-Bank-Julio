package models;

import javax.xml.bind.annotation.XmlElement;

import javax.xml.bind.annotation.XmlRootElement;

import javax.xml.bind.annotation.XmlType;

@XmlType(name = "", propOrder = {

		"serviceInput",

		"sportello",

		"conto"

})

@XmlRootElement(name = "inp:BlocchiCCIType")

public class BlocchiTypeCCI {

	ServiceInput serviceInput;

	String sportello;

	String conto;

	public ServiceInput getServiceInput() {

		return serviceInput;

	}

	@XmlElement(name = "inp:serviceInput")

	public void setServiceInput(ServiceInput serviceInput) {

		this.serviceInput = serviceInput;

	}

	public String getSportello() {

		return sportello;

	}

	@XmlElement(name = "inp:sportello")

	public void setSportello(String sportello) {

		this.sportello = sportello;

	}

	public String getConto() {

		return conto;

	}

	@XmlElement(name = "inp:conto")

	public void setConto(String conto) {

		this.conto = conto;

	}

	@Override

	public String toString() {

		return "BlocchiTypeCCI [serviceInput=" + serviceInput + ", sportello=" + sportello + ", conto=" + conto + "]";

	}

}
