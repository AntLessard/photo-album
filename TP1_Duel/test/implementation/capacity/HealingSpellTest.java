package implementation.capacity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import exceptions.capacity.IllegalInitialCharcValue;
import implementation.fighter.FighterStat;

class HealingSpellTest {

	private static final int ANY_SP = 20;
	private static final int ANY_DP = 20;
	private static final int ANY_IP = 20;
	private static final int ANY_CP = 20;
	
	final int ANY_CHARC = Capacity.MIN_CHARC_VALUE + 1;
	private Capacity healingSpell = null;
	
	@BeforeEach
	public void initializeHealingSpell() {
		healingSpell = new HealingSpell(ANY_CHARC);
	}
	

	@Test
	void WHEN_HealingSpellIsCreated_THEN_HealingSpellHasCharacteristic() {
		//Assert
		assertEquals(ANY_CHARC, healingSpell.getCharc());
	}
	
	@Test 
	void GIVEN_HealingSpell_WHEN_AskedForPower_THEN_CalculatesPower() {
		FighterStat fighterStatMock = new FighterStatMock(ANY_SP, ANY_DP, ANY_IP, ANY_CP);
		//Assert
		final int EXPECTED_POWER = fighterStatMock.ip * healingSpell.getCharc() / 100;
		assertEquals(EXPECTED_POWER, healingSpell.calculatePower(healingSpell, fighterStatMock));
	}
	
	@Rule
	public ExpectedException ex = ExpectedException.none();
	
	@Test
	public void WHEN_CapacityIsCreated_and_InitialCharcValueIsTooLow_THEN_RaiseIllegalInitialCharcValueExceptionRightMessage() {
		//Arrange
		ex.expect(IllegalInitialCharcValue.class);
		ex.expectMessage(IllegalInitialCharcValue.CHARC_VALUE_OOB);
		//Act //Assert
		Assertions.assertThrows(IllegalInitialCharcValue.class, () -> {
			new HealingSpell(Capacity.MIN_CHARC_VALUE - 1);
		    });	
	}
	
	@Test
	public void WHEN_CapacityIsCreated_and_InitialCharcValueIsTooHigh_THEN_RaiseIllegalInitialCharcValueExceptionRightMessage() {
		//Arrange
		ex.expect(IllegalInitialCharcValue.class);
		ex.expectMessage(IllegalInitialCharcValue.CHARC_VALUE_OOB);
		//Act //Assert
		Assertions.assertThrows(IllegalInitialCharcValue.class, () -> {
			new HealingSpell(Capacity.MAX_CHARC_VALUE + 1);
		    });	
	}

}

