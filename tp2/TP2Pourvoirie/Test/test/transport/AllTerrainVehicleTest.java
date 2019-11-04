package test.transport;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import implement.lodgeMock.LodgeMock;
import implementation.lodgeOptions.FourPeopleLodge;
import implementation.transport.AllTerrainVehicle;

class AllTerrainVehicleTest {

	private static final int ANY_NB_VEHICLE = 2;
	private FourPeopleLodge lodgeMock;
	private AllTerrainVehicle allTerrainVehicle;
	
	@BeforeEach
	public void initializeAllTerrainVehicle() {
		lodgeMock = new LodgeMock(LodgeMock.NB_DAYS, LodgeMock.NB_PEOPLE);
		allTerrainVehicle = new AllTerrainVehicle(lodgeMock, LodgeMock.NB_DAYS, ANY_NB_VEHICLE);
	}
	
	@Test
	public void GIVEN_AllTerrainVehicle_WHEN_AskedForPrice_RETURN_Price() {
		//Act
		final int EXPECTED_PRICE = AllTerrainVehicle.UNIT_COST * LodgeMock.NB_DAYS * ANY_NB_VEHICLE;
		
		//Assert
		assertEquals(EXPECTED_PRICE, allTerrainVehicle.calculateCost());
	}

}
