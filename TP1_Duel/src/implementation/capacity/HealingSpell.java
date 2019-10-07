package implementation.capacity;

import abstracts.capacity.ICapacity;
import abstracts.capacity.IHealing;
import implementation.fighter.FighterStat;

public class HealingSpell extends Capacity implements IHealing{

	public HealingSpell(int charc) {
		super(charc);
	}
	
	public int calculatePower(ICapacity capacity, FighterStat fighterStat) {
		int power = fighterStat.ip * this.getCharc() / 100;
		return power;
	}

}
