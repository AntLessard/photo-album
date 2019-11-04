package test.lodgeOptions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import exceptions.lodgeOptions.IllegalNumberOfPeople;
import implementation.lodgeOptions.SixPeopleLodge;

class SixPeopleLodgeTest {

	private final static int ANY_NB_OF_PEOPLE = 6;
	private final static int ANY_NB_OF_DAYS = 6;
	
	private SixPeopleLodge sixPeopleLodge;

	@BeforeEach
	public void initializeSixPeopleLodge() {
		sixPeopleLodge = new SixPeopleLodge(ANY_NB_OF_DAYS, ANY_NB_OF_PEOPLE);
	}
	
	@Test
	void GIVEN_SixPeopleLodge_WHEN_AskedForPrice_RETURNS_PriceOfLodge() {
		//Act
		final int EXPECTED_LODGE_PRICE = ANY_NB_OF_DAYS * SixPeopleLodge.PRICE_PER_NIGHT;
		//Assert
		assertEquals(EXPECTED_LODGE_PRICE, sixPeopleLodge.calculateCost());
	}
	
	@Rule
    public ExpectedException ex = ExpectedException.none();
	
	@Test
	public void WHEN_LodgeIsCreated_and_NumberOfPeopleRegisteredSurpassesCapacity_THEN_RaiseIllegalNumberOfPeopleExceptionRightMessage(){
		//Arrange
		ex.expect(IllegalNumberOfPeople.class);
		ex.expectMessage(IllegalNumberOfPeople.SIX_PEOPLE_LODGE_CAPACITY_LIMIT_SURPASSED);
		//Act //Assert
		Assertions.assertThrows(IllegalNumberOfPeople.class, () -> {
			new SixPeopleLodge(ANY_NB_OF_DAYS, SixPeopleLodge.MAX_CAPACITY + 1);
		});
	}

}
