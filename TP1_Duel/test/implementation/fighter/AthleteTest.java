package implementation.fighter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import exceptions.fighter.IllegalAthleteStatValue;
import exceptions.fighter.IllegalStatValue;
import implementation.fighter.Athlete;
import implementation.fighter.FighterStat;
import implementation.fighter.Warrior;

class AthleteTest {

	final int ANY_SP = 25;
	final int ANY_DP = 25;
	final int ANY_IP = 25;
	final int ANY_CP = 25;
	
	private Athlete athlete = null;
	
	@BeforeEach
	public void initializeAthlete() {
		athlete = new Athlete(ANY_SP, ANY_DP, ANY_IP, ANY_CP, null, null);
	}
	
	@Test
	void WHEN_AthleteIsCreated_THEN_AthleteStatsAreInitialized() {
		//Assert
		assertEquals(ANY_SP, athlete.getSP());
	}
	
	@Rule
    public ExpectedException ex = ExpectedException.none();
	
	@Test
	public void WHEN_AthleteIsCreated_and_InitialStatValuesAreTooHigh_THEN_RaiseIllegalStatValueExceptionRightMessage() {
		//Arrange
		ex.expect(IllegalStatValue.class);
		ex.expectMessage(IllegalStatValue.TOTAL_STAT_VALUE_TOO_HIGH);
		//Act //Assert
		Assertions.assertThrows(IllegalStatValue.class, () -> {
			new Warrior(ANY_SP + (FighterStat.INITIAL_STAT_LIMIT), ANY_DP, ANY_IP, ANY_CP, null, null);
		    });	
	}
	
	@Test
	public void WHEN_AthleteIsCreated_and_StrengthStatValueIsntRespected_THEN_RaiseIllegalAthleteStatValueExceptionRightMessage() {
		//Arrange
		ex.expect(IllegalAthleteStatValue.class);
		ex.expectMessage(IllegalAthleteStatValue.ILLEGAL_STAT_VALUE);
		//Act //Assert
		Assertions.assertThrows(IllegalAthleteStatValue.class, () -> {
			new Athlete(0, ANY_DP, ANY_IP, ANY_CP, null, null);
		    });	
	}
	
	@Test
	public void WHEN_AthleteIsCreated_and_DexterityStatValueIsntRespected_THEN_RaiseIllegalWarriorStatValueExceptionRightMessage() {
		//Arrange
		ex.expect(IllegalAthleteStatValue.class);
		ex.expectMessage(IllegalAthleteStatValue.ILLEGAL_STAT_VALUE);
		//Act //Assert
		Assertions.assertThrows(IllegalAthleteStatValue.class, () -> {
			new Athlete(ANY_SP, 0, ANY_IP, ANY_CP, null, null);
		    });	
	}
	
	@Test
	public void WHEN_AthleteIsCreated_and_IntelligenceStatValueIsntRespected_THEN_RaiseIllegalAthleteStatValueExceptionRightMessage() {
		//Arrange
		ex.expect(IllegalAthleteStatValue.class);
		ex.expectMessage(IllegalAthleteStatValue.ILLEGAL_STAT_VALUE);
		//Act //Assert
		Assertions.assertThrows(IllegalAthleteStatValue.class, () -> {
			new Athlete(ANY_SP, ANY_DP, 0, ANY_CP, null, null);
		    });	
	}
	
	@Test
	public void WHEN_AthleteIsCreated_and_ConcentrationStatValueIsntRespected_THEN_RaiseIllegalAthleteStatValueExceptionRightMessage() {
		//Arrange
		ex.expect(IllegalAthleteStatValue.class);
		ex.expectMessage(IllegalAthleteStatValue.ILLEGAL_STAT_VALUE);
		//Act //Assert
		Assertions.assertThrows(IllegalAthleteStatValue.class, () -> {
			new Athlete(ANY_SP, ANY_DP, ANY_IP, 0, null, null);
		    });	
	}

}
