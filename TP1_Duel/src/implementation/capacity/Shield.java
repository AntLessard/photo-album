package implementation.capacity;

import abstracts.capacity.ICapacity;
import abstracts.capacity.IDefense;
import implementation.fighter.FighterStat;

public class Shield extends Capacity implements IDefense{

	public Shield(int charc) {
		super(charc);
	}
	
	public int calculatePower(ICapacity capacity, FighterStat fighterStat) {
		int power = fighterStat.sp * this.getCharc() / 100;
		return power;
	}

}
