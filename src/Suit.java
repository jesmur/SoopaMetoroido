
public class Suit extends Upgrade{
	
	private int defenceBonus;
	private int speedBonus;
	
	// constructor	
	Suit(String name, String desc, int cost, boolean bought, boolean equipped, int defenceBonus, int speedBonus){
		super(name, desc, cost, bought, equipped);
		this.defenceBonus = defenceBonus;
		this.speedBonus = speedBonus;
	}
	
	// getters and setters
	int getDefenceBonus() {
		return defenceBonus;
	}

	void setDefenceBonus(int defenceBonus) {
		this.defenceBonus = defenceBonus;
	}

	int getSpeedBonus() {
		return speedBonus;
	}

	void setSpeedBonus(int speedBonus) {
		this.speedBonus = speedBonus;
	}
	// end getters and setters

}
