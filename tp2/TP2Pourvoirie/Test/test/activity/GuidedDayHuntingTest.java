package test.activity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import exceptions.activity.IllegalNumberOfParticipants;
import implement.lodgeMock.LodgeMock;
import implementation.activity.GuidedDayHunting;
import implementation.lodgeOptions.FourPeopleLodge;

class GuidedDayHuntingTest {

	private GuidedDayHunting guidedDayHunting;
	private FourPeopleLodge lodgeMock;
	
	@BeforeEach
	public void initializeGuidedDayHunting() {
		lodgeMock = new LodgeMock(LodgeMock.NB_DAYS, LodgeMock.NB_PEOPLE);
		guidedDayHunting = new GuidedDayHunting(lodgeMock, LodgeMock.NB_DAYS, LodgeMock.NB_PEOPLE);
	}
	
	@Test
	void GIVEN_GuidedDayHunting_WHEN_AskedForPrice_RETURN_Price() {
		//Act
		final int EXPECTED_PRICE = GuidedDayHunting.UNIT_COST * LodgeMock.NB_DAYS;
		
		//Assert
		assertEquals(EXPECTED_PRICE, guidedDayHunting.calculateCost());
	}

	@Rule
    public ExpectedException ex = ExpectedException.none();
	
	@Test
	public void WHEN_GuidedDayHuntingIsCreated_and_NumberOfPeopleRegisteredSurpassesGroupCapacity_THEN_RaiseIllegalNumberOfPeopleExceptionRightMessage(){
		//Arrange
		ex.expect(IllegalNumberOfParticipants.class);
		ex.expectMessage(IllegalNumberOfParticipants.HUNTING_PARTICIPANT_LIMIT_REACHED);
		//Act //Assert
		Assertions.assertThrows(IllegalNumberOfParticipants.class, () -> {
			new GuidedDayHunting(lodgeMock, LodgeMock.NB_DAYS, GuidedDayHunting.MAX_CAPACITY + 1);
		});
	}

}
