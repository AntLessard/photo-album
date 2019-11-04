package test.activity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import exceptions.activity.IllegalNumberOfParticipants;
import implement.lodgeMock.LodgeMock;
import implementation.activity.GuidedDayFishing;
import implementation.lodgeOptions.FourPeopleLodge;

class GuidedDayFishingTest {

	private GuidedDayFishing guidedDayFishing;
	private FourPeopleLodge lodgeMock;
	
	@BeforeEach
	public void initializeGuidedDayFishing() {
		lodgeMock = new LodgeMock(LodgeMock.NB_DAYS, LodgeMock.NB_PEOPLE);
		guidedDayFishing = new GuidedDayFishing(lodgeMock, LodgeMock.NB_DAYS, LodgeMock.NB_PEOPLE);
	}
	
	@Test
	void GIVEN_GuidedDayFishing_WHEN_AskedForPrice_RETURN_Price() {
		//Act
		final int EXPECTED_PRICE = GuidedDayFishing.UNIT_COST * LodgeMock.NB_DAYS;
		
		//Assert
		assertEquals(EXPECTED_PRICE, guidedDayFishing.calculateCost());
	}

	@Rule
    public ExpectedException ex = ExpectedException.none();
	
	@Test
	public void WHEN_GuidedDayFishingIsCreated_and_NumberOfPeopleRegisteredSurpassesGroupCapacity_THEN_RaiseIllegalNumberOfPeopleExceptionRightMessage(){
		//Arrange
		ex.expect(IllegalNumberOfParticipants.class);
		ex.expectMessage(IllegalNumberOfParticipants.FISHING_PARTICIPANT_LIMIT_REACHED);
		//Act //Assert
		Assertions.assertThrows(IllegalNumberOfParticipants.class, () -> {
			new GuidedDayFishing(lodgeMock, LodgeMock.NB_DAYS, GuidedDayFishing.MAX_CAPACITY + 1);
		});
	}
	
}
