package test.transport;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import implement.lodgeMock.LodgeMock;
import implementation.lodgeOptions.FourPeopleLodge;
import implementation.transport.Seaplane;

class SeaplaneTest {

	private static final int ANY_NB_RIDES = 2;
	private FourPeopleLodge lodgeMock;
	private Seaplane seaplane;
	
	@BeforeEach
	public void initializeSeaplane() {
		lodgeMock = new LodgeMock(LodgeMock.NB_DAYS, LodgeMock.NB_PEOPLE);
		seaplane = new Seaplane(lodgeMock, ANY_NB_RIDES,  LodgeMock.NB_DAYS);
	}
	
	@Test
	public void GIVEN_Seaplane_WHEN_AskedForPrice_RETURN_Price() {
		//Act
		final int EXPECTED_PRICE = Seaplane.UNIT_COST * LodgeMock.NB_DAYS * ANY_NB_RIDES;
		
		//Assert
		assertEquals(EXPECTED_PRICE, seaplane.calculateCost());
	}

}
