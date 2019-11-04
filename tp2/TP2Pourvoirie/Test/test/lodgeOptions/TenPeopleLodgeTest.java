package test.lodgeOptions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import exceptions.lodgeOptions.IllegalNumberOfPeople;
import implementation.lodgeOptions.TenPeopleLodge;

class TenPeopleLodgeTest {

	private final static int ANY_NB_OF_PEOPLE = 10;
	private final static int ANY_NB_OF_DAYS = 6;
	
	private TenPeopleLodge tenPeopleLodge;

	@BeforeEach
	public void initializeTenPeopleLodge() {
		tenPeopleLodge = new TenPeopleLodge(ANY_NB_OF_DAYS, ANY_NB_OF_PEOPLE);
	}
	
	@Test
	void GIVEN_TenPeopleLodge_WHEN_AskedForPrice_RETURNS_PriceOfLodge() {
		//Act
		final int EXPECTED_LODGE_PRICE = ANY_NB_OF_DAYS * TenPeopleLodge.PRICE_PER_NIGHT;
		//Assert
		assertEquals(EXPECTED_LODGE_PRICE, tenPeopleLodge.calculateCost());
	}
	
	@Rule
    public ExpectedException ex = ExpectedException.none();
	
	@Test
	public void WHEN_LodgeIsCreated_and_NumberOfPeopleRegisteredSurpassesCapacity_THEN_RaiseIllegalNumberOfPeopleExceptionRightMessage(){
		//Arrange
		ex.expect(IllegalNumberOfPeople.class);
		ex.expectMessage(IllegalNumberOfPeople.TEN_PEOPLE_LODGE_CAPACITY_LIMIT_SURPASSED);
		//Act //Assert
		Assertions.assertThrows(IllegalNumberOfPeople.class, () -> {
			new TenPeopleLodge(ANY_NB_OF_DAYS, TenPeopleLodge.MAX_CAPACITY + 1);
		});
	}

}
