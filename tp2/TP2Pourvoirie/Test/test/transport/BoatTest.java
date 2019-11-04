package test.transport;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import implement.lodgeMock.LodgeMock;
import implementation.lodgeOptions.FourPeopleLodge;
import implementation.transport.Boat;

class BoatTest {

	private static final int ANY_NB_RIDES = 2;
	private FourPeopleLodge lodgeMock;
	private Boat boat;
	
	@BeforeEach
	public void initializeBoat() {
		lodgeMock = new LodgeMock(LodgeMock.NB_DAYS, LodgeMock.NB_PEOPLE);
		boat = new Boat(lodgeMock, ANY_NB_RIDES,  LodgeMock.NB_DAYS);
	}
	
	@Test
	public void GIVEN_Boat_WHEN_AskedForPrice_RETURN_Price() {
		//Act
		final int EXPECTED_PRICE = Boat.UNIT_COST * LodgeMock.NB_DAYS * ANY_NB_RIDES;
		
		//Assert
		assertEquals(EXPECTED_PRICE, boat.calculateCost());
	}
}
