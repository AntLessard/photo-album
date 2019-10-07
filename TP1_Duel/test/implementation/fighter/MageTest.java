package implementation.fighter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import exceptions.fighter.IllegalMageStatDistribution;
import exceptions.fighter.IllegalStatValue;
import implementation.fighter.FighterStat;
import implementation.fighter.Mage;

class MageTest {

	final int ANY_SP = 10;
	final int ANY_DP = 5;
	final int ANY_IP = 25;
	final int ANY_CP = 25;

	private Mage mage = null;
	
	@BeforeEach
	public void initializeMage() {
		mage = new Mage(ANY_SP, ANY_DP, ANY_IP, ANY_CP, null, null);
	}
	
	@Test
	void WHEN_MageIsCreated_THEN_MageStatsAreInitialized() {
		//Assert
		assertEquals(ANY_SP, mage.getSP());
	}
	
	@Rule
    public ExpectedException ex = ExpectedException.none();
	
	@Test
	public void WHEN_MageIsCreated_and_InitialStatValuesAreTooHigh_THEN_RaiseIllegalStatValueExceptionRightMessage() {
		//Arrange
		ex.expect(IllegalStatValue.class);
		ex.expectMessage(IllegalStatValue.TOTAL_STAT_VALUE_TOO_HIGH);
		//Act //Assert
		Assertions.assertThrows(IllegalStatValue.class, () -> {
			new Mage(ANY_SP + (FighterStat.INITIAL_STAT_LIMIT + 1), ANY_DP, ANY_IP, ANY_CP, null, null);
		    });	
	}
	
	@Test
	public void WHEN_MageIsCreated_and_IntelligenceStatDistributionIsntRespected_THEN_RaiseIllegalMageStatDistributionExceptionRightMessage() {
		//Arrange
		ex.expect(IllegalMageStatDistribution.class);
		ex.expectMessage(IllegalMageStatDistribution.ILLEGAL_STAT_DISTRIBUTION);
		//Act //Assert
		Assertions.assertThrows(IllegalMageStatDistribution.class, () -> {
			new Mage(ANY_SP + (Mage.MIN_IP_STAT_DIFF + 1), ANY_DP, ANY_IP, ANY_CP, null, null);
		    });	
	}

	@Test
	public void WHEN_MageIsCreated_and_ConcentrationStatDistributionIsntRespected_THEN_RaiseIllegalMageStatDistributionExceptionRightMessage() {
		//Arrange
		ex.expect(IllegalMageStatDistribution.class);
		ex.expectMessage(IllegalMageStatDistribution.ILLEGAL_STAT_DISTRIBUTION);
		//Act //Assert
		Assertions.assertThrows(IllegalMageStatDistribution.class, () -> {
			new Mage(ANY_SP + (Mage.MIN_IP_STAT_DIFF + 1), ANY_DP, ANY_IP, ANY_CP, null, null);
		    });	
	}


}
