package extraction;

import models.xsd.DatiRapportoCCIType;

public class MockDatiRapporto {

	DatiRapportoCCIType temp = new DatiRapportoCCIType();

	public MockDatiRapporto() {
		temp.setNkConto("SF-SomeNkCOnto");
		temp.setNkSportello("SF-someNkSportello");
		temp.setServiceInput("SF-someServiceInput");

	}

	public DatiRapportoCCIType getDatiRapporto() {
		return temp;
	}
}
