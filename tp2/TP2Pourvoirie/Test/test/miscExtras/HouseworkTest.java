package test.miscExtras;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import implement.lodgeMock.LodgeMock;
import implementation.lodgeOptions.FourPeopleLodge;
import implementation.miscExtras.Housework;

class HouseworkTest {

	private FourPeopleLodge lodgeMock;
	private Housework housework;
	
	@BeforeEach
	public void initializeHousework() {
		lodgeMock = new LodgeMock(LodgeMock.NB_DAYS, LodgeMock.NB_PEOPLE);
		housework = new Housework(lodgeMock, LodgeMock.NB_DAYS);
	}
	
	@Test
	public void GIVEN_Housework_WHEN_AskedForPrice_RETURN_Price() {
		//Act
		final int EXPECTED_PRICE = Housework.UNIT_COST * LodgeMock.NB_DAYS;
		
		//Assert
		assertEquals(EXPECTED_PRICE, housework.calculateCost());
	}

}
