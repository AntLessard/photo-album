package exceptions.duel;

@SuppressWarnings("serial")
public class IllegalCapacityUsedInEngagement extends IllegalArgumentException{
	public static final String ILLEGAL_ENGAGEMENT_CAPACITY_TYPE = "Attacker used a non offensive capacity! His opponent laughs and proceeds to leave.";
	
	public static final String ILLEGAL_RETALIATION_CAPACITY_TYPE = "The defender cannot heal right now, there are opponents nearby";
	
	public IllegalCapacityUsedInEngagement(String s) {
		super(s);
	}
}
