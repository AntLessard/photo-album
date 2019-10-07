package simulator;

import abstracts.capacity.ICapacity;
import implementation.capacity.FireballSpell;
import implementation.capacity.HealPotion;
import implementation.capacity.Shield;
import implementation.capacity.ShieldSpell;
import implementation.capacity.Sword;
import implementation.duel.Duel;
import implementation.fighter.Athlete;
import implementation.fighter.Fighter;
import implementation.fighter.Mage;
import implementation.fighter.Warrior;

public class Simulator {
	
	public static void main(String[] args) {
		ICapacity shield = new Shield(30);
		ICapacity sword = new Sword(50);
		Fighter attacker = new Warrior(30, 20, 10, 10, sword, shield);
		ICapacity fireballSpell = new FireballSpell(20);
		ICapacity healSpell = new ShieldSpell(60);
		Fighter defender = new Mage(10, 5, 25, 25, fireballSpell, healSpell);
		
		System.out.println("Before duel");
		System.out.println("Attacker SP: " + attacker.fighterStat.sp);
		System.out.println("Attacker number of Capacities: " + attacker.capacityList.size());
		System.out.println("Defender SP: " + defender.fighterStat.sp);
		System.out.println("Defender HP: " + defender.fighterStat.hp);

		Duel duel = new Duel(attacker, defender, attacker.selectCapacity(0));
		duel.acceptEngagement(defender.selectCapacity(0));
		
		System.out.println("After duel (Attacker win by tie)");
		System.out.println("Attacker SP: " + attacker.fighterStat.sp);
		System.out.println("Attacker number of Capacities: " + attacker.capacityList.size());
		System.out.println("Defender SP: " + defender.fighterStat.sp);
		System.out.println("Defender HP: " + defender.fighterStat.hp);
	
		ICapacity shieldSpell = new ShieldSpell(80);
		ICapacity healPotion = new HealPotion(50); 
		Fighter defenderRound2 = new Athlete(20, 20, 40, 20, shieldSpell, healPotion);
		
		
		
		System.out.println("");
		System.out.println("Before duel");
		System.out.println("Attacker SP: " + attacker.fighterStat.sp);
		System.out.println("Attacker HP: " + attacker.fighterStat.hp);
		System.out.println("Defender SP: " + defenderRound2.fighterStat.sp);
		System.out.println("Defender number of Capacities: " + defenderRound2.capacityList.size());
		
		Duel duelRound2 = new Duel(attacker, defenderRound2, attacker.selectCapacity(0));
		duelRound2.acceptEngagement(defenderRound2.selectCapacity(0));
		
		System.out.println("After duel (Defender win by combat)");
		System.out.println("Attacker SP: " + attacker.fighterStat.sp);
		System.out.println("Attacker HP: " + attacker.fighterStat.hp);
		System.out.println("Defender SP: " + defenderRound2.fighterStat.sp);
		System.out.println("Defender number of Capacities: " + defenderRound2.capacityList.size());
		
		Fighter defenderRound3 = new Mage(5, 5, 20, 25, fireballSpell, healSpell);
		
		System.out.println("");
		System.out.println("Before duel");
		System.out.println("Attacker SP: " + attacker.fighterStat.sp);
		System.out.println("Attacker number of Capacities: " + attacker.capacityList.size());
		System.out.println("Defender SP: " + defenderRound3.fighterStat.sp);
		System.out.println("Defender HP: " + defenderRound3.fighterStat.hp);
		
		Duel duelRound3 = new Duel(attacker, defenderRound3, attacker.selectCapacity(0));
		duelRound3.denyEngagement();
		
		System.out.println("After duel (Attacker win by capitulation)");
		System.out.println("Attacker SP: " + attacker.fighterStat.sp);
		System.out.println("Attacker number of Capacities: " + attacker.capacityList.size());
		System.out.println("Defender SP: " + defenderRound3.fighterStat.sp);
		System.out.println("Defender HP: " + defenderRound3.fighterStat.hp);
	}
}