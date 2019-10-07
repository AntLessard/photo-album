package implementation.capacity;

import abstracts.capacity.ICapacity;
import abstracts.capacity.IDefense;
import implementation.fighter.FighterStat;

public class ShieldSpell extends Capacity implements IDefense{

	public ShieldSpell(int charc) {
		super(charc);
	}
	
	public int calculatePower(ICapacity capacity, FighterStat fighterStat) {
		int power = (fighterStat.ip * this.getCharc() / 100) * 3;
		return power;
	}

}
