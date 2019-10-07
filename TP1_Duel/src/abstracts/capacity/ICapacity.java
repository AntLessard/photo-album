package abstracts.capacity;

import implementation.fighter.FighterStat;

public interface ICapacity {

	public int getCharc();
	
	public int calculatePower(ICapacity capacity, FighterStat fighterStat);
	
}
