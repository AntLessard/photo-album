package implementation.capacity;

import abstracts.capacity.ICapacity;
import abstracts.capacity.IHealing;
import implementation.fighter.FighterStat;

public class HealPotion extends Capacity implements IHealing{

	public HealPotion(int charc) {
		super(charc);
	}

	public int calculatePower(ICapacity capacity, FighterStat fighterStat) {
		int power = fighterStat.dp * this.getCharc() / 100;
		return power;
	}

}
