package implementation.capacity;

import abstracts.capacity.ICapacity;
import abstracts.capacity.IOffense;
import implementation.fighter.FighterStat;

public class Sword extends Capacity implements IOffense{
	
	public Sword(int charc) {
		super(charc);
	}

	public int calculatePower(ICapacity capacity, FighterStat fighterStat) {
		int power = fighterStat.sp * this.getCharc() / 100;
		return power;
	}

}
