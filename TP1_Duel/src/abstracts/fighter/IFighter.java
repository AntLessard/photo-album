package abstracts.fighter;

import abstracts.capacity.ICapacity;

public interface IFighter {

	public int getSP();
	
	public int getDP();
	
	public int getIP();
	
	public int getCP();
	
	public void addCapacity(ICapacity capacity);
	
	public int getPower(ICapacity capacity);
}
