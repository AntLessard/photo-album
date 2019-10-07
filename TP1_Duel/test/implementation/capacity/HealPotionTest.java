package implementation.capacity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import exceptions.capacity.IllegalInitialCharcValue;
import implementation.fighter.FighterStat;

class HealPotionTest {

	private static final int ANY_SP = 20;
	private static final int ANY_DP = 20;
	private static final int ANY_IP = 20;
	private static final int ANY_CP = 20;
	
	final int ANY_CHARC = Capacity.MIN_CHARC_VALUE + 1;
	private Capacity healPotion = null;
	
	@BeforeEach
	public void initializeHealPotion() {
		healPotion = new HealPotion(ANY_CHARC);
	}
	

	@Test
	void WHEN_HealPotionIsCreated_THEN_HealPotionHasCharacteristic() {
		//Assert
		assertEquals(ANY_CHARC, healPotion.getCharc());
	}
	
	@Test 
	void GIVEN_HealPotion_WHEN_AskedForPower_THEN_CalculatesPower() {
		FighterStat fighterStatMock = new FighterStatMock(ANY_SP, ANY_DP, ANY_IP, ANY_CP);
		//Assert
		final int EXPECTED_POWER = fighterStatMock.dp * healPotion.getCharc() / 100;
		assertEquals(EXPECTED_POWER, healPotion.calculatePower(healPotion, fighterStatMock));
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
			new HealPotion(Capacity.MIN_CHARC_VALUE - 1);
		    });	
	}
	
	@Test
	public void WHEN_CapacityIsCreated_and_InitialCharcValueIsTooHigh_THEN_RaiseIllegalInitialCharcValueExceptionRightMessage() {
		//Arrange
		ex.expect(IllegalInitialCharcValue.class);
		ex.expectMessage(IllegalInitialCharcValue.CHARC_VALUE_OOB);
		//Act //Assert
		Assertions.assertThrows(IllegalInitialCharcValue.class, () -> {
			new HealPotion(Capacity.MAX_CHARC_VALUE + 1);
		    });	
	}

}

