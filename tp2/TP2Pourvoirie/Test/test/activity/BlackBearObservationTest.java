package test.activity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import implement.lodgeMock.LodgeMock;
import implementation.activity.BlackBearObservation;
import implementation.lodgeOptions.FourPeopleLodge;

class BlackBearObservationTest {
	
	private BlackBearObservation blackBearObservation;
	private FourPeopleLodge lodgeMock;
	
	
	@BeforeEach
	public void initializeBlackBearObservation() {
		lodgeMock = new LodgeMock(LodgeMock.NB_DAYS, LodgeMock.NB_PEOPLE);
		blackBearObservation = new BlackBearObservation(lodgeMock, LodgeMock.NB_DAYS, LodgeMock.NB_PEOPLE);
	}
	
	
	@Test
	public void GIVEN_BlackBearObservation_WHEN_AskedForPrice_RETURN_Price() {
		//Act
		final int EXPECTED_PRICE = LodgeMock.NB_DAYS * LodgeMock.NB_PEOPLE * BlackBearObservation.UNIT_COST;
		
		//Assert
		assertEquals(EXPECTED_PRICE, blackBearObservation.calculateCost());
	}

}
