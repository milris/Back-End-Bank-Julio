package models;

import javax.xml.bind.annotation.XmlElement;

import javax.xml.bind.annotation.XmlRootElement;

import javax.xml.bind.annotation.XmlType;

@XmlType(name = "", propOrder = {

		"ahHeaderType",

		"ahUserId",

		"ahDomainId",

		"ahNodeId",

		"ahCodCentro",

		"ahChannelType"

})

@XmlRootElement(name = "inp:serviceInput")

public class ServiceInput {

	String ahHeaderType;

	String ahUserId;

	String ahDomainId;

	String ahNodeId;

	String ahCodCentro;

	String ahChannelType;

	public String getAhHeaderType() {

		return ahHeaderType;

	}

	@XmlElement(name = "ser:ah-header-type")

	public void setAhHeaderType(String ahHeaderType) {

		this.ahHeaderType = ahHeaderType;

	}

	public String getAhUserId() {

		return ahUserId;

	}

	@XmlElement(name = "ser:ah-user-id")

	public void setAhUserId(String ahUserId) {

		this.ahUserId = ahUserId;

	}

	public String getAhDomainId() {

		return ahDomainId;

	}

	@XmlElement(name = "ser:ah-domain-id")

	public void setAhDomainId(String ahDomainId) {

		this.ahDomainId = ahDomainId;

	}

	public String getAhNodeId() {

		return ahNodeId;

	}

	@XmlElement(name = "ser:ah-node-id")

	public void setAhNodeId(String ahNodeId) {

		this.ahNodeId = ahNodeId;

	}

	public String getAhCodCentro() {

		return ahCodCentro;

	}

	@XmlElement(name = "ser:ah-cod-centro")

	public void setAhCodCentro(String ahCodCentro) {

		this.ahCodCentro = ahCodCentro;

	}

	public String getAhChannelType() {

		return ahChannelType;

	}

	@XmlElement(name = "ser:ah-channel-type")

	public void setAhChannelType(String ahChannelType) {

		this.ahChannelType = ahChannelType;

	}

	@Override

	public String toString() {

		return "ServiceInput [ahHeaderType=" + ahHeaderType + ", ahUserId=" + ahUserId + ", ahDomainId=" + ahDomainId

				+ ", ahNodeId=" + ahNodeId + ", ahCodCentro=" + ahCodCentro + ", ahChannelType=" + ahChannelType + "]";

	}

}