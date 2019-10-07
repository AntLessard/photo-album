package abstracts.duel;

import abstracts.capacity.ICapacity;

public interface IDuel {
	
	public void acceptEngagement(ICapacity retaliationCapacity);
	
	public void denyEngagement();
}
