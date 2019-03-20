
public class Hero extends Player {
	
	private int credits;
	private int currentAttack;
	private int currentDefence;
	
	Hero(String name, int hitPoints, int attack, int defence, int speed, int credits, int currentAttack, int currentDefence) {
		this.setName(name);
		this.setHitPoints(hitPoints);
		this.setAttack(attack);
		this.setDefence(defence);
		this.setSpeed(speed);
		this.setCredits(credits);
		this.setCurrentAttack(currentAttack);
		this.setCurrentDefence(currentDefence);
	}
	
	// getters and setters
	int getCredits() {
		return credits;
	}

	void setCredits(int credits) {
		this.credits = credits;
	}

	int getCurrentAttack() {
		return currentAttack;
	}

	void setCurrentAttack(int currentAttack) {
		this.currentAttack = currentAttack;
	}

	int getCurrentDefence() {
		return currentDefence;
	}

	void setCurrentDefence(int currentDefence) {
		this.currentDefence = currentDefence;
	}
	
	// end getters and setters
	
	
	// abstract methods to return base stats if no upgrades are equipped, or current stats if upgrades are equipped 
	@Override
	public int attack() {
		if(currentAttack != 0) {
			return currentAttack;
		}
		else {
			return attack;
		}
	}
	
	@Override
	public int defend() {
		if(currentDefence != 0) {
			return currentDefence;
		}
		else {
			return getDefence();
		}
	}	
}
