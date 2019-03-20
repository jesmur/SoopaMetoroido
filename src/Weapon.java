
public class Weapon extends Upgrade{
	
	private int attackBonus;
	
	// constructor 	
	Weapon(String name, String desc, int cost, boolean bought, boolean equipped, int attackBonus){
		super(name, desc, cost, bought, equipped);
		this.attackBonus = attackBonus;
	}

	// getters and setters
	int getAttackBonus() {
		return attackBonus;
	}

	public void setAttackBonus(int attackBonus) {
		this.attackBonus = attackBonus;
	}
	// end getters and setters

}
