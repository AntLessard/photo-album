package test.meals;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import implement.lodgeMock.LodgeMock;
import implementation.lodgeOptions.FourPeopleLodge;
import implementation.meals.BreakfastDinner;

class BreakfastDinnerTest {

	private BreakfastDinner breakfastDinner;
	private FourPeopleLodge lodgeMock;
	
	
	@BeforeEach
	public void initializeBreakfastDinner() {
		lodgeMock = new LodgeMock(LodgeMock.NB_DAYS, LodgeMock.NB_PEOPLE);
		breakfastDinner = new BreakfastDinner(lodgeMock, LodgeMock.NB_DAYS, LodgeMock.NB_PEOPLE);
	}
	
	
	@Test
	public void GIVEN_BreakfastDinner_WHEN_AskedForPrice_RETURN_Price() {
		//Act
		final int EXPECTED_PRICE = LodgeMock.NB_DAYS * LodgeMock.NB_PEOPLE * BreakfastDinner.UNIT_COST;
		
		//Assert
		assertEquals(EXPECTED_PRICE, breakfastDinner.calculateCost());
	}

}
