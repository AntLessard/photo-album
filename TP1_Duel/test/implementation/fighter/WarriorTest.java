package implementation.fighter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import exceptions.fighter.IllegalStatValue;
import exceptions.fighter.IllegalWarriorStatDistribution;
import implementation.fighter.FighterStat;
import implementation.fighter.Warrior;

class WarriorTest {

	final int ANY_SP = 30;
	final int ANY_DP = 20;
	final int ANY_IP = 10;
	final int ANY_CP = 10;
	
	private Warrior warrior = null;
	
	@BeforeEach
	public void initializeWarrior() {
		warrior = new Warrior(ANY_SP, ANY_DP, ANY_IP, ANY_CP, null, null);
	}
	
	@Test
	void WHEN_WarriorIsCreated_THEN_WarriorStatsAreInitialized() {
		//Assert
		assertEquals(ANY_SP, warrior.getSP());
	}

	@Rule
    public ExpectedException ex = ExpectedException.none();
	
	@Test
	public void WHEN_WarriorIsCreated_and_InitialStatValuesAreTooHigh_THEN_RaiseIllegalStatValueExceptionRightMessage() {
		//Arrange
		ex.expect(IllegalStatValue.class);
		ex.expectMessage(IllegalStatValue.TOTAL_STAT_VALUE_TOO_HIGH);
		//Act //Assert
		Assertions.assertThrows(IllegalStatValue.class, () -> {
			new Warrior(ANY_SP + (FighterStat.INITIAL_STAT_LIMIT + 1), ANY_DP, ANY_IP, ANY_CP, null, null);
		    });	
	}
	
	@Test
	public void WHEN_WarriorIsCreated_and_StrengthStatDistributionIsntRespected_THEN_RaiseIllegalWarriorStatDistributionExceptionRightMessage() {
		//Arrange
		ex.expect(IllegalWarriorStatDistribution.class);
		ex.expectMessage(IllegalWarriorStatDistribution.ILLEGAL_STAT_DISTRIBUTION);
		//Act //Assert
		Assertions.assertThrows(IllegalWarriorStatDistribution.class, () -> {
			new Warrior(ANY_SP, ANY_DP + (Warrior.MIN_SP_DP_DIFFERENCE + 1), ANY_IP, ANY_CP, null, null);
		    });	
	}
	
	@Test
	public void WHEN_WarriorIsCreated_and_DexterityStatDistributionIsntRespected_THEN_RaiseIllegalWarriorStatDistributionExceptionRightMessage() {
		//Arrange
		ex.expect(IllegalWarriorStatDistribution.class);
		ex.expectMessage(IllegalWarriorStatDistribution.ILLEGAL_STAT_DISTRIBUTION);
		//Act //Assert
		Assertions.assertThrows(IllegalWarriorStatDistribution.class, () -> {
			new Warrior(ANY_SP, ANY_DP, ANY_IP + (Warrior.MIN_DP_IP_DIFFERENCE + 1), ANY_CP, null, null);
		    });	
	}
}
