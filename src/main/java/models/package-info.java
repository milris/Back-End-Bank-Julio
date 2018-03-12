@XmlSchema(
	xmlns = { @XmlNs(prefix = "inp", namespaceURI = "http://exampleprefixes.com/something/inp"),
			@XmlNs(prefix = "ser", namespaceURI = "http://exampleprefixes.com/something/ser") },
	namespace = "",
	elementFormDefault = XmlNsForm.UNQUALIFIED,
	attributeFormDefault = XmlNsForm.UNSET
)
package models;

import javax.xml.bind.annotation.*;